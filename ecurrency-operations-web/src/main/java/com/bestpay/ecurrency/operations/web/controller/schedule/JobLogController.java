package com.bestpay.ecurrency.operations.web.controller.schedule;


import com.bestpay.ecurrency.core.router.HandlerRouter;
import com.bestpay.ecurrency.core.router.model.RequestModel;
import com.bestpay.ecurrency.core.router.model.ResponseModel;
import com.bestpay.ecurrency.core.util.XxlJobNetCommUtil;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobGroupMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobInfoMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobLogMapper;
import com.bestpay.ecurrency.operations.dal.model.ReturnTDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobLogDO;
import com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * index controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@Controller
@RequestMapping("/joblog")
public class JobLogController {

	@Autowired
	private IXxlJobGroupMapper xxlJobGroupDao;
	@Autowired
	public IXxlJobInfoMapper xxlJobInfoDao;
	@Autowired
	public IXxlJobLogMapper xxlJobLogDao;

	@PrivilegeValidate(privKey = "/joblog/index")
	@RequestMapping("/index")
	public String index(Model model, String jobGroup, String jobName) {

		// 任务组

		List<XxlJobGroupDO> jobGroupList =  xxlJobGroupDao.findAll();

		model.addAttribute("jobGroup", jobGroup);
		model.addAttribute("jobName", jobName);
		model.addAttribute("JobGroupList", jobGroupList);
		return "schedule/joblog";
	}

	@RequestMapping("/getJobsByGroup")
	@ResponseBody
	public ReturnTDO<List<XxlJobLogDO>> listJobByGroup(String jobGroup){
		List<XxlJobLogDO> list = xxlJobInfoDao.getJobsByGroup(jobGroup);
		return new ReturnTDO<List<XxlJobLogDO>>(list);
	}
	
	@RequestMapping("/pageList")
	@ResponseBody
	public Map<String, Object> pageList(@RequestParam(required = false, defaultValue = "0") int start,
			@RequestParam(required = false, defaultValue = "10") int length,
			int jobGroup, String jobName, String filterTime) {
		
		// parse param
		Date triggerTimeStart = null;
		Date triggerTimeEnd = null;
		if (StringUtils.isNotBlank(filterTime)) {
			String[] temp = filterTime.split(" - ");
			if (temp!=null && temp.length == 2) {
				try {
					triggerTimeStart = DateUtils.parseDate(temp[0], new String[]{"yyyy-MM-dd HH:mm:ss"});
					triggerTimeEnd = DateUtils.parseDate(temp[1], new String[]{"yyyy-MM-dd HH:mm:ss"});
				} catch (ParseException e) {	}
			}
		}
		
		// page query
		List<XxlJobLogDO> list = xxlJobLogDao.pageList(start, length, jobGroup, jobName, triggerTimeStart, triggerTimeEnd);
		int list_count = xxlJobLogDao.pageListCount(start, length, jobGroup, jobName, triggerTimeStart, triggerTimeEnd);
		
		// package result
		Map<String, Object> maps = new HashMap<String, Object>();
	    maps.put("recordsTotal", list_count);		// 总记录数
	    maps.put("recordsFiltered", list_count);	// 过滤后的总记录数
	    maps.put("data", list);  					// 分页列表
		return maps;
	}
	
	/*@RequestMapping("/save")
	@ResponseBody
	@PermessionLimit(limit=false)
	public RemoteCallBack triggerLog(int trigger_log_id, String status, String msg) {
		RemoteCallBack callBack = new RemoteCallBack();
		callBack.setStatus(RemoteCallBack.FAIL);
		XxlJobLogDO log = xxlJobLogDao.load(trigger_log_id);
		if (log!=null) {
			log.setHandleTime(new Date());
			log.setHandleStatus(status);
			log.setHandleMsg(msg);
			xxlJobLogDao.updateHandleInfo(log);
			callBack.setStatus(RemoteCallBack.SUCCESS);
			return callBack;
		}
		return callBack;
	}*/
	
	@RequestMapping("/logDetail")
	@ResponseBody
	public ReturnTDO<String> logDetail(int id){
		// base check
		XxlJobLogDO log = xxlJobLogDao.load(id);
		if (log == null) {
			return new ReturnTDO<String>(500, "查看执行日志失败: 参数异常");
		}
		if (!(ResponseModel.SUCCESS.equals(log.getTriggerStatus()) || StringUtils.isNotBlank(log.getHandleStatus()))) {
			return new ReturnTDO<String>(500, "查看执行日志失败: 任务发起调度失败，无法查看执行日志");
		}
		
		// trigger id, trigger time
		RequestModel requestModel = new RequestModel();
		requestModel.setTimestamp(System.currentTimeMillis());
		requestModel.setAction(HandlerRouter.ActionRepository.LOG.name());
		requestModel.setLogId(id);
		requestModel.setLogDateTim(log.getTriggerTime().getTime());

		ResponseModel responseModel = XxlJobNetCommUtil.postHex(XxlJobNetCommUtil.addressToUrl(log.getExecutorAddress()), requestModel);
		if (ResponseModel.SUCCESS.equals(responseModel.getStatus())) {
			return new ReturnTDO<String>(responseModel.getMsg());
		} else {
			return new ReturnTDO<String>(500, "查看执行日志失败: " + responseModel.getMsg());
		}
	}
	
	@RequestMapping("/logDetailPage")
	public String logDetailPage(int id, Model model){
		ReturnTDO<String> data = logDetail(id);
		model.addAttribute("result", data);
		return "joblog/logdetail";
	}
	
	@RequestMapping("/logKill")
	@ResponseBody
	public ReturnTDO<String> logKill(int id){
		// base check
		XxlJobLogDO log = xxlJobLogDao.load(id);
		XxlJobInfoDO jobInfo = xxlJobInfoDao.load(log.getJobGroup(), log.getJobName());
		if (log == null || jobInfo==null) {
			return new ReturnTDO<String>(500, "参数异常");
		}
		if (!ResponseModel.SUCCESS.equals(log.getTriggerStatus())) {
			return new ReturnTDO<String>(500, "调度失败，无法终止日志");
		}
		
		// request of kill
		RequestModel requestModel = new RequestModel();
		requestModel.setTimestamp(System.currentTimeMillis());
		requestModel.setAction(HandlerRouter.ActionRepository.KILL.name());
		requestModel.setJobGroup(String.valueOf(log.getJobGroup()));
		requestModel.setJobName(log.getJobName());

		ResponseModel responseModel = XxlJobNetCommUtil.postHex(XxlJobNetCommUtil.addressToUrl(log.getExecutorAddress()), requestModel);
		if (ResponseModel.SUCCESS.equals(responseModel.getStatus())) {
			log.setHandleStatus(ResponseModel.FAIL);
			log.setHandleMsg("人为操作主动终止");
			log.setHandleTime(new Date());
			xxlJobLogDao.updateHandleInfo(log);
			return new ReturnTDO<String>(responseModel.getMsg());
		} else {
			return new ReturnTDO<String>(500, responseModel.getMsg());
		}
	}
}

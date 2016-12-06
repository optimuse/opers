package com.bestpay.ecurrency.operations.web.controller.schedule;

import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobInfoMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobLogGlueMapper;
import com.bestpay.ecurrency.operations.dal.model.ReturnTDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobLogGlueDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * job code controller
 * @author xuxueli 2015-12-19 16:13:16
 */
@Controller
@RequestMapping("/jobcode")
public class JobCodeController {
	
	@Autowired
	private IXxlJobInfoMapper xxlJobInfoDao;
	@Autowired
	private IXxlJobLogGlueMapper xxlJobLogGlueDao;

	@RequestMapping
	public String index(Model model, int jobGroup, String jobName) {
		XxlJobInfoDO jobInfo = xxlJobInfoDao.load(jobGroup, jobName);
		List<XxlJobLogGlueDO> jobLogGlues = xxlJobLogGlueDao.selectList(jobGroup, jobName);
		model.addAttribute("jobInfo", jobInfo);
		model.addAttribute("jobLogGlues", jobLogGlues);
		return "jobcode/jobcode.index";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ReturnTDO<String> save(Model model, int jobGroup, String jobName, String glueSource, String glueRemark) {
		// valid
		if (glueRemark==null) {
			return new ReturnTDO<String>(500, "请输入备注");
		}
		if (glueRemark.length()<6 || glueRemark.length()>100) {
			return new ReturnTDO<String>(500, "备注长度应该在6至100之间");
		}
		XxlJobInfoDO jobInfoOld = xxlJobInfoDao.load(jobGroup, jobName);
		if (jobInfoOld == null) {
			return new ReturnTDO<String>(500, "任务不存在");
		}
		
		// log old code
		XxlJobLogGlueDO xxlJobLogGlue = new XxlJobLogGlueDO();
		xxlJobLogGlue.setJobGroup(jobInfoOld.getJobGroup());
		xxlJobLogGlue.setJobName(jobInfoOld.getJobName());
		xxlJobLogGlue.setGlueSource(jobInfoOld.getGlueSource());
		xxlJobLogGlue.setGlueRemark(jobInfoOld.getGlueRemark());
		
		// init new code
		jobInfoOld.setGlueSource(glueSource);
		jobInfoOld.setGlueRemark(glueRemark);
		
		// update new code ,and log old code
		xxlJobInfoDao.update(jobInfoOld);
		if (StringUtils.isNotBlank(xxlJobLogGlue.getGlueSource()) && StringUtils.isNotBlank(xxlJobLogGlue.getGlueRemark())) {
			xxlJobLogGlueDao.save(xxlJobLogGlue);
			// remove code backup more than 30
			xxlJobLogGlueDao.removeOld(xxlJobLogGlue.getJobGroup(), xxlJobLogGlue.getJobName(), 30);
		}
		
		
		return ReturnTDO.SUCCESS;
	}
	
}

package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobGroupMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobInfoMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobLogGlueMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobLogMapper;
import com.bestpay.ecurrency.operations.dal.model.ReturnTDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.manager.core.util.DynamicSchedulerUtil;
import com.bestpay.ecurrency.operations.manager.interfaces.IXxlJobManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * core job action for xxl-job
 * @author xuxueli 2016-5-28 15:30:33
 */
@Slf4j
@Service
public class IXxlJobManagerImpl implements IXxlJobManager {

	@Autowired
	private IXxlJobGroupMapper xxlJobGroupDao;
	@Autowired
	private IXxlJobInfoMapper xxlJobInfoDao;
	@Autowired
	public IXxlJobLogMapper xxlJobLogDao;
	@Autowired
	private IXxlJobLogGlueMapper xxlJobLogGlueDao;

	public Map<String, Object> pageList( int jobGroup, String executorHandler,int start, int length) {

		// page list
		List<XxlJobInfoDO> list = xxlJobInfoDao.pageList( jobGroup, executorHandler,start, length);
		int list_count = xxlJobInfoDao.pageListCount(start, length, jobGroup, executorHandler);
		
		// fill job info
		if (list!=null && list.size()>0) {
			for (XxlJobInfoDO jobInfo : list) {
				DynamicSchedulerUtil.fillJobInfo(jobInfo);
			}
		}
		
		// package result
		Map<String, Object> maps = new HashMap<String, Object>();
	    maps.put("recordsTotal", list_count);		// 总记录数
	    maps.put("recordsFiltered", list_count);	// 过滤后的总记录数
	    maps.put("data", list);  					// 分页列表
		return maps;
	}

	public ReturnTDO<String> add(int jobGroup, String jobCron, String jobDesc,String author, String alarmEmail,
			String executorAddress,	String executorHandler, String executorParam,
			int glueSwitch, String glueSource, String glueRemark, String childJobKey) {
		// valid
		XxlJobGroupDO group = xxlJobGroupDao.load(jobGroup);
		if (group == null) {
			return new ReturnTDO<String>(500, "请选择“执行器”");
		}
		if (!CronExpression.isValidExpression(jobCron)) {
			return new ReturnTDO<String>(500, "请输入格式正确的“Cron”");
		}
		if (StringUtils.isBlank(jobDesc)) {
			return new ReturnTDO<String>(500, "请输入“任务描述”");
		}
		if (StringUtils.isBlank(author)) {
			return new ReturnTDO<String>(500, "请输入“负责人”");
		}
		if (StringUtils.isBlank(alarmEmail)) {
			return new ReturnTDO<String>(500, "请输入“报警邮件”");
		}
		if (glueSwitch==0 && StringUtils.isBlank(executorHandler)) {
			return new ReturnTDO<String>(500, "请输入“JobHandler”");
		}

		// childJobKey valid
		if (StringUtils.isNotBlank(childJobKey)) {
			String[] childJobKeys = childJobKey.split(",");
			for (String childJobKeyItem: childJobKeys) {
				String[] childJobKeyArr = childJobKeyItem.split("_");
				if (childJobKeyArr.length!=2) {
					return new ReturnTDO<String>(500, MessageFormat.format("子任务Key({0})格式错误", childJobKeyItem));
				}
				XxlJobInfoDO childJobInfo = xxlJobInfoDao.load(Integer.valueOf(childJobKeyArr[0]), childJobKeyArr[1]);
				if (childJobInfo==null) {
					return new ReturnTDO<String>(500, MessageFormat.format("子任务Key({0})无效", childJobKeyItem));
				}
			}
		}

		// generate jobName
		String jobName = FastDateFormat.getInstance("yyyyMMddHHmmssSSSS").format(new Date());
		try {
			if (DynamicSchedulerUtil.checkExists(jobName, String.valueOf(jobGroup))) {
				return new ReturnTDO<String>(500, "系统繁忙，请稍后重试");
			}
		} catch (SchedulerException e1) {
			e1.printStackTrace();
			return new ReturnTDO<String>(500, "系统繁忙，请稍后重试");
		}

		// Backup to the database
		XxlJobInfoDO jobInfo = new XxlJobInfoDO();
		jobInfo.setJobGroup(jobGroup);
		jobInfo.setJobName(jobName);
		jobInfo.setJobCron(jobCron);
		jobInfo.setJobDesc(jobDesc);
		jobInfo.setAuthor(author);
		jobInfo.setAlarmEmail(alarmEmail);
		jobInfo.setExecutorHandler(executorHandler);
		jobInfo.setExecutorParam(executorParam);
		jobInfo.setGlueSwitch(glueSwitch);
		jobInfo.setGlueSource(glueSource);
		jobInfo.setGlueRemark(glueRemark);
		jobInfo.setChildJobKey(childJobKey);

		try {
			// add job 2 quartz
			boolean result = DynamicSchedulerUtil.addJob(String.valueOf(jobGroup), jobName, jobCron);
			if (result) {
				xxlJobInfoDao.save(jobInfo);
				return ReturnTDO.SUCCESS;
			} else {
				return new ReturnTDO<String>(500, "新增任务失败");
			}
		} catch (SchedulerException e) {
			log.error("", e);
		}
		return ReturnTDO.FAIL;
	}

	public ReturnTDO<String> reschedule(int jobGroup, String jobName, String jobCron, String jobDesc, String author, String alarmEmail,
			String executorAddress, String executorHandler, String executorParam, int glueSwitch, String childJobKey) {

		// valid
		XxlJobGroupDO group = xxlJobGroupDao.load(jobGroup);
		if (group == null) {
			return new ReturnTDO<String>(500, "请选择“执行器”");
		}
		if (StringUtils.isBlank(jobName)) {
			return new ReturnTDO<String>(500, "请输入“任务名”");
		}
		if (!CronExpression.isValidExpression(jobCron)) {
			return new ReturnTDO<String>(500, "请输入格式正确的“Cron”");
		}
		if (StringUtils.isBlank(jobDesc)) {
			return new ReturnTDO<String>(500, "请输入“任务描述”");
		}
		if (StringUtils.isBlank(author)) {
			return new ReturnTDO<String>(500, "请输入“负责人”");
		}
		if (StringUtils.isBlank(alarmEmail)) {
			return new ReturnTDO<String>(500, "请输入“报警邮件”");
		}
		if (glueSwitch==0 && StringUtils.isBlank(executorHandler)) {
			return new ReturnTDO<String>(500, "请输入“JobHandler”");
		}

		// childJobKey valid
		if (StringUtils.isNotBlank(childJobKey)) {
			String[] childJobKeys = childJobKey.split(",");
			for (String childJobKeyItem: childJobKeys) {
				String[] childJobKeyArr = childJobKeyItem.split("_");
				if (childJobKeyArr.length!=2) {
					return new ReturnTDO<String>(500, MessageFormat.format("子任务Key({0})格式错误", childJobKeyItem));
				}
				XxlJobInfoDO childJobInfo = xxlJobInfoDao.load(Integer.valueOf(childJobKeyArr[0]), childJobKeyArr[1]);
				if (childJobInfo==null) {
					return new ReturnTDO<String>(500, MessageFormat.format("子任务Key({0})无效", childJobKeyItem));
				}
			}
		}

		// stage job info
		XxlJobInfoDO jobInfo = xxlJobInfoDao.load(jobGroup, jobName);
		jobInfo.setJobCron(jobCron);
		jobInfo.setJobDesc(jobDesc);
		jobInfo.setAuthor(author);
		jobInfo.setAlarmEmail(alarmEmail);
		jobInfo.setExecutorHandler(executorHandler);
		jobInfo.setExecutorParam(executorParam);
		jobInfo.setGlueSwitch(glueSwitch);
		jobInfo.setChildJobKey(childJobKey);
		
		try {
			// fresh quartz
			boolean ret = DynamicSchedulerUtil.rescheduleJob(String.valueOf(jobGroup), jobName, jobCron);
			if (ret) {
				xxlJobInfoDao.update(jobInfo);
				return ReturnTDO.SUCCESS;
			} else {
				return new ReturnTDO<String>(500, "更新任务失败");
			}
		} catch (SchedulerException e) {
			log.error("", e);
		}
		return ReturnTDO.FAIL;
	}

	public ReturnTDO<String> remove(int jobGroup, String jobName) {
		try {
			DynamicSchedulerUtil.removeJob(jobName, String.valueOf(jobGroup));
			xxlJobInfoDao.delete(jobGroup, jobName);
			xxlJobLogDao.delete(jobGroup, jobName);
			xxlJobLogGlueDao.delete(jobGroup, jobName);
			return ReturnTDO.SUCCESS;
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		return ReturnTDO.FAIL;
	}

	public ReturnTDO<String> pause(int jobGroup, String jobName) {
		try {
			DynamicSchedulerUtil.pauseJob(jobName, String.valueOf(jobGroup));	// jobStatus do not store
			return ReturnTDO.SUCCESS;
		} catch (SchedulerException e) {
			e.printStackTrace();
			return ReturnTDO.FAIL;
		}
	}

	public ReturnTDO<String> resume(int jobGroup, String jobName) {
		try {
			DynamicSchedulerUtil.resumeJob(jobName, String.valueOf(jobGroup));
			return ReturnTDO.SUCCESS;
		} catch (SchedulerException e) {
			e.printStackTrace();
			return ReturnTDO.FAIL;
		}
	}

	public ReturnTDO<String> triggerJob(int jobGroup, String jobName) {
		try {
			DynamicSchedulerUtil.triggerJob(jobName, String.valueOf(jobGroup));
			return ReturnTDO.SUCCESS;
		} catch (SchedulerException e) {
			e.printStackTrace();
			return ReturnTDO.FAIL;
		}
	}
	
}

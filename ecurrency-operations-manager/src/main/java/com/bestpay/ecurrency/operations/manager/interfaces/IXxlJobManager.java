package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.dal.model.ReturnTDO;

import java.util.Map;

/**
 * core job action for xxl-job
 * 
 * @author xuxueli 2016-5-28 15:30:33
 */
public interface IXxlJobManager {
	
	public Map<String, Object> pageList(int jobGroup, String executorHandler,int start, int length);
	
	public ReturnTDO<String> add(int jobGroup, String jobCron, String jobDesc, String author, String alarmEmail,
							   String executorAddress, String executorHandler, String executorParam,
							   int glueSwitch, String glueSource, String glueRemark, String childJobKey);
	
	public ReturnTDO<String> reschedule(int jobGroup, String jobName, String jobCron, String jobDesc, String author, String alarmEmail,
									  String executorAddress, String executorHandler, String executorParam, int glueSwitch, String childJobKey);
	
	public ReturnTDO<String> remove(int jobGroup, String jobName);
	
	public ReturnTDO<String> pause(int jobGroup, String jobName);
	
	public ReturnTDO<String> resume(int jobGroup, String jobName);
	
	public ReturnTDO<String> triggerJob(int jobGroup, String jobName);
	
}

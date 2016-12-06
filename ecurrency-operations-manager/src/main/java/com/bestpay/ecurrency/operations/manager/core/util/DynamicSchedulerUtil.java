package com.bestpay.ecurrency.operations.manager.core.util;

import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobGroupMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobInfoMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobLogMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobRegistryMapper;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.manager.core.callback.XxlJobLogCallbackServer;
import com.bestpay.ecurrency.operations.manager.core.jobbean.RemoteHttpJobBean;
import com.bestpay.ecurrency.operations.manager.core.thread.JobRegistryHelper;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.Trigger.TriggerState;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.util.*;

/**
 * base quartz scheduler util
 * @author xuxueli 2015-12-19 16:13:53
 */
@Slf4j
public final class DynamicSchedulerUtil implements ApplicationContextAware, InitializingBean {
    
    // Scheduler
    private static Scheduler scheduler;
    public static void setScheduler(Scheduler scheduler) {
		DynamicSchedulerUtil.scheduler = scheduler;
	}
    
    // trigger callback port
    private int callBackPort = 8888;
    public void setCallBackPort(int callBackPort) {
		this.callBackPort = callBackPort;
	}
    
    // init
    XxlJobLogCallbackServer xxlJobLogCallbackServer = null;
    public void init(){
    	try {
    		// start callback server
    		xxlJobLogCallbackServer = new XxlJobLogCallbackServer();
    		xxlJobLogCallbackServer.start(callBackPort);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// init JobRegistryHelper
        JobRegistryHelper.discover("g", "k");
    }
    
    // destroy
    public void destroy(){
    	if (xxlJobLogCallbackServer!=null) {
    		xxlJobLogCallbackServer.destroy();
		}
    }
    
    // xxlJobLogDao、xxlJobInfoDao
    public static IXxlJobLogMapper xxlJobLogDao;
    public static IXxlJobInfoMapper xxlJobInfoDao;
    public static IXxlJobRegistryMapper xxlJobRegistryDao;
    public static IXxlJobGroupMapper xxlJobGroupDao;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DynamicSchedulerUtil.xxlJobLogDao = applicationContext.getBean(IXxlJobLogMapper.class);
		DynamicSchedulerUtil.xxlJobInfoDao = applicationContext.getBean(IXxlJobInfoMapper.class);
        DynamicSchedulerUtil.xxlJobRegistryDao = applicationContext.getBean(IXxlJobRegistryMapper.class);
        DynamicSchedulerUtil.xxlJobGroupDao = applicationContext.getBean(IXxlJobGroupMapper.class);
	}

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(scheduler, "quartz scheduler is null");
        log.info(">>>>>>>>> init quartz scheduler success.[{}]", scheduler);
       
    }
	
	// getJobKeys
	@Deprecated
	public static List<Map<String, Object>> getJobList(){
		List<Map<String, Object>> jobList = new ArrayList<Map<String,Object>>();
		
		try {
			if (scheduler.getJobGroupNames()==null || scheduler.getJobGroupNames().size()==0) {
				return null;
			}
			String groupName = scheduler.getJobGroupNames().get(0);
			Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName));
			if (jobKeys!=null && jobKeys.size()>0) {
				for (JobKey jobKey : jobKeys) {
			        TriggerKey triggerKey = TriggerKey.triggerKey(jobKey.getName(), Scheduler.DEFAULT_GROUP);
			        Trigger trigger = scheduler.getTrigger(triggerKey);
			        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
			        TriggerState triggerState = scheduler.getTriggerState(triggerKey);
			        Map<String, Object> jobMap = new HashMap<String, Object>();
			        jobMap.put("TriggerKey", triggerKey);
			        jobMap.put("Trigger", trigger);
			        jobMap.put("JobDetail", jobDetail);
			        jobMap.put("TriggerState", triggerState);
			        jobList.add(jobMap);
				}
			}
			
		} catch (SchedulerException e) {
			e.printStackTrace();
			return null;
		}
		return jobList;
	}
	
	// fill job info
	public static void fillJobInfo(XxlJobInfoDO jobInfo) {
		// TriggerKey : name + group
        TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getJobName(), String.valueOf(jobInfo.getJobGroup()));

        try {
			Trigger trigger = scheduler.getTrigger(triggerKey);

			TriggerState triggerState = scheduler.getTriggerState(triggerKey);
			
			// parse params
			if (trigger!=null && trigger instanceof CronTriggerImpl) {
				String cronExpression = ((CronTriggerImpl) trigger).getCronExpression();
				jobInfo.setJobCron(cronExpression);
			}

			//JobKey jobKey = new JobKey(jobInfo.getJobName(), String.valueOf(jobInfo.getJobGroup()));
            //JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            //String jobClass = jobDetail.getJobClass().getName();

			if (triggerState!=null) {
				jobInfo.setJobStatus(triggerState.name());
			}
			
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	// check if exists
	public static boolean checkExists(String jobName, String jobGroup) throws SchedulerException{
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
		return scheduler.checkExists(triggerKey);
	}

	// addJob 新增
	@SuppressWarnings("unchecked")
	public static boolean addJob(String jobGroup, String jobName, String cronExpression) throws SchedulerException {
    	// TriggerKey : name + group
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        JobKey jobKey = new JobKey(jobName, jobGroup);
        
        // TriggerKey valid if_exists
        if (checkExists(jobName, jobGroup)) {
            log.info(">>>>>>>>> addJob fail, job already exist, jobGroup:{}, jobName:{}", jobGroup, jobName);
            return false;
        }
        
        // CronTrigger : TriggerKey + cronExpression	// withMisfireHandlingInstructionDoNothing 忽略掉调度终止过程中忽略的调度
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();

        // JobDetail : jobClass
		Class<? extends Job> jobClass_ = RemoteHttpJobBean.class;   // Class.forName(jobInfo.getJobClass());
        
		JobDetail jobDetail = JobBuilder.newJob(jobClass_).withIdentity(jobKey).build();
        /*if (jobInfo.getJobData()!=null) {
        	JobDataMap jobDataMap = jobDetail.getJobDataMap();
        	jobDataMap.putAll(JacksonUtil.readValue(jobInfo.getJobData(), Map.class));	
        	// JobExecutionContext context.getMergedJobDataMap().get("mailGuid");
		}*/
        
        // schedule : jobDetail + cronTrigger
        Date date = scheduler.scheduleJob(jobDetail, cronTrigger);

        log.info(">>>>>>>>>>> addJob success, jobDetail:{}, cronTrigger:{}, date:{}", jobDetail, cronTrigger, date);
        return true;
    }
    
    // reschedule
	public static boolean rescheduleJob(String jobGroup, String jobName, String cronExpression) throws SchedulerException {
    	
    	// TriggerKey valid if_exists
        if (!checkExists(jobName, jobGroup)) {
            log.info(">>>>>>>>>>> rescheduleJob fail, job not exists, JobGroup:{}, JobName:{}", jobGroup, jobName);
            return false;
        }
        
        // TriggerKey : name + group
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        JobKey jobKey = new JobKey(jobName, jobGroup);
        
        // CronTrigger : TriggerKey + cronExpression
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
        
        //scheduler.rescheduleJob(triggerKey, cronTrigger);
        
        // JobDetail-JobDataMap fresh
        //todo
        System.out.println(scheduler);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
    	/*JobDataMap jobDataMap = jobDetail.getJobDataMap();
    	jobDataMap.clear();
    	jobDataMap.putAll(JacksonUtil.readValue(jobInfo.getJobData(), Map.class));*/
    	
    	// Trigger fresh
    	HashSet<Trigger> triggerSet = new HashSet<Trigger>();
    	triggerSet.add(cronTrigger);
        
        scheduler.scheduleJob(jobDetail, triggerSet, true);
        log.info(">>>>>>>>>>> resumeJob success, JobGroup:{}, JobName:{}", jobGroup, jobName);
        return true;
    }
    
    // unscheduleJob
    public static boolean removeJob(String jobName, String jobGroup) throws SchedulerException {
    	// TriggerKey : name + group
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        boolean result = false;
        if (checkExists(jobName, jobGroup)) {
            result = scheduler.unscheduleJob(triggerKey);
            log.info(">>>>>>>>>>> removeJob, triggerKey:{}, result [{}]", triggerKey, result);
        }
        return true;
    }

    //暂停job
    public static boolean pauseJob(String jobName, String jobGroup) throws SchedulerException {
    	// TriggerKey : name + group
    	TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        
        boolean result = false;
        if (checkExists(jobName, jobGroup)) {
            scheduler.pauseTrigger(triggerKey);
            result = true;
            log.info(">>>>>>>>>>> pauseJob success, triggerKey:{}", triggerKey);
        } else {
            log.info(">>>>>>>>>>> pauseJob fail, triggerKey:{}", triggerKey);
        }
        return result;
    }
    
    //恢复job
    public static boolean resumeJob(String jobName, String jobGroup) throws SchedulerException {
    	// TriggerKey : name + group
    	TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
        
        boolean result = false;
        if (checkExists(jobName, jobGroup)) {
            scheduler.resumeTrigger(triggerKey);
            result = true;
            log.info(">>>>>>>>>>> resumeJob success, triggerKey:{}", triggerKey);
        } else {
            log.info(">>>>>>>>>>> resumeJob fail, triggerKey:{}", triggerKey);
        }
        return result;
    }
    
    // run
    public static boolean triggerJob(String jobName, String jobGroup) throws SchedulerException {
    	// TriggerKey : name + group
    	JobKey jobKey = new JobKey(jobName, jobGroup);
        
        boolean result = false;
        if (checkExists(jobName, jobGroup)) {
            scheduler.triggerJob(jobKey);
            result = true;
            log.info(">>>>>>>>>>> runJob success, jobKey:{}", jobKey);
        } else {
            log.info(">>>>>>>>>>> runJob fail, jobKey:{}", jobKey);
        }
        return result;
    }


}
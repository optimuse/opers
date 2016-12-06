package com.bestpay.ecurrency.operations.manager.core.thread;

import com.bestpay.ecurrency.core.router.model.ResponseModel;
import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobLogDO;
import com.bestpay.ecurrency.operations.manager.core.util.DynamicSchedulerUtil;
import com.bestpay.ecurrency.operations.manager.core.util.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 1.监控程序是否执行成功
 * 2.成功则休眠指定时间
 * 3.失败则发送邮件通知
 */
@Slf4j
public class JobMonitorHelper {
	private static JobMonitorHelper helper = new JobMonitorHelper();
	private ExecutorService executor = Executors.newCachedThreadPool();
	private LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(0xfff8);
	private ConcurrentHashMap<String, Integer> countMap = new ConcurrentHashMap<String, Integer>();
	
	public JobMonitorHelper(){
		// consumer
		executor.execute(new Runnable() {
			public void run() {
				while (true) {
					try {
						log.info(">>>>>>>>>>> job monitor beat ... ");
						Integer jobLogId = JobMonitorHelper.helper.queue.take();
						if (jobLogId != null && jobLogId > 0) {
							log.info(">>>>>>>>>>> job monitor heat success, JobLogId:{}", jobLogId);
							XxlJobLogDO log = DynamicSchedulerUtil.xxlJobLogDao.load(jobLogId);
							if (log!=null) {
								if (ResponseModel.SUCCESS.equals(log.getTriggerStatus()) && StringUtils.isBlank(log.getHandleStatus())) {
									try {
										TimeUnit.SECONDS.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									JobMonitorHelper.monitor(jobLogId);
								}
								if (ResponseModel.SUCCESS.equals(log.getTriggerStatus()) && ResponseModel.SUCCESS.equals(log.getHandleStatus())) {
									// pass
								}
								if (ResponseModel.FAIL.equals(log.getTriggerStatus()) || ResponseModel.FAIL.equals(log.getHandleStatus())) {
									XxlJobInfoDO info = DynamicSchedulerUtil.xxlJobInfoDao.load(log.getJobGroup(), log.getJobName());
									if (info!=null && info.getAlarmEmail()!=null && info.getAlarmEmail().trim().length()>0) {

										Set<String> emailSet = new HashSet<String>(Arrays.asList(info.getAlarmEmail().split(",")));
										for (String email: emailSet) {
											String title = "《调度监控报警-任务调度中心XXL-JOB》";
											XxlJobGroupDO group = DynamicSchedulerUtil.xxlJobGroupDao.load(Integer.valueOf(info.getJobGroup()));
											String content = MessageFormat.format("任务调度失败, 执行器名称:{0}, 任务描述:{1}.", group!=null?group.getTitle():"null", info.getJobDesc());
											MailUtil.sendMail(email, title, content, false, null);
										}
									}
								}
							}
						}
					} catch (Exception e) {
						log.error("job monitor error:{}", e);
					}
				}
			}
		});
	}
	
	// producer
	public static void monitor(int jobLogId){
		JobMonitorHelper.helper.queue.offer(jobLogId);
	}
	
}

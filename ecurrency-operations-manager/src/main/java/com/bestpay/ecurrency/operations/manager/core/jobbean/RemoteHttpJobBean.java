package com.bestpay.ecurrency.operations.manager.core.jobbean;

import com.bestpay.ecurrency.core.registry.RegistHelper;
import com.bestpay.ecurrency.core.router.HandlerRouter.ActionRepository;
import com.bestpay.ecurrency.core.router.model.RequestModel;
import com.bestpay.ecurrency.core.router.model.ResponseModel;
import com.bestpay.ecurrency.core.util.XxlJobNetCommUtil;
import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobLogDO;
import com.bestpay.ecurrency.operations.manager.core.callback.XxlJobLogCallbackServer;
import com.bestpay.ecurrency.operations.manager.core.thread.JobMonitorHelper;
import com.bestpay.ecurrency.operations.manager.core.thread.JobRegistryHelper;
import com.bestpay.ecurrency.operations.manager.core.util.DynamicSchedulerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.MessageFormat;
import java.util.*;

/**
 *1.所有定时任务执行的入口
 */
@Slf4j
public class RemoteHttpJobBean extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        //获取定时任务的参数信息
        JobKey jobKey = context.getTrigger().getJobKey();
        //从数据库中读取定时任务参数信息
        XxlJobInfoDO jobInfo = DynamicSchedulerUtil.xxlJobInfoDao.load(Integer.valueOf(jobKey.getGroup()), jobKey.getName());
        // 保存日志信息
        XxlJobLogDO jobLog = new XxlJobLogDO();
        jobLog.setJobGroup(jobInfo.getJobGroup());
        jobLog.setJobName(jobInfo.getJobName());
        DynamicSchedulerUtil.xxlJobLogDao.save(jobLog);
        log.info(">>>>>>>>>>> xxl-job trigger start, jobId:{}", jobLog.getId());

        // 获取admin的地址
        List<String> adminAddressList = JobRegistryHelper.discover(RegistHelper.RegistType.ADMIN.name(), RegistHelper.RegistType.ADMIN.name());
        Set<String> adminAddressSet = new HashSet<String>();
        if (adminAddressList != null) {
            adminAddressSet.addAll(adminAddressList);
        }
        adminAddressSet.add(XxlJobLogCallbackServer.getTrigger_log_address());

        //组装调用执行器的参数信息
        RequestModel requestModel = new RequestModel();
        requestModel.setTimestamp(System.currentTimeMillis());
        requestModel.setAction(ActionRepository.RUN.name());
        requestModel.setJobGroup(String.valueOf(jobInfo.getJobGroup()));
        requestModel.setJobName(jobInfo.getJobName());
        requestModel.setExecutorHandler(jobInfo.getExecutorHandler());
        requestModel.setExecutorParams(jobInfo.getExecutorParam());
        requestModel.setGlueSwitch((jobInfo.getGlueSwitch() == 0) ? false : true);
        requestModel.setLogAddress(adminAddressSet);
        requestModel.setLogId(jobLog.getId());

        // parse address
        List<String> addressList = new ArrayList<String>();
        //查看定时任务所属组
        XxlJobGroupDO group = DynamicSchedulerUtil.xxlJobGroupDao.load(Integer.valueOf(jobInfo.getJobGroup()));
        //获取group组中的ip,此ip是项目启动时执行器加入的
        if (group != null) {
            //获取执行器地址
            addressList = JobRegistryHelper.discover(RegistHelper.RegistType.EXECUTOR.name(), group.getAppName());
        }

        //调用执行器
        ResponseModel responseModel = failoverTrigger(addressList, requestModel, jobLog);
        jobLog.setExecutorHandler(jobInfo.getExecutorHandler());
        jobLog.setExecutorParam(jobInfo.getExecutorParam());
        log.info(">>>>>>>>>>> xxl-job failoverTrigger response, jobId:{}, responseModel:{}", jobLog.getId(), responseModel.toString());

        //添加日志信息
        jobLog.setTriggerTime(new Date());
        jobLog.setTriggerStatus(responseModel.getStatus());
        jobLog.setTriggerMsg(responseModel.getMsg());
        //更新日志信息
        DynamicSchedulerUtil.xxlJobLogDao.updateTriggerInfo(jobLog);

        // monitor triger
        JobMonitorHelper.monitor(jobLog.getId());

        log.info(">>>>>>>>>>> xxl-job trigger end, jobId:{}", jobLog.getId());
    }


    /**
     * failover for trigger remote address
     *
     * @return
     */
    public ResponseModel failoverTrigger(List<String> addressList, RequestModel requestModel, XxlJobLogDO jobLog) {
        if (addressList == null || addressList.size() < 1) {
            ResponseModel result = new ResponseModel();
            result.setStatus(ResponseModel.FAIL);
            result.setMsg("Trigger error, <br>>>>[address] is null <br><hr>");
            return result;
        } else if (addressList.size() == 1) {
            String address = addressList.get(0);
            // store real address
            jobLog.setExecutorAddress(address);

            ResponseModel triggerCallback = XxlJobNetCommUtil.postHex(XxlJobNetCommUtil.addressToUrl(address), requestModel);
            String failoverMessage = MessageFormat.format("Trigger running, <br>>>>[address] : {0}, <br>>>>[status] : {1}, <br>>>>[msg] : {2} <br><hr>", address, triggerCallback.getStatus(), triggerCallback.getMsg());
            triggerCallback.setMsg(failoverMessage);
            return triggerCallback;
        } else {

            // for ha
            Collections.shuffle(addressList);

            // for failover
            String failoverMessage = "";
            for (String address : addressList) {
                if (StringUtils.isNotBlank(address)) {

                    // beat check
                    RequestModel beatRequest = new RequestModel();
                    beatRequest.setTimestamp(System.currentTimeMillis());
                    beatRequest.setAction(ActionRepository.BEAT.name());
                    ResponseModel beatResult = XxlJobNetCommUtil.postHex(XxlJobNetCommUtil.addressToUrl(address), beatRequest);
                    failoverMessage += MessageFormat.format("BEAT running, <br>>>>[address] : {0}, <br>>>>[status] : {1}, <br>>>>[msg] : {2} <br><hr>", address, beatResult.getStatus(), beatResult.getMsg());

                    // beat success, trigger do
                    if (beatResult.SUCCESS.equals(beatResult.getStatus())) {
                        // store real address
                        jobLog.setExecutorAddress(address);

                        // real trigger
                        ResponseModel triggerCallback = XxlJobNetCommUtil.postHex(XxlJobNetCommUtil.addressToUrl(address), requestModel);
                        failoverMessage += MessageFormat.format("Trigger running, <br>>>>[address] : {0}, <br>>>>[status] : {1}, <br>>>>[msg] : {2} <br><hr>", address, triggerCallback.getStatus(), triggerCallback.getMsg());
                        triggerCallback.setMsg(failoverMessage);
                        return triggerCallback;
                    }

                }
            }

            ResponseModel result = new ResponseModel();
            result.setStatus(ResponseModel.FAIL);
            result.setMsg(failoverMessage);
            return result;
        }
    }


}
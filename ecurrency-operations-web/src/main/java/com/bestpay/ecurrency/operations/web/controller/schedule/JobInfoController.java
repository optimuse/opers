package com.bestpay.ecurrency.operations.web.controller.schedule;

import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobGroupMapper;
import com.bestpay.ecurrency.operations.dal.model.ReturnTDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;
import com.bestpay.ecurrency.operations.manager.interfaces.IXxlJobManager;
import com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * index controller
 *
 * @author xuxueli 2015-12-19 16:13:16
 */
@Controller
@RequestMapping("/jobinfo")
public class JobInfoController {

    @Autowired
    private IXxlJobGroupMapper xxlJobGroupDao;
    @Autowired
    private IXxlJobManager xxlJobService;

    @PrivilegeValidate(privKey = "/jobinfo/index")
    @RequestMapping("/index")
    public String index(Model model) {

        // 任务组
        List<XxlJobGroupDO> jobGroupList = xxlJobGroupDao.findAll();

        model.addAttribute("JobGroupList", jobGroupList);
        return "schedule/jobinfo";
    }

    @RequestMapping("/pageList")
    @ResponseBody
    public Map<String, Object> pageList(int jobGroup, String executorHandler, @RequestParam(required = false, defaultValue = "0") int start,
                                        @RequestParam(required = false, defaultValue = "10") int length) {

        return xxlJobService.pageList(jobGroup, executorHandler,start, length);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ReturnTDO<String> add(int jobGroup, String jobCron, String jobDesc, String author, String alarmEmail,
                                 String executorAppname, String executorAddress, String executorHandler, String executorParam,
                                 int glueSwitch, String glueSource, String glueRemark, String childJobKey) {

        return xxlJobService.add(jobGroup, jobCron, jobDesc, author, alarmEmail,
                executorAddress, executorHandler, executorParam,
                glueSwitch, glueSource, glueRemark, childJobKey);
    }

    @RequestMapping("/reschedule")
    @ResponseBody
    public ReturnTDO<String> reschedule(int jobGroup, String jobName, String jobCron, String jobDesc, String author, String alarmEmail,
                                        String executorAppname, String executorAddress, String executorHandler, String executorParam,
                                        int glueSwitch, String childJobKey) {

        return xxlJobService.reschedule(jobGroup, jobName, jobCron, jobDesc, author, alarmEmail,
                executorAddress, executorHandler, executorParam, glueSwitch, childJobKey);
    }

    @RequestMapping("/remove")
    @ResponseBody
    public ReturnTDO<String> remove(int jobGroup, String jobName) {
        return xxlJobService.remove(jobGroup, jobName);
    }

    @RequestMapping("/pause")
    @ResponseBody
    public ReturnTDO<String> pause(int jobGroup, String jobName) {
        return xxlJobService.pause(jobGroup, jobName);
    }

    @RequestMapping("/resume")
    @ResponseBody
    public ReturnTDO<String> resume(int jobGroup, String jobName) {
        return xxlJobService.resume(jobGroup, jobName);
    }

    @RequestMapping("/trigger")
    @ResponseBody
    public ReturnTDO<String> triggerJob(int jobGroup, String jobName) {
        return xxlJobService.triggerJob(jobGroup, jobName);
    }

}

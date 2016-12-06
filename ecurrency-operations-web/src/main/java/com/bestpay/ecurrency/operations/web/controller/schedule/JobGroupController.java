package com.bestpay.ecurrency.operations.web.controller.schedule;

import com.bestpay.ecurrency.core.registry.RegistHelper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobGroupMapper;
import com.bestpay.ecurrency.operations.dal.mapper.IXxlJobInfoMapper;
import com.bestpay.ecurrency.operations.dal.model.ReturnTDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;
import com.bestpay.ecurrency.operations.manager.core.thread.JobRegistryHelper;
import com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * job group controller
 * @author xuxueli 2016-10-02 20:52:56
 */
@Controller
@RequestMapping("/jobgroup")
public class JobGroupController {

	@Autowired
	public IXxlJobInfoMapper xxlJobInfoDao;
	@Autowired
	public IXxlJobGroupMapper xxlJobGroupDao;

	@PrivilegeValidate(privKey = "/jobgroup/index")
	@RequestMapping("/index")
	public String index(Model model) {

		// job admin
		List<String> adminAddressList = JobRegistryHelper.discover(RegistHelper.RegistType.ADMIN.name(), RegistHelper.RegistType.ADMIN.name());

		// job group (executor)
		List<XxlJobGroupDO> list = xxlJobGroupDao.findAll();

		if (CollectionUtils.isNotEmpty(list)) {
			for (XxlJobGroupDO group: list) {
				List<String> registryList = JobRegistryHelper.discover(RegistHelper.RegistType.EXECUTOR.name(), group.getAppName());
				group.setRegistryList(registryList);
			}
		}

		model.addAttribute("adminAddressList", adminAddressList);
		model.addAttribute("list", list);
		return "schedule/jobgroup";
	}

	@RequestMapping("/save")
	@ResponseBody
	public ReturnTDO<String> save(XxlJobGroupDO xxlJobGroup){

		// valid
		if (xxlJobGroup.getAppName()==null || StringUtils.isBlank(xxlJobGroup.getAppName())) {
			return new ReturnTDO<String>(500, "请输入AppName");
		}
		if (xxlJobGroup.getAppName().length()>64) {
			return new ReturnTDO<String>(500, "AppName长度限制为4~64");
		}
		if (xxlJobGroup.getTitle()==null || StringUtils.isBlank(xxlJobGroup.getTitle())) {
			return new ReturnTDO<String>(500, "请输入名称");
		}

		int ret = xxlJobGroupDao.save(xxlJobGroup);
		return (ret>0)?ReturnTDO.SUCCESS:ReturnTDO.FAIL;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ReturnTDO<String> update(XxlJobGroupDO xxlJobGroup){
		// valid
		if (xxlJobGroup.getAppName()==null || StringUtils.isBlank(xxlJobGroup.getAppName())) {
			return new ReturnTDO<String>(500, "请输入AppName");
		}
		if (xxlJobGroup.getAppName().length()>64) {
			return new ReturnTDO<String>(500, "AppName长度限制为4~64");
		}
		if (xxlJobGroup.getTitle()==null || StringUtils.isBlank(xxlJobGroup.getTitle())) {
			return new ReturnTDO<String>(500, "请输入名称");
		}

		int ret = xxlJobGroupDao.update(xxlJobGroup);
		return (ret>0)?ReturnTDO.SUCCESS:ReturnTDO.FAIL;
	}

	@RequestMapping("/remove")
	@ResponseBody
	public ReturnTDO<String> remove(int id){

		// valid
		int count = xxlJobInfoDao.pageListCount(0, 10, id, null);
		if (count > 0) {
			return new ReturnTDO<String>(500, "该分组使用中, 不可删除");
		}

		List<XxlJobGroupDO> allList = xxlJobGroupDao.findAll();
		if (allList.size() == 1) {
			return new ReturnTDO<String>(500, "删除失败, 系统需要至少预留一个默认分组");
		}

		int ret = xxlJobGroupDao.remove(id);
		return (ret>0)?ReturnTDO.SUCCESS:ReturnTDO.FAIL;
	}

}

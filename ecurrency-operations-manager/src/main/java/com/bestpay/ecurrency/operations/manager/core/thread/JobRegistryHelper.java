package com.bestpay.ecurrency.operations.manager.core.thread;

import com.bestpay.ecurrency.core.registry.RegistHelper;
import com.bestpay.ecurrency.operations.dal.model.XxlJobRegistryDO;
import com.bestpay.ecurrency.operations.manager.core.callback.XxlJobLogCallbackServer;
import com.bestpay.ecurrency.operations.manager.core.util.DynamicSchedulerUtil;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * job registry helper
 * @author xuxueli 2016-10-02 19:10:24
 */
@Slf4j
public class JobRegistryHelper {

	private static JobRegistryHelper helper = new JobRegistryHelper();
	private ConcurrentHashMap<String, List<String>> registMap = new ConcurrentHashMap<String, List<String>>();

	public JobRegistryHelper(){
		Thread registryThread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
                        // registry admin
                        int ret = DynamicSchedulerUtil.xxlJobRegistryDao.registryUpdate(RegistHelper.RegistType.ADMIN.name(), RegistHelper.RegistType.ADMIN.name(), XxlJobLogCallbackServer.getTrigger_log_address());
                        if (ret < 1) {
                            DynamicSchedulerUtil.xxlJobRegistryDao.registrySave(RegistHelper.RegistType.ADMIN.name(), RegistHelper.RegistType.ADMIN.name(), XxlJobLogCallbackServer.getTrigger_log_address());
                        }

                        // fresh registry map
						ConcurrentHashMap<String, List<String>> temp = new ConcurrentHashMap<String, List<String>>();
						DynamicSchedulerUtil.xxlJobRegistryDao.removeDead(RegistHelper.TIMEOUT*2);
						List<XxlJobRegistryDO> list = DynamicSchedulerUtil.xxlJobRegistryDao.findAll(RegistHelper.TIMEOUT*2);
						if (list != null) {
							for (XxlJobRegistryDO item: list) {
								String groupKey = makeGroupKey(item.getRegistryGroup(), item.getRegistryKey());
								List<String> registryList = temp.get(groupKey);
								if (registryList == null) {
									registryList = new ArrayList<String>();
								}
								registryList.add(item.getRegistryValue());
								temp.put(groupKey, registryList);
							}
						}
						registMap = temp;
					} catch (Exception e) {
						log.error("job registry helper error:{}", e);
					}
					try {
						TimeUnit.SECONDS.sleep(RegistHelper.TIMEOUT);
					} catch (InterruptedException e) {
						log.error("job registry helper error:{}", e);
					}
				}
			}
		});
		registryThread.setDaemon(true);
		registryThread.start();

	}

	private static String makeGroupKey(String registryGroup, String registryKey){
		return registryGroup.concat("_").concat(registryKey);
	}
	
	public static List<String> discover(String registryGroup, String registryKey){
		String groupKey = makeGroupKey(registryGroup, registryKey);
		List<String> list = helper.registMap.get(groupKey);
		return list;
	}
	
}

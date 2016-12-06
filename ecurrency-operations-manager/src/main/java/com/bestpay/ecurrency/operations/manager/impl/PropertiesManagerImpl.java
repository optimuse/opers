package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.common.util.PropertiesUtil;
import com.bestpay.ecurrency.operations.manager.interfaces.IPropertiesManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/25 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
public class PropertiesManagerImpl implements IPropertiesManager {

    /**
     * 通过关键字筛选信息
     *
     * @param prefix
     * @return
     */
    public Map<String,String> querySysparamMapByParmCodePrefix(String prefix) {
        Properties properties = PropertiesUtil.getProperties();//获取所有配置
        Map<String, String> map = new HashMap(properties);
        if (StringUtils.isBlank(prefix)) {
            return map;
        }

        Map<String,String> resultMap = new HashMap<>();
        for(Map.Entry<String,String> entry:map.entrySet()){
            String key  = entry.getKey();
            String value = entry.getValue();
            if(key.startsWith(prefix)){
                resultMap.put(key,value);
            }
        }
        return resultMap;
    }


}

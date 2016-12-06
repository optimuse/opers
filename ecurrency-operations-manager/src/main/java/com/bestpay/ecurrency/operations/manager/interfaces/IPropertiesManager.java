package com.bestpay.ecurrency.operations.manager.interfaces;

import java.util.Map;

/**
 * 配置文件管理类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/25 ProjectName: ecurrency-operations Version: 1.0
 */
public interface IPropertiesManager {

    /**
     * @see ISymSysparamManager
     * 通过prefix查询相关的系统参数信息
     * @param prefix
     * @return
     */
    Map<String, String> querySysparamMapByParmCodePrefix(String prefix);


}

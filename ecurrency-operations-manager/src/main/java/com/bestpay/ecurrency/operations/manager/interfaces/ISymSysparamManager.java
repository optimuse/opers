package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.dal.model.EoSymSysparamDO;

import java.util.List;
import java.util.Map;

/**
 * 使properties可配置 将一部分系统参数用表管理
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */
public interface ISymSysparamManager {

    /**
     * 获取所有系统参数
     *
     * @return
     */
    List<EoSymSysparamDO> queryAllSysparamList();


    /**
     * 插入新的系统参数信息
     *
     * @param eoSymSysparamDO
     * @return
     */
    int insert(EoSymSysparamDO eoSymSysparamDO);

    /**
     * 通过prefix查询相关的系统参数信息
     * @param prefix
     * @return
     */
    List<EoSymSysparamDO> querySysparamListByParmCodePrefix(String prefix);


    Map<String,String> querySysparamMapByParmCodePrefix(String prefix);

}

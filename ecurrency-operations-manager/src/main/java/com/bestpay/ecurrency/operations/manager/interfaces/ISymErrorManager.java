package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.dal.model.EoSymErrorDO;

import java.util.List;
import java.util.Map;

/**
 * t_eo_sym_error
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
public interface ISymErrorManager {

    List<EoSymErrorDO> queryAllErrorList();

    /**
     * 获取错误信息并转换为Map<string,string>形式
     * @return
     */
    Map<String,String> queryErrorInfoMap();

    /**
     * 向表中插入新的错误信息数据
     * @param eoSymErrorDO
     * @return
     */
    int insertErrorInfo(EoSymErrorDO eoSymErrorDO);
}

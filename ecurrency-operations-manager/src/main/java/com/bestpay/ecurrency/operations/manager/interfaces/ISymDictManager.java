package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.dal.model.EoSymDictDO;

import java.util.List;

/**
 * t_eo_Sym_Dict
 * <p>
 * 1.查询字典表中的所有有效数据
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
public interface ISymDictManager {

    /**
     * 查询字典表中的所有有效数据
     * @return
     */
    List<EoSymDictDO> queryAllDictList();

}

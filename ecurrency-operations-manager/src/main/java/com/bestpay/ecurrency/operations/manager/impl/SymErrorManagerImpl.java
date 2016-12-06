package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.dal.mapper.EoSymErrorMapper;
import com.bestpay.ecurrency.operations.dal.model.EoSymErrorDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymErrorDOExample;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymErrorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
public class SymErrorManagerImpl implements ISymErrorManager {

    @Autowired
    private EoSymErrorMapper eoSymErrorMapper;

    @Override
    public List<EoSymErrorDO> queryAllErrorList() {
        EoSymErrorDOExample eoSymErrorDOExample  =  new EoSymErrorDOExample();
        eoSymErrorDOExample.createCriteria().andStatEqualTo(EoSymErrorDOExample.Stat.S0A.name());
        return eoSymErrorMapper.selectByExample(eoSymErrorDOExample);
    }

    @Override
    public Map<String, String> queryErrorInfoMap() {
        Map<String, String> map = new HashMap<>();
        List<EoSymErrorDO> list = queryAllErrorList();
        for (EoSymErrorDO eoSymErrorDO : list) {
            map.put(eoSymErrorDO.getErrorCode(),eoSymErrorDO.getErrorInfo());
        }
        return map;
    }

    @Override
    public int insertErrorInfo(EoSymErrorDO eoSymErrorDO) {
        return eoSymErrorMapper.insert(eoSymErrorDO);
    }


}

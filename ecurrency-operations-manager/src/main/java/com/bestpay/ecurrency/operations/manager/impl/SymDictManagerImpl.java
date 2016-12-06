package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.dal.mapper.EoSymDictMapper;
import com.bestpay.ecurrency.operations.dal.model.EoSymDictDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymDictDOExample;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymDictManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
public class SymDictManagerImpl implements ISymDictManager {

    @Autowired
    private EoSymDictMapper eoSymDictMapper;

    @Override
    public List<EoSymDictDO> queryAllDictList() {
        EoSymDictDOExample eoSymDictDOExample = new EoSymDictDOExample();
        eoSymDictDOExample.createCriteria().andStatEqualTo(EoSymDictDOExample.Stat.S0A.name());
        return eoSymDictMapper.selectByExample(eoSymDictDOExample);
    }
}

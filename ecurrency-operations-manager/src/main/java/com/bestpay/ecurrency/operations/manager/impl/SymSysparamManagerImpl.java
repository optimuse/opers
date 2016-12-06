package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.dal.mapper.EoSymSysparamMapper;
import com.bestpay.ecurrency.operations.dal.model.EoSymSysparamDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymSysparamDOExample;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymSysparamManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
public class SymSysparamManagerImpl implements ISymSysparamManager {

    @Autowired
    private EoSymSysparamMapper eoSymSysparamMapper;

    @Override
    public List<EoSymSysparamDO> queryAllSysparamList() {
        EoSymSysparamDOExample eoSymSysparamDOExample =
                new EoSymSysparamDOExample();
        eoSymSysparamDOExample.createCriteria().andStatEqualTo(EoSymSysparamDOExample.Stat.S0A.name());
        return eoSymSysparamMapper.selectByExample(eoSymSysparamDOExample);
    }

    /**
     * 添加新的系统变量
     *
     * @param eoSymSysparamDO
     * @return
     */
    public int insert(EoSymSysparamDO eoSymSysparamDO) {
        return eoSymSysparamMapper.insert(eoSymSysparamDO);
    }

    /**
     * 通过关键字筛选信息
     *
     * @param prefix
     * @return
     */
    public List<EoSymSysparamDO> querySysparamListByParmCodePrefix(String prefix) {
        List<EoSymSysparamDO> allSysparamList = queryAllSysparamList();
        if (StringUtils.isBlank(prefix)) {
            return allSysparamList;
        }
        List<EoSymSysparamDO> resultList = new ArrayList<>();
        for (EoSymSysparamDO eoSymSysparamDO : allSysparamList) {
            if (eoSymSysparamDO.getParamCode().toLowerCase()
                    .startsWith(prefix.toLowerCase())) {
                resultList.add(eoSymSysparamDO);
            }
        }
        return resultList;
    }


    /**
     * 通过关键字筛选信息
     *
     * @param prefix
     * @return
     */
    public Map<String,String> querySysparamMapByParmCodePrefix(String prefix) {
        List<EoSymSysparamDO> allSysparamList = queryAllSysparamList();
        if (StringUtils.isBlank(prefix)) {
            return transMap(allSysparamList);
        }
        List<EoSymSysparamDO> resultList = new ArrayList<>();
        for (EoSymSysparamDO eoSymSysparamDO : allSysparamList) {
            if (eoSymSysparamDO.getParamCode().toLowerCase()
                    .startsWith(prefix.toLowerCase())) {
                resultList.add(eoSymSysparamDO);
            }
        }
        return transMap(resultList);
    }

    /**
     * 将list转换为map
     * @param eoSymSysparamDOList
     * @return
     */
    private Map<String,String> transMap(List<EoSymSysparamDO> eoSymSysparamDOList){
        if(eoSymSysparamDOList==null||eoSymSysparamDOList.isEmpty()){
            return null;
        }else{
            Map<String,String> resultMap = new HashMap<>();
            for(EoSymSysparamDO eoSymSysparamDO:eoSymSysparamDOList){
                resultMap.put(eoSymSysparamDO.getParamCode(),eoSymSysparamDO.getParamVal());
            }
            return resultMap;
        }

    }
}

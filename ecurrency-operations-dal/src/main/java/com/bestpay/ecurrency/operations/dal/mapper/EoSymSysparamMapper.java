package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.EoSymSysparamDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymSysparamDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymSysparamMapper {
    long countByExample(EoSymSysparamDOExample example);

    int insert(EoSymSysparamDO record);

    int insertSelective(EoSymSysparamDO record);

    List<EoSymSysparamDO> selectByExample(EoSymSysparamDOExample example);

    EoSymSysparamDO selectByPrimaryKey(String paramCode);

    int updateByExampleSelective(@Param("record") EoSymSysparamDO record, @Param("example") EoSymSysparamDOExample example);

    int updateByExample(@Param("record") EoSymSysparamDO record, @Param("example") EoSymSysparamDOExample example);

    int updateByPrimaryKeySelective(EoSymSysparamDO record);

    int updateByPrimaryKey(EoSymSysparamDO record);
}
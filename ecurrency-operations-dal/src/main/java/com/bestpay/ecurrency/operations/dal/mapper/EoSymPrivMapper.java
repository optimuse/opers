package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.EoSymPrivDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymPrivDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymPrivMapper {
    long countByExample(EoSymPrivDOExample example);

    int insert(EoSymPrivDO record);

    int insertSelective(EoSymPrivDO record);

    List<EoSymPrivDO> selectByExample(EoSymPrivDOExample example);

    EoSymPrivDO selectByPrimaryKey(Integer privId);

    int updateByExampleSelective(@Param("record") EoSymPrivDO record, @Param("example") EoSymPrivDOExample example);

    int updateByExample(@Param("record") EoSymPrivDO record, @Param("example") EoSymPrivDOExample example);

    int updateByPrimaryKeySelective(EoSymPrivDO record);

    int updateByPrimaryKey(EoSymPrivDO record);
}
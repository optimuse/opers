package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.EoSymErrorDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymErrorDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymErrorMapper {
    long countByExample(EoSymErrorDOExample example);

    int insert(EoSymErrorDO record);

    int insertSelective(EoSymErrorDO record);

    List<EoSymErrorDO> selectByExample(EoSymErrorDOExample example);

    EoSymErrorDO selectByPrimaryKey(String errorCode);

    int updateByExampleSelective(@Param("record") EoSymErrorDO record, @Param("example") EoSymErrorDOExample example);

    int updateByExample(@Param("record") EoSymErrorDO record, @Param("example") EoSymErrorDOExample example);

    int updateByPrimaryKeySelective(EoSymErrorDO record);

    int updateByPrimaryKey(EoSymErrorDO record);
}
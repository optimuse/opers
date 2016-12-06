package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.EoSymRolePrivDOExample;
import com.bestpay.ecurrency.operations.dal.model.EoSymRolePrivDOKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymRolePrivMapper {
    long countByExample(EoSymRolePrivDOExample example);

    int insert(EoSymRolePrivDOKey record);

    int insertSelective(EoSymRolePrivDOKey record);

    List<EoSymRolePrivDOKey> selectByExample(EoSymRolePrivDOExample example);

    int updateByExampleSelective(@Param("record") EoSymRolePrivDOKey record, @Param("example") EoSymRolePrivDOExample example);

    int updateByExample(@Param("record") EoSymRolePrivDOKey record, @Param("example") EoSymRolePrivDOExample example);
}
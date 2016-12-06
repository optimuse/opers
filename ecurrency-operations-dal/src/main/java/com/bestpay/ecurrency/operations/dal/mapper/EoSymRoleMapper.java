package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.EoSymRoleDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymRoleDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymRoleMapper {
    long countByExample(EoSymRoleDOExample example);

    int insert(EoSymRoleDO record);

    int insertSelective(EoSymRoleDO record);

    List<EoSymRoleDO> selectByExample(EoSymRoleDOExample example);

    EoSymRoleDO selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") EoSymRoleDO record, @Param("example") EoSymRoleDOExample example);

    int updateByExample(@Param("record") EoSymRoleDO record, @Param("example") EoSymRoleDOExample example);

    int updateByPrimaryKeySelective(EoSymRoleDO record);

    int updateByPrimaryKey(EoSymRoleDO record);
}
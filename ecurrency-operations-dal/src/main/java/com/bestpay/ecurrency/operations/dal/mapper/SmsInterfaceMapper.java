package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.SmsInterfaceDO;
import com.bestpay.ecurrency.operations.dal.model.SmsInterfaceDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsInterfaceMapper {
    long countByExample(SmsInterfaceDOExample example);

    int insert(SmsInterfaceDO record);

    int insertSelective(SmsInterfaceDO record);

    List<SmsInterfaceDO> selectByExample(SmsInterfaceDOExample example);

    SmsInterfaceDO selectByPrimaryKey(Long smsSeq);

    int updateByExampleSelective(@Param("record") SmsInterfaceDO record, @Param("example") SmsInterfaceDOExample example);

    int updateByExample(@Param("record") SmsInterfaceDO record, @Param("example") SmsInterfaceDOExample example);

    int updateByPrimaryKeySelective(SmsInterfaceDO record);

    int updateByPrimaryKey(SmsInterfaceDO record);
}
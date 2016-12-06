package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.EoSymDictDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymDictDOExample;
import com.bestpay.ecurrency.operations.dal.model.EoSymDictDOKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EoSymDictMapper {
    long countByExample(EoSymDictDOExample example);

    int insert(EoSymDictDO record);

    int insertSelective(EoSymDictDO record);

    List<EoSymDictDO> selectByExample(EoSymDictDOExample example);

    EoSymDictDO selectByPrimaryKey(EoSymDictDOKey key);

    int updateByExampleSelective(@Param("record") EoSymDictDO record, @Param("example") EoSymDictDOExample example);

    int updateByExample(@Param("record") EoSymDictDO record, @Param("example") EoSymDictDOExample example);

    int updateByPrimaryKeySelective(EoSymDictDO record);

    int updateByPrimaryKey(EoSymDictDO record);
}
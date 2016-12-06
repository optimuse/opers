package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.XxlJobRegistryDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface IXxlJobRegistryMapper {
    public int removeDead(@Param("timeout")int timeout);

    public List<XxlJobRegistryDO> findAll(@Param("timeout")int timeout);

    public int registryUpdate(@Param("registryGroup")String registryGroup, @Param("registryKey")String registryKey, @Param("registryValue")String registryValue);

    public int registrySave(@Param("registryGroup")String registryGroup, @Param("registryKey")String registryKey, @Param("registryValue")String registryValue);

}

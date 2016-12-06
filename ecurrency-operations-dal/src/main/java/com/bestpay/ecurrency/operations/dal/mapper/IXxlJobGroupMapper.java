package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.XxlJobGroupDO;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
public interface IXxlJobGroupMapper {

    public List<XxlJobGroupDO> findAll();

    public int save(XxlJobGroupDO xxlJobGroup);

    public int update(XxlJobGroupDO xxlJobGroup);

    public int remove(int id);

    public XxlJobGroupDO load(int id);
}

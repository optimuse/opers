package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.XxlJobLogGlueDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * job log for glue
 * @author xuxueli 2016-5-19 18:04:56
 */
public interface IXxlJobLogGlueMapper {
	
	public int save(XxlJobLogGlueDO xxlJobLogGlue);
	
	public List<XxlJobLogGlueDO> selectList(@Param("jobGroup")int jobGroup, @Param("jobName")String jobName);

	public int removeOld(@Param("jobGroup")int jobGroup, @Param("jobName")String jobName, @Param("limit")int limit);

	public int delete(@Param("jobGroup")int jobGroup, @Param("jobName")String jobName);
	
}

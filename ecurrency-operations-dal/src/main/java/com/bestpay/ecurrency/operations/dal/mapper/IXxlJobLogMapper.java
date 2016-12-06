package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.XxlJobLogDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * job log
 * @author xuxueli 2016-1-12 18:03:06
 */
public interface IXxlJobLogMapper {
	
	public List<XxlJobLogDO> pageList(@Param("offset")int offset, @Param("pagesize")int pagesize, @Param("jobGroup")int jobGroup, @Param("jobName")String jobName, @Param("triggerTimeStart")Date triggerTimeStart, @Param("triggerTimeEnd")Date triggerTimeEnd);
	public int pageListCount(@Param("offset")int offset, @Param("pagesize")int pagesize, @Param("jobGroup")int jobGroup, @Param("jobName")String jobName, @Param("triggerTimeStart")Date triggerTimeStart, @Param("triggerTimeEnd")Date triggerTimeEnd);
	
	public XxlJobLogDO load(@Param("id")int id);

	public int save(XxlJobLogDO xxlJobLog);
	public int updateTriggerInfo(XxlJobLogDO xxlJobLog);
	public int updateHandleInfo(XxlJobLogDO xxlJobLog);
	
	public int delete(@Param("jobGroup")int jobGroup, @Param("jobName")String jobName);
	
}

package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.XxlJobInfoDO;
import com.bestpay.ecurrency.operations.dal.model.XxlJobLogDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
public interface IXxlJobInfoMapper {

	public List<XxlJobInfoDO> pageList(@Param("jobGroup")int jobGroup, @Param("executorHandler")String executorHandler,@Param("offset")int offset, @Param("pagesize")int pagesize);
	public int pageListCount(@Param("offset")int offset, @Param("pagesize")int pagesize, @Param("jobGroup")int jobGroup, @Param("executorHandler")String executorHandler);
	
	public int save(XxlJobInfoDO info);
	
	public XxlJobInfoDO load(@Param("jobGroup")int jobGroup, @Param("jobName")String jobName);
	
	public int update(XxlJobInfoDO item);
	
	public int delete(@Param("jobGroup")int jobGroup, @Param("jobName")String jobName);

	public List<XxlJobLogDO> getJobsByGroup(@Param("jobGroup")String jobGroup);
}

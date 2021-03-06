package com.bestpay.ecurrency.operations.dal.mapper;

import com.bestpay.ecurrency.operations.dal.model.PcmInfoDO;
import com.bestpay.ecurrency.operations.dal.model.PcmInfoDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PcmInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    long countByExample(PcmInfoDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    int insert(PcmInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    int insertSelective(PcmInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    List<PcmInfoDO> selectByExample(PcmInfoDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    PcmInfoDO selectByPrimaryKey(String cardNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    int updateByExampleSelective(@Param("record") PcmInfoDO record, @Param("example") PcmInfoDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    int updateByExample(@Param("record") PcmInfoDO record, @Param("example") PcmInfoDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    int updateByPrimaryKeySelective(PcmInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PCM_INFO
     *
     * @mbg.generated Mon Nov 21 15:01:00 CST 2016
     */
    int updateByPrimaryKey(PcmInfoDO record);
}
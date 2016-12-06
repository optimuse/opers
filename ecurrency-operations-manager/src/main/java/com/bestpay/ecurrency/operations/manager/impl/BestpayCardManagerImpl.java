package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.dal.mapper.PcmAcctinfoMapper;
import com.bestpay.ecurrency.operations.dal.mapper.PcmInfoMapper;
import com.bestpay.ecurrency.operations.dal.model.PcmAcctinfoDO;
import com.bestpay.ecurrency.operations.dal.model.PcmInfoDO;
import com.bestpay.ecurrency.operations.manager.interfaces.IBestpayCardManager;
import com.bestpay.ecurrency.operations.manager.model.BestpayCardInfoBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
@Slf4j
public class BestpayCardManagerImpl implements IBestpayCardManager {
    @Autowired
    private PcmAcctinfoMapper pcmAcctinfoMapper;

    @Autowired
    private PcmInfoMapper pcmInfoMapper;

    @Override
    public BestpayCardInfoBO queryCardInfo(String cardNo) {
        PcmAcctinfoDO pcmAcctinfoDO = pcmAcctinfoMapper.selectByPrimaryKey(cardNo);
        if (pcmAcctinfoDO == null) {
            throw new OperationsSystemException(OperationSystemErrorCode.BESTPAYCARD_NOT_FOUND);
        }
        PcmInfoDO pcmInfoDO = pcmInfoMapper.selectByPrimaryKey(cardNo);
        BestpayCardInfoBO result = new BestpayCardInfoBO();
        BeanMapperUtil.copy(pcmAcctinfoDO, result);
        BeanMapperUtil.copy(pcmInfoDO, result);
        log.info("开始参数转换,单位:分-->元,日期格式修改");
        //卡面值(元)
        result.setCardValue(new BigDecimal(pcmInfoDO.getCardValue()).divide(new BigDecimal(100)).toString());
        //余额(元)
        result.setTotalBal(new BigDecimal(pcmAcctinfoDO.getTotalBal()).divide(new BigDecimal(100)).toString());
        //可用金额(元)
        result.setValidBal(new BigDecimal(pcmAcctinfoDO.getValidBal()).divide(new BigDecimal(100)).toString());
        //冻结金额(元)
        result.setFrozenBal(new BigDecimal(pcmAcctinfoDO.getFrozenBal()).divide(new BigDecimal(100)).toString());
        //状态
        result.setCardState(PcmInfoDO.CardState.getDesc(pcmInfoDO.getCardState()));
        //日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date =  pcmInfoDO.getExpDate();
        if(date!=null)
        result.setExpDate(sdf.format(date));
        log.info("参数转换结束");
        return result;
    }
}

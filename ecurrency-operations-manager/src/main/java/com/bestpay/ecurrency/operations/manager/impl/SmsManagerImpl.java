package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.dal.mapper.SequenceProduceMapper;
import com.bestpay.ecurrency.operations.dal.mapper.SmsInterfaceMapper;
import com.bestpay.ecurrency.operations.dal.model.SmsInterfaceDO;
import com.bestpay.ecurrency.operations.manager.interfaces.ISmsManager;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 短信Manager类
 * <p>
 * 1.插入短信表
 * </p>
 * User: Jwxa Date: 2016/11/16 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
public class SmsManagerImpl implements ISmsManager {

    @Autowired
    private SmsInterfaceMapper smsInterfaceMapper;

    @Autowired
    private SequenceProduceMapper sequenceProduceMapper;

    @Override
    public int insertSms(String msgBody, String... mobile){
        String seq = sequenceProduceMapper.smsInterfaceSeq();
        SmsInterfaceDO smsInterfaceDO = new SmsInterfaceDO();
        smsInterfaceDO.setSmsSeq(Long.parseLong(seq));
        String mobiles = Joiner.on(",").skipNulls().join(mobile);
        smsInterfaceDO.setPhonenumber(mobiles);
        smsInterfaceDO.setContent(msgBody);
        smsInterfaceDO.setPriority("5");
        smsInterfaceDO.setIsLock((short)0);
        smsInterfaceDO.setCreateTime(new Date());
        return smsInterfaceMapper.insert(smsInterfaceDO);
    }



}

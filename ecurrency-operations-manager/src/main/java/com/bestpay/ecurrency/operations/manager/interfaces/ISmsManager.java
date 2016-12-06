package com.bestpay.ecurrency.operations.manager.interfaces;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/16 ProjectName: ecurrency-operations Version: 1.0
 */
public interface ISmsManager {

    /**
     * 向短信表中插入待发送的信息
     * @param msgBody 消息体
     * @param mobile 手机号
     * @return
     */
    int insertSms (String msgBody,String ... mobile);


}

package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.manager.model.BestpayCardInfoBO;

/**
 * 翼支付卡信息查询
 * <p>
 * 1.根据卡号查询翼支付卡信息
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
public interface IBestpayCardManager {

    /**
     * 根据卡号查询翼支付卡信息
     * @param cardNo 卡号
     * @return
     */
    BestpayCardInfoBO queryCardInfo(String cardNo);
}

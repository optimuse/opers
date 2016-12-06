package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class BestpayCardInfoDTO implements Serializable {

    /**
     * 卡号
     */
    private String cardNo;

    /**
     * 卡状态
     */
    private String cardState;

    /**
     * 卡面值(元)
     */
    private String cardValue;

    /**
     * 有效期
     */
    private String expDate;

    /**
     * 余额(元)
     */
    private String totalBal;

    /**
     * 可用金额(元)
     */
    private String validBal;

    /**
     * 冻结金额(元)
     */
    private String frozenBal;

}

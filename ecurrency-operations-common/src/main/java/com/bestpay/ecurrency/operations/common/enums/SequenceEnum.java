package com.bestpay.ecurrency.operations.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * 序列枚举
 * <p>
 * 1.SEQ_BILLING_NO:账单流水号
 * </p>
 * <p/>
 * User: yougq Date: 2016/04/11 ProductName: ecurreccy-operations Version: 1.0
 */
@Getter
@AllArgsConstructor
public enum SequenceEnum {

    //TODO 待定
    SEQ_TABLE_NO("SEQ_TABLE_NO", "SEQ_TABLE_NO");

    private final String code;

    private final String value;

    /**
     * @param code 名称
     * @return 枚举类
     */
    public static SequenceEnum explain(String code) {

        for (SequenceEnum sequenceEnum : SequenceEnum.values()) {
            if (sequenceEnum.code.equals(code)) {
                return sequenceEnum;
            }
        }
        return null;
    }

}

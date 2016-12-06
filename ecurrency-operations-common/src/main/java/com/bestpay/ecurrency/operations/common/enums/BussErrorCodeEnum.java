package com.bestpay.ecurrency.operations.common.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * <ul>
 * <li>错误码管理类</li>
 * <li>User: zhonglian Date: 14-11-18</li>
 * </ul>
 */

@Getter
@AllArgsConstructor
public enum BussErrorCodeEnum implements Serializable {

    /**
     * SUCCESS:成功
     */
    SUCCESS("SUCCESS", "成功"),

    /** 参数检验失败 */
    INVALID_PARAMETER("INVALID_PARAMETER", "参数检验失败"),


    ;

    private String errorCode;

    private String errorMsg;

    public static String explain(String errorCode) {
        for (BussErrorCodeEnum exception : BussErrorCodeEnum.values()) {
            if (null != exception && exception.getErrorCode().equals(errorCode)) {
                return exception.getErrorMsg();
            }
        }

        return errorCode;
    }

}
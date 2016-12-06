package com.bestpay.ecurrency.operations.common.exception;

import com.bestpay.exception.BaseException;
import com.bestpay.exception.ErrorCode;
import com.bestpay.utils.MessageHelper;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/11 ProjectName: ecurrency-operations Version: 1.0
 */
public class OperationsSystemException extends BaseException {
    public OperationsSystemException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public OperationsSystemException(ErrorCode errorCode, String extraMsg, Throwable cause) {
        super(errorCode, extraMsg, cause);
    }

    public OperationsSystemException(ErrorCode errorCode) {
        super(errorCode);
    }

    public OperationsSystemException(ErrorCode errorCode, String extraMsg) {
        super(errorCode, extraMsg);
    }

    public String getErrMsg() {
        return MessageHelper.formatMsg("{0}:{1}", new Object[]{getErrorCode().getCode(), getErrorCode().getDesc()});
    }

}

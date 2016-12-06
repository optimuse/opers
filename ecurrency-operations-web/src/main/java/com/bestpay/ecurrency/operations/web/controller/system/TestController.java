package com.bestpay.ecurrency.operations.web.controller.system;

import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试功能使用
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
@Controller
public class TestController {


    @RequestMapping("/test.do")
    public String test() {
        return "system/test";
    }

    @ResponseBody
    @RequestMapping("/testRuntimeException.do")
    public Map testRuntimeException() {
        throw new RuntimeException();
    }

    @ResponseBody
    @RequestMapping("/testOperationsException.do")
    public Map testOperationsException() {
        throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
    }

    @ResponseBody
    @RequestMapping("/testAjaxSuccess.do")
    public Map testAjaxSuccess() {
        return new HashMap();
    }
}

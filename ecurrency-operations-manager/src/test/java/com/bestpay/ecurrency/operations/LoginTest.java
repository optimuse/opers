package com.bestpay.ecurrency.operations;

import com.bestpay.ecurrency.operations.manager.interfaces.ILoginManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.bestpay.ecurrency.operations.common.util.MD5Util.MD5;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/14 ProjectName: ecurrency-operations Version: 1.0
 */

public class LoginTest extends BaseSpringTest{

    @Autowired
    private ILoginManager loginManager;

    @Test
    public void test(){
        LoginBO loginBO = new LoginBO();
        loginBO.setUsername("admin");
        loginBO.setPassword(MD5("test"));
        System.out.println(loginManager.validateLogin(loginBO));
    }
}

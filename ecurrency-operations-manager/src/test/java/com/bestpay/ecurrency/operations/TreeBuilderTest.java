package com.bestpay.ecurrency.operations;

import com.bestpay.ecurrency.operations.manager.interfaces.IIndexManager;
import com.bestpay.ecurrency.operations.manager.interfaces.ILoginManager;
import com.bestpay.ecurrency.operations.manager.interfaces.IPrivManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */

public class TreeBuilderTest extends BaseSpringTest {
    @Autowired
    private ILoginManager loginManager;
    @Autowired
    private IIndexManager indexManager;
    @Autowired
    private IPrivManager privManager;

    @Test
    public void test(){
        LoginBO loginBO  = new LoginBO();
        loginBO.setUsername("admin");
        loginBO.setPassword("xa6060jw");
        loginBO  = loginManager.validateLogin(loginBO);
        String path = "";
        String result = indexManager.createMenuHtml(path,loginBO);
        System.out.println(result);
    }


    @Test
    public void jsTreeTest(){
        System.out.println(privManager.allPrivJSON());
    }


}

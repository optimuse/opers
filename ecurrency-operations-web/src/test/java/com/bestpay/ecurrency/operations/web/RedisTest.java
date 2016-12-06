package com.bestpay.ecurrency.operations.web;

import com.bestpay.ecurrency.operations.common.cache.redis.RedisManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
public class RedisTest extends BaseSpringTest {

    @Autowired
    private RedisManager redisManager;


    @Test
    public void testAdd() throws InterruptedException {
        LoginBO loginBO  = new LoginBO();
        loginBO.setUsername("jwxa");
        List<LoginBO> value = new ArrayList<>();
        value.add(loginBO);
       boolean result = redisManager.insertObject(value,"loginBO",5000);
        Assert.assertEquals(true,result);
        Thread.sleep(10);
        List<LoginBO> loginBOList = redisManager.queryListByKey("loginBO",LoginBO.class);
        Assert.assertEquals(loginBOList.get(0).getUsername(),value.get(0).getUsername());
    }


}

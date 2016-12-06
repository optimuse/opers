package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.manager.model.LoginBO;

import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by Jwxa on 2016/11/9.
 */
public interface ILoginManager {

    BufferedImage createJcaptcha(HttpSession session);

    /**
     * 用户名密码验证
     * @param loginBO
     * @return
     */
    LoginBO validateLogin(LoginBO loginBO);

    /**
     * 通过用户名获取手机号，用于发送短信验证码
     */
    String queryMobileByUsername(String userName);
}

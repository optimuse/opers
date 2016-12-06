package com.bestpay.ecurrency.operations.manager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jwxa on 2016/11/9.
 */
@Getter
@Setter
@ToString
public class LoginBO extends BaseBO implements Serializable{

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 图片验证码
     */
    private String imgVerificationCode;

    /**
     * 短信验证码
     */
    private String smsVerificationCode;

    /**
     * 权限信息List
     */
    private List<PrivBO> privBOList;

    /**
     * 菜单信息List
     */
    private List<PrivBO> menuList;


}

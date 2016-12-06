package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/14 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class LoginDTO implements Serializable{
    /**
     * 用户名
     */
    @NotNull
    @NotEmpty
    private String username;

    /**
     * 登录密码
     */
    @NotNull
    @NotEmpty
    private String password;

    /**
     * 图片验证码
     */
    @NotNull
    @NotEmpty
    private String imgVerificationCode;

    /**
     * 短信验证码
     */
    @NotNull
    @NotEmpty
    private String smsVerificationCode;
}

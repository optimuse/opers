package com.bestpay.ecurrency.operations.web.interceptor.annotation;
import java.lang.annotation.*;

/**
 * 自定义注解 权限验证 <BR>
 * User: Jwxa<BR>
 * Date: 2015/8/5  Time: 13:52<BR>
 */


@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface PrivilegeValidate {
    String privKey()  default "";
}


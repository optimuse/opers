package com.bestpay.ecurrency.operations.manager.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息实体类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/20 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class StaffBO extends BaseBO implements Serializable{

    /**
     * 用户ID
     */
    private String staffId;

    /**
     * 用户帐号(与用户ID一致)
     */
    private String staffCode;

    /**
     * 真实姓名
     */
    private String staffName;

    /**
     * 所属机构id
     */
    private Long orgId;

    /**
     * 性别
     */
    private String sex;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 移动电话
     */
    private String mobile;

    /**
     * 固定电话
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certNbr;

    /**
     * 登陆密码 MD5加密
     */
    private String password;

    /**
     * 账户状态
     */
    private String stat;


}

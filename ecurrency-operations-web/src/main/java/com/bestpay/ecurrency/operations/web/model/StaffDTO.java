package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class StaffDTO extends TableReqDTO implements Serializable {

    /**
     * 用户ID
     */
    @NotNull
    @NotEmpty
    @Size(min=1,max=20)
    private String staffId;

    /**
     * 真实姓名
     */
    @NotNull
    @NotEmpty
    @Size(min=1,max=30)
    private String staffName;

    /**
     * 所属机构id
     */
    @NotNull
    private Long orgId;

    /**
     * 性别
     */
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^M|F$")
    private String sex;

    /**
     * 电子邮件
     */
    @NotNull
    @NotEmpty
    @Email
    private String email;

    /**
     * 移动电话
     */
    @NotNull
    @NotEmpty
    @Length(min = 11, max = 11)
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
    @NotNull
    @NotEmpty
    private String password;

    /**
     * 用户状态
     */
    private String stat;
}

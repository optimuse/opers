package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色信息请求实体类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/23 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class RoleDTO implements Serializable{

    private Integer roleId;

    private String roleName;

    private Short roleLayer;

    private Integer roleSeq;

    private String roleDesc;

    private String stat;

}

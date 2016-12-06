package com.bestpay.ecurrency.operations.manager.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/23 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class RoleBO extends BaseBO implements Serializable {

    private Integer roleId;

    private String roleName;

    private Short roleLayer;

    private Integer roleSeq;

    private String roleDesc;

    private String stat;

}

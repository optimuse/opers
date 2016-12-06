package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限信息请求类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/19 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class PrivDTO implements Serializable{
    /**
     * 权限id
     */
    private Integer privId;

    /**
     * 权限名称
     */
    private String privName;

    /**
     * 权限类型
     */
    private String privType;

    /**
     * 父权限id
     */
    private Integer parentPriv;

    /**
     * 显示顺序
     */
    private Integer showSeq;

    /**
     * 权限请求地址
     */
    private String privUrl;

    /**
     * 操作方式？？？
     */
    private String operMode;

    /**
     * 权限描述
     */
    private String privDesc;

    /**
     * 权限图标
     */
    private String privImg;

}

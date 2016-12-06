package com.bestpay.ecurrency.operations.manager.model;

import com.bestpay.ecurrency.operations.common.model.Node;
import lombok.ToString;

import java.io.Serializable;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/19 ProjectName: ecurrency-operations Version: 1.0
 */
@ToString
public class PrivBO extends Node implements Serializable{
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

    public Integer getPrivId() {
        return privId;
    }

    public void setPrivId(Integer privId) {
        this.privId = privId;
        super.setId(privId);
    }

    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName;
    }

    public String getPrivType() {
        return privType;
    }

    public void setPrivType(String privType) {
        this.privType = privType;
        super.setType(privType);
    }

    public Integer getParentPriv() {
        return parentPriv;
    }

    public void setParentPriv(Integer parentPriv) {
        this.parentPriv = parentPriv;
        super.setParentId(parentPriv);
    }

    public Integer getShowSeq() {
        return showSeq;
    }

    public void setShowSeq(Integer showSeq) {
        this.showSeq = showSeq;
    }

    public String getPrivUrl() {
        return privUrl;
    }

    public void setPrivUrl(String privUrl) {
        this.privUrl = privUrl;
    }

    public String getOperMode() {
        return operMode;
    }

    public void setOperMode(String operMode) {
        this.operMode = operMode;
    }

    public String getPrivDesc() {
        return privDesc;
    }

    public void setPrivDesc(String privDesc) {
        this.privDesc = privDesc;
    }

    public String getPrivImg() {
        return privImg;
    }

    public void setPrivImg(String privImg) {
        this.privImg = privImg;
    }
}

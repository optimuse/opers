package com.bestpay.ecurrency.operations.dal.model;

import lombok.ToString;

@ToString(callSuper = true)
public class EoSymPrivDO{
    private Integer privId;

    private String privName;

    private String privType;

    private Integer parentPriv;

    private Integer showSeq;

    private String privUrl;

    private String operMode;

    private String privDesc;

    private String stat;

    private String privImg;

    public Integer getPrivId() {
        return privId;
    }

    public void setPrivId(Integer privId) {
        this.privId = privId;
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
    }

    public Integer getParentPriv() {
        return parentPriv;
    }

    public void setParentPriv(Integer parentPriv) {
        this.parentPriv = parentPriv;
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getPrivImg() {
        return privImg;
    }

    public void setPrivImg(String privImg) {
        this.privImg = privImg;
    }

    public enum PrivType{
        MENU("菜单"),
        FUNC("按键"),
        ;
        private String desc;

        PrivType(String desc) {
            this.desc = desc;
        }
    }
}
package com.bestpay.ecurrency.operations.dal.model;

public class EoSymDictDO extends EoSymDictDOKey {
    private String dictName;

    private String stat;

    private String dictDesc;

    private Short showSeq;

    private String isDefault;

    private String canModify;

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public Short getShowSeq() {
        return showSeq;
    }

    public void setShowSeq(Short showSeq) {
        this.showSeq = showSeq;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getCanModify() {
        return canModify;
    }

    public void setCanModify(String canModify) {
        this.canModify = canModify;
    }
}
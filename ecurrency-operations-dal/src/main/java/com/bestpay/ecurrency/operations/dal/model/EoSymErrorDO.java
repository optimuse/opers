package com.bestpay.ecurrency.operations.dal.model;

public class EoSymErrorDO {
    private String errorCode;

    private String errorInfo;

    private String moduleCode;

    private String errorLevel;

    private String handler;

    private String stat;

    private String codeOut;

    private String infoOut;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getCodeOut() {
        return codeOut;
    }

    public void setCodeOut(String codeOut) {
        this.codeOut = codeOut;
    }

    public String getInfoOut() {
        return infoOut;
    }

    public void setInfoOut(String infoOut) {
        this.infoOut = infoOut;
    }
}
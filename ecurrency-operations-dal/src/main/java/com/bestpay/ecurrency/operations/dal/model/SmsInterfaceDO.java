package com.bestpay.ecurrency.operations.dal.model;

import java.util.Date;

public class SmsInterfaceDO {
    private Long smsSeq;

    private String phonenumber;

    private String priority;

    private String smsid;

    private String content;

    private Long subcode;

    private String sendtime;

    private Date createTime;

    private String operType;

    private String sourceIp;

    private Short isLock;

    private Date lockTime;

    public Long getSmsSeq() {
        return smsSeq;
    }

    public void setSmsSeq(Long smsSeq) {
        this.smsSeq = smsSeq;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSmsid() {
        return smsid;
    }

    public void setSmsid(String smsid) {
        this.smsid = smsid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSubcode() {
        return subcode;
    }

    public void setSubcode(Long subcode) {
        this.subcode = subcode;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public Short getIsLock() {
        return isLock;
    }

    public void setIsLock(Short isLock) {
        this.isLock = isLock;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}
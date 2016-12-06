package com.bestpay.ecurrency.operations.dal.model;

import lombok.ToString;

import java.util.Date;

@ToString
public class EoSymStaffDO {
    private String staffId;

    private String staffCode;

    private String staffName;

    private Long orgId;

    private String sex;

    private String photo;

    private String email;

    private String mobile;

    private String phone;

    private String address;

    private String zip;

    private String certType;

    private String certNbr;

    private Date effDate;

    private Date expDate;

    private String password;

    private String pwdStat;

    private String pwdCtrl;

    private Date pwdNewtime;

    private Integer pwdValidday;

    private Short pwdErrtimes;

    private Short pwdTrytimes;

    private String memo;

    private String stat;

    private Date errTimeCursor;

    private String pwdChange1;

    private String pwdChange2;

    private String pwdChange3;

    private String pwdChange4;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNbr() {
        return certNbr;
    }

    public void setCertNbr(String certNbr) {
        this.certNbr = certNbr;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwdStat() {
        return pwdStat;
    }

    public void setPwdStat(String pwdStat) {
        this.pwdStat = pwdStat;
    }

    public String getPwdCtrl() {
        return pwdCtrl;
    }

    public void setPwdCtrl(String pwdCtrl) {
        this.pwdCtrl = pwdCtrl;
    }

    public Date getPwdNewtime() {
        return pwdNewtime;
    }

    public void setPwdNewtime(Date pwdNewtime) {
        this.pwdNewtime = pwdNewtime;
    }

    public Integer getPwdValidday() {
        return pwdValidday;
    }

    public void setPwdValidday(Integer pwdValidday) {
        this.pwdValidday = pwdValidday;
    }

    public Short getPwdErrtimes() {
        return pwdErrtimes;
    }

    public void setPwdErrtimes(Short pwdErrtimes) {
        this.pwdErrtimes = pwdErrtimes;
    }

    public Short getPwdTrytimes() {
        return pwdTrytimes;
    }

    public void setPwdTrytimes(Short pwdTrytimes) {
        this.pwdTrytimes = pwdTrytimes;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Date getErrTimeCursor() {
        return errTimeCursor;
    }

    public void setErrTimeCursor(Date errTimeCursor) {
        this.errTimeCursor = errTimeCursor;
    }

    public String getPwdChange1() {
        return pwdChange1;
    }

    public void setPwdChange1(String pwdChange1) {
        this.pwdChange1 = pwdChange1;
    }

    public String getPwdChange2() {
        return pwdChange2;
    }

    public void setPwdChange2(String pwdChange2) {
        this.pwdChange2 = pwdChange2;
    }

    public String getPwdChange3() {
        return pwdChange3;
    }

    public void setPwdChange3(String pwdChange3) {
        this.pwdChange3 = pwdChange3;
    }

    public String getPwdChange4() {
        return pwdChange4;
    }

    public void setPwdChange4(String pwdChange4) {
        this.pwdChange4 = pwdChange4;
    }
}
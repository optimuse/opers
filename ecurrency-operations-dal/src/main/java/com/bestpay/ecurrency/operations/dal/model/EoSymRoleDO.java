package com.bestpay.ecurrency.operations.dal.model;

public class EoSymRoleDO{
    private Integer roleId;

    private String roleName;

    private Short roleLayer;

    private Integer roleSeq;

    private String roleDesc;

    private String stat;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Short getRoleLayer() {
        return roleLayer;
    }

    public void setRoleLayer(Short roleLayer) {
        this.roleLayer = roleLayer;
    }

    public Integer getRoleSeq() {
        return roleSeq;
    }

    public void setRoleSeq(Integer roleSeq) {
        this.roleSeq = roleSeq;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
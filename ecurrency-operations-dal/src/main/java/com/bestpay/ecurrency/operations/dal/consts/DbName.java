package com.bestpay.ecurrency.operations.dal.consts;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/30 ProjectName: ecurrency-operations Version: 1.0
 */
public enum DbName {
    PCPF("pcpf"),
    TYVC("tyvc"),
    ;

    private String name;

    DbName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

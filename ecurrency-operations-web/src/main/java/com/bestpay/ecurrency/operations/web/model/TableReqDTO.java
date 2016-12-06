package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/22 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class TableReqDTO implements Serializable {
    /**
     * 页容量
     */
    private int limit;
    /**
     * 起始行
     */
    private int offset;
    /**
     * 排序
     */
    private String order;
    /**
     * 关键字
     */
    private String search;
    /**
     * 排序列
     */
    private String sort;



}

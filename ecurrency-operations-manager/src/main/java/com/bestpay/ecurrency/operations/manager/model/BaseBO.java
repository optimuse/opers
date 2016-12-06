package com.bestpay.ecurrency.operations.manager.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class BaseBO implements Serializable {

    /**
     * 数据库主键
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 最后更新人
     */
    private String updatedBy;

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

package com.bestpay.ecurrency.operations.web.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
@Data
public class TableRespDTO <T> implements Serializable {

    private static final long serialVersionUID = 768549219446295665L;
    private long total;  //总条数
    private List<T> records; //当前页显示数据

}

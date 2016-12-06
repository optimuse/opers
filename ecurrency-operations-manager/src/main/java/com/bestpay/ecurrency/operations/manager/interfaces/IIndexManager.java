package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.manager.model.LoginBO;

/**
 * 首页面相关功能接口
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
public interface IIndexManager {

    /**
     * 生成菜单树的Html文本
     * @param loginBO
     * @return
     */
    String createMenuHtml(String path,LoginBO loginBO);
}

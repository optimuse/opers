package com.bestpay.ecurrency.operations.manager.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.dal.model.EoSymPrivDO;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;

import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/18 ProjectName: ecurrency-operations Version: 1.0
 */
public interface IPrivManager {

    /**
     * 获取所有有效状态的权限节点并排序
     *
     * @return
     */
    List<PrivBO> queryAllPrivInfoList();


    /**
     * 新增权限节点
     *
     * @param eoSymPrivDO
     * @return
     */
    int insertPrivInfo(EoSymPrivDO eoSymPrivDO);


    /**
     * 获取所有权限的JSON对象 用于JsTree前端插件使用
     * @return
     */
    JSONObject allPrivJSON();

    /**
     * 查询权限详情信息
     * @param privBO
     * @return
     */
    PrivBO queryPrivInfoDetail(PrivBO privBO);

    /**
     * 修改权限信息
     * @param privBO
     * @return
     */
    void modifyPrivInfo(PrivBO privBO);
}

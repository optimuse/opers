package com.bestpay.ecurrency.operations.manager.interfaces;

import com.bestpay.ecurrency.operations.manager.model.PrivBO;

import java.util.List;

/**
 * 权限验证管理类
 * <p>
 * 1.验证是否有按键/页面的权限
 * </p>
 * User: Jwxa Date: 2016/11/14 ProjectName: ecurrency-operations Version: 1.0
 */
public interface IRoleprivManager {


    /**
     * 验证是否有按键/页面的权限
     * @param privBOList session中的权限列表
     * @param privKey 切点对应的Key
     * @return
     */
    boolean validateRolePriv(List<PrivBO> privBOList,String privKey);
}

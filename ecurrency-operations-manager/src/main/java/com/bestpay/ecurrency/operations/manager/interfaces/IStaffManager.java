package com.bestpay.ecurrency.operations.manager.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.manager.model.RoleBO;
import com.bestpay.ecurrency.operations.manager.model.StaffBO;

import java.util.List;
import java.util.Set;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/20 ProjectName: ecurrency-operations Version: 1.0
 */
public interface IStaffManager {

    /**
     * 添加用户信息
     * @param staffBO
     */
    void addStaff(StaffBO staffBO);

    /**
     * 根据条件查询用户信息列表
     * @param staffBO 条件实体类
     * @return
     */
    List<StaffBO> queryStaffList(StaffBO staffBO);

    /**
     * 查询用户详情
     * @param staffBO
     * @return
     */
    List<StaffBO> queryStaffInfoDetail(StaffBO staffBO);

    /**
     * 根据用户id查询角色
     * @param staffBO
     * @return
     */
    List<RoleBO> queryRoleList(StaffBO staffBO);

    /**
     * jsTree 所有角色的树形视图
     * @param roleList
     * @return
     */
    JSONObject allRoleJSON(List<RoleBO> roleList);

    /**
     * 锁定员工
     * @param staffBO
     */
    void lockStaff(StaffBO staffBO);

    /**
     * 解锁用户
     * @param staffBO
     */
    void unlockStaff(StaffBO staffBO);

    /**
     * 角色分配
     * @param nowRoleIdSet
     * @param todoRoleIdSet
     */
    void allocateRole(Set<Integer> nowRoleIdSet, Set<Integer> todoRoleIdSet, StaffBO staffBO);

    /**
     * 清除某用户下的所有角色
     * @param staffBO
     */
    void delAllRole(StaffBO staffBO);
}

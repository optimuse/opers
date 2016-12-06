package com.bestpay.ecurrency.operations.web.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.model.Node;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.manager.interfaces.IStaffManager;
import com.bestpay.ecurrency.operations.manager.model.RoleBO;
import com.bestpay.ecurrency.operations.manager.model.StaffBO;
import com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate;
import com.bestpay.ecurrency.operations.web.model.RoleDTO;
import com.bestpay.ecurrency.operations.web.model.StaffDTO;
import com.bestpay.ecurrency.operations.web.model.TableRespDTO;
import com.github.pagehelper.Page;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.collect.Sets.intersection;

/**
 * 用户管理
 * <p>
 * 1.新增用户
 * 2.查询用户列表
 * </p>
 * User: Jwxa Date: 2016/11/18 ProjectName: ecurrency-operations Version: 1.0
 */
@Controller
@RequestMapping("/sym")
public class StaffController {

    @Autowired
    private IStaffManager staffManager;

    @PrivilegeValidate(privKey = "/sym/staffMgr.do")
    @RequestMapping(value = "/staffMgr.do",method = RequestMethod.GET)
    public String staffMgr(){
        return "system/staff";
    }

    /**
     * 新增用户
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addStaff.do",method = RequestMethod.POST)
    public Map<String,Object> addStaff(@Valid StaffDTO staffDTO, BindingResult result){
        if (result.hasErrors()) {
            throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
        }
        Map<String,Object> resultMap = new HashMap<>();
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO,StaffBO.class);
        staffManager.addStaff(staffBO);
        //TODO DICT获取
        resultMap.put("successMsg","新用户创建成功");
        return resultMap;
    }


    /**
     * 查询用户列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryStaffList.do",method = RequestMethod.POST)
    public Map<String,Object> queryStaffList(@RequestBody StaffDTO staffDTO){
        Map<String,Object> resultMap = new HashMap<>();
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO,StaffBO.class);
        List<StaffBO> staffBOList = staffManager.queryStaffList(staffBO);
        TableRespDTO<StaffBO> tableRespDTO = new TableRespDTO<>();
        tableRespDTO.setRecords(staffBOList);
        tableRespDTO.setTotal(((Page<StaffBO>)staffBOList).getTotal());
        resultMap.put("table",tableRespDTO);
        return resultMap;
    }


    /**
     * 查询角色列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryRoleList.do",method = RequestMethod.POST)
    public Map<String,Object> queryRoleList(StaffDTO staffDTO){
        Map<String,Object> resultMap = new HashMap<>();
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO,StaffBO.class);
        List<RoleBO> roleList = staffManager.queryRoleList(staffBO);
        JSONObject json = new JSONObject();
        json.put("core",staffManager.allRoleJSON(roleList));
        resultMap.put("jsTreeObj",json);
        resultMap.put("roleList",BeanMapperUtil.mapList(roleList, RoleDTO.class));
        return resultMap;
    }


    /**
     * 分配角色权限
     **/
    @ResponseBody
    @RequestMapping(value = "/allocateRole.do",method = RequestMethod.POST)
    public Map<String,Object> allocateRole(StaffDTO staffDTO,@RequestParam(value = "nodeArray[]") Integer[] nodeArray){
        Map<String,Object> resultMap = new HashMap<>();
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO,StaffBO.class);
        //1.获取该用户当前拥有的所有角色
        List<RoleBO> nowRoleList = staffManager.queryRoleList(staffBO);
        Set<Integer> nowRoleIdSet = new HashSet<>();
        if(nowRoleList!=null&&!nowRoleList.isEmpty()){
            nowRoleIdSet = nowRoleList.stream().map(RoleBO::getRoleId).collect(Collectors.toSet());
        }
        //2.用户要改成的角色
        Set<Integer> todoRoleIdSet =  Sets.newHashSet(nodeArray);
        staffManager.allocateRole(nowRoleIdSet,todoRoleIdSet,staffBO);
        resultMap.put("successMsg","角色分配完成");
        return resultMap;
    }


    /**
     * 清除用户的所有角色权限
     **/
    @ResponseBody
    @RequestMapping(value = "/delRole.do",method = RequestMethod.POST)
    public Map<String,Object> delRole(StaffDTO staffDTO) {
        Map<String, Object> resultMap = new HashMap<>();
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO, StaffBO.class);
        if(staffDTO==null||StringUtils.isBlank(staffDTO.getStaffId())){
            throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
        }
        staffManager.delAllRole(staffBO);
        resultMap.put("successMsg","角色分配完成");
        return  resultMap;
    }







        /**
         * 锁定用户
         **/
    @ResponseBody
    @RequestMapping(value = "/lockStaff.do",method = RequestMethod.POST)
    public Map<String,Object> lockStaff(StaffDTO staffDTO){
        if(staffDTO==null|| StringUtils.isBlank(staffDTO.getStaffId())){
            throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
        }
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO,StaffBO.class);
        Map<String,Object> resultMap = new HashMap<>();
        staffManager.lockStaff(staffBO);
        resultMap.put("successMsg","锁定用户成功");
        return resultMap;
    }


    /**
     * 解锁用户
     **/
    @ResponseBody
    @RequestMapping(value = "/unlockStaff.do",method = RequestMethod.POST)
    public Map<String,Object> unlockStaff(StaffDTO staffDTO){
        if(staffDTO==null|| StringUtils.isBlank(staffDTO.getStaffId())){
            throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
        }
        StaffBO staffBO = BeanMapperUtil.objConvert(staffDTO,StaffBO.class);
        Map<String,Object> resultMap = new HashMap<>();
        staffManager.unlockStaff(staffBO);
        resultMap.put("successMsg","解锁用户成功");
        return resultMap;
    }




}

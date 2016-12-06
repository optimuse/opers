package com.bestpay.ecurrency.operations.manager.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.common.util.MD5Util;
import com.bestpay.ecurrency.operations.dal.mapper.EoSymRoleMapper;
import com.bestpay.ecurrency.operations.dal.mapper.EoSymStaffMapper;
import com.bestpay.ecurrency.operations.dal.mapper.EoSymStaffRoleMapper;
import com.bestpay.ecurrency.operations.dal.model.*;
import com.bestpay.ecurrency.operations.manager.interfaces.IStaffManager;
import com.bestpay.ecurrency.operations.manager.model.RoleBO;
import com.bestpay.ecurrency.operations.manager.model.StaffBO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/20 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
@Slf4j
public class StaffManagerImpl implements IStaffManager {
    @Autowired
    private EoSymStaffMapper symStaffMapper;
    @Autowired
    private EoSymStaffRoleMapper eoSymStaffRoleMapper;
    @Autowired
    private EoSymRoleMapper eoSymRoleMapper;


    @Override
    public void addStaff(StaffBO staffBO) {
        EoSymStaffDO eoSymStaffDO = BeanMapperUtil.objConvert(staffBO,EoSymStaffDO.class);
        log.info("开始新增用户:{}，先判断用户是否已经存在",staffBO.getStaffId());
        List<StaffBO> existStaffList = queryStaffInfoDetail(staffBO);
        if(existStaffList!=null&&!existStaffList.isEmpty()){
            throw new OperationsSystemException(OperationSystemErrorCode.USERNAME_ALREADY_BEEN_REGISTERED);
        }
        log.info("用户名没有被使用");
        eoSymStaffDO.setStaffCode(eoSymStaffDO.getStaffId());
        eoSymStaffDO.setStat(EoSymStaffDOExample.Stat.S0A.name());
        eoSymStaffDO.setPwdStat(EoSymStaffDOExample.PwdStat.S0A.name());
        eoSymStaffDO.setPwdCtrl("MD5");
        log.info("进行MD5加密");
        eoSymStaffDO.setPassword(MD5Util.MD5(eoSymStaffDO.getPassword()));
        log.info("执行数据库写入操作");
        int i = symStaffMapper.insert(eoSymStaffDO);
        if(i==0){
            throw  new OperationsSystemException(OperationSystemErrorCode.DATABASE_INSERT_FAILED);
        }
    }

    @Override
    public List<StaffBO> queryStaffList(StaffBO staffBO) {
        EoSymStaffDOExample example = new EoSymStaffDOExample();
        EoSymStaffDOExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(staffBO.getStaffId()))
            criteria.andStaffIdLike("%" + staffBO.getStaffId()+"%");
        if(StringUtils.isNotBlank(staffBO.getStaffName()))
            criteria.andStaffNameLike("%" + staffBO.getStaffName()+"%");
        if(StringUtils.isNotBlank(staffBO.getSex()))
            criteria.andSexEqualTo(staffBO.getSex());
        if(StringUtils.isNotBlank(staffBO.getStat()))
            criteria.andStatEqualTo(staffBO.getStat());
        //mybatis分页插件引入
        PageHelper.startPage(staffBO.getOffset()/staffBO.getLimit()+1, staffBO.getLimit());
        List<EoSymStaffDO> symStaffDOList =  symStaffMapper.selectByExample(example);
        PageInfo page = new PageInfo(symStaffDOList);
        Page<StaffBO> resultList = new Page<>();
        resultList.setTotal(page.getTotal());//总行数
        for(EoSymStaffDO eoSymStaffDO:symStaffDOList){
            StaffBO bo = BeanMapperUtil.objConvert(eoSymStaffDO,StaffBO.class);
            //屏蔽密码信息
            bo.setPassword(null);
            //TODO DICT获取
            bo.setSex(EoSymStaffDOExample.Sex.getDesc(eoSymStaffDO.getSex()));
            bo.setStat(EoSymStaffDOExample.Stat.getDesc(eoSymStaffDO.getStat()));
            resultList.add(bo);
        }
        return resultList;
    }

    @Override
    public List<StaffBO> queryStaffInfoDetail(StaffBO staffBO) {
        EoSymStaffDOExample example = new EoSymStaffDOExample();
        example.createCriteria().andStaffIdEqualTo(staffBO.getStaffId());
        List<EoSymStaffDO> symStaffDOList = symStaffMapper.selectByExample(example);
        List<StaffBO> resultList = new ArrayList<>();
        for(EoSymStaffDO eoSymStaffDO:symStaffDOList){
            resultList.add(BeanMapperUtil.objConvert(eoSymStaffDO,StaffBO.class));
        }
        return resultList;
    }

    @Override
    public List<RoleBO> queryRoleList(StaffBO staffBO) {
        EoSymStaffRoleDOExample example = new EoSymStaffRoleDOExample();
        if(staffBO!=null&&staffBO.getStaffId()!=null){
            example.createCriteria().andStaffIdEqualTo(staffBO.getStaffId());
        }
        List<EoSymStaffRoleDOKey> eoSymStaffRoleDOKeyList = eoSymStaffRoleMapper.selectByExample(example);
        if(eoSymStaffRoleDOKeyList==null||eoSymStaffRoleDOKeyList.isEmpty()){
            return null;
        }
        List<Integer> roleIdList = new ArrayList<>();
        for(EoSymStaffRoleDOKey eoSymStaffRoleDOKey:eoSymStaffRoleDOKeyList){
            roleIdList.add(eoSymStaffRoleDOKey.getRoleId());
        }
        EoSymRoleDOExample eoSymRoleDOExample = new EoSymRoleDOExample();
        eoSymRoleDOExample.createCriteria().andRoleIdIn(roleIdList).andStatEqualTo(EoSymRoleDOExample.Stat.S0A.name());
        List<EoSymRoleDO> eoSymRoleDOList = eoSymRoleMapper.selectByExample(eoSymRoleDOExample);
        if(eoSymRoleDOList==null||eoSymRoleDOList.isEmpty()){
            return null;
        }
        return BeanMapperUtil.mapList(eoSymRoleDOList,RoleBO.class);
    }

    @Override
    public JSONObject allRoleJSON(List<RoleBO> roleList) {
        if(roleList==null){
            return null;
        }
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (RoleBO role : roleList) {
            JSONObject roleJSON = new JSONObject();
            roleJSON.put("text",role.getRoleName());
            roleJSON.put("icon","fa fa-user");
            JSONObject attrJSON = new JSONObject();
            attrJSON.put("id",role.getRoleId());
            roleJSON.put("attr",attrJSON);
            jsonArray.add(roleJSON);
        }
        jsonObject.put("data",jsonArray);
        return jsonObject;
    }

    @Override
    public void lockStaff(StaffBO staffBO) {
        String staffId = staffBO.getStaffId();
        if("admin".equals(staffId)){
            throw new OperationsSystemException(OperationSystemErrorCode.ADMIN_CAN_NOT_BE_LOCKED);
        }
        EoSymStaffDO record = new EoSymStaffDO();
        record.setStat(EoSymStaffDOExample.Stat.S0F.name());
        EoSymStaffDOExample example = new EoSymStaffDOExample();
        example.createCriteria().andStaffIdEqualTo(staffId);
        int i = symStaffMapper.updateByExampleSelective(record,example);
        if(i!=1){
            throw new OperationsSystemException(OperationSystemErrorCode.DATABASE_UPDATE_FAILED);
        }
    }

    @Override
    public void unlockStaff(StaffBO staffBO) {
        String staffId = staffBO.getStaffId();
        EoSymStaffDO record = new EoSymStaffDO();
        record.setStat(EoSymStaffDOExample.Stat.S0A.name());
        EoSymStaffDOExample example = new EoSymStaffDOExample();
        example.createCriteria().andStaffIdEqualTo(staffId);
        int i = symStaffMapper.updateByExampleSelective(record,example);
        if(i!=1){
            throw new OperationsSystemException(OperationSystemErrorCode.DATABASE_UPDATE_FAILED);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
    public void allocateRole(Set<Integer> nowRoleIdSet, Set<Integer> todoRoleIdSet, StaffBO staffBO) {
        log.info("角色分配,当前该用户拥有的角色id:{},改变后的角色id:{}",nowRoleIdSet,todoRoleIdSet);
        Set<Integer> noNeedToDoSet = Sets.intersection(nowRoleIdSet, todoRoleIdSet);
        Set<Integer> toDelSet = Sets.difference(nowRoleIdSet,noNeedToDoSet);
        log.info("该用户要删除的相关角色id为:{}",toDelSet);
        Set<Integer> toAddSet = Sets.difference(todoRoleIdSet,noNeedToDoSet);
        if(!toDelSet.isEmpty()){
            EoSymStaffRoleDOExample delExample = new EoSymStaffRoleDOExample();
            delExample.createCriteria().andStaffIdEqualTo(staffBO.getStaffId()).andRoleIdIn(new ArrayList<>(toDelSet));
            eoSymStaffRoleMapper.deleteByExample(delExample);
        }
        log.info("该用户要新增的相关角色id为:{}",toAddSet);
        if(!toAddSet.isEmpty()){
            Iterator<Integer> iterator = toAddSet.iterator();
            while(iterator.hasNext()){
                EoSymStaffRoleDOKey record = new EoSymStaffRoleDOKey();
                record.setStaffId(staffBO.getStaffId());
                record.setRoleId(iterator.next());
                eoSymStaffRoleMapper.insert(record);
            }
            log.info("角色分配完成");
        }

    }

    @Override
    public void delAllRole(StaffBO staffBO) {
        EoSymStaffRoleDOExample example = new EoSymStaffRoleDOExample();
        example.createCriteria().andStaffIdEqualTo(staffBO.getStaffId());
        eoSymStaffRoleMapper.deleteByExample(example);
    }


}

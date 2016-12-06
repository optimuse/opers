package com.bestpay.ecurrency.operations.web.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.manager.interfaces.IPrivManager;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate;
import com.bestpay.ecurrency.operations.web.model.PrivDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 权限管理
 * <p>
 * 1.进入权限管理页面
 * </p>
 * User: Jwxa Date: 2016/11/18 ProjectName: ecurrency-operations Version: 1.0
 */
@Controller
@RequestMapping("/sym")
public class PrivController {

    @Autowired
    private IPrivManager privManager;

    /**
     * 进入权限管理页面
     */
    @PrivilegeValidate(privKey = "/sym/privMgr.do")
    @RequestMapping(value = "/privMgr.do",method = RequestMethod.GET)
    public String privMgr(){
        return "system/priv";
    }

    @ResponseBody
    @RequestMapping(value = "/queryPrivInfo.do",method = RequestMethod.GET)
    public Map<String,Object> queryPrivInfo(){
        Map<String,Object> resultMap = new HashMap<>();
        JSONObject json = new JSONObject();
        json.put("core",privManager.allPrivJSON());
        resultMap.put("jsTreeObj",json);
        return resultMap;
    }


    @ResponseBody
    @RequestMapping(value = "/queryPrivInfoDetail.do",method = RequestMethod.POST)
    public Map<String,Object> queryPrivInfoDetail(PrivDTO privDTO){
        Map<String,Object> resultMap = new HashMap<>();
        PrivBO privBO = BeanMapperUtil.objConvert(privDTO, PrivBO.class);
        PrivBO privRespBO = privManager.queryPrivInfoDetail(privBO);
        resultMap.put("privResp",BeanMapperUtil.objConvert(privRespBO,PrivDTO.class));
        return resultMap;
    }

    @PrivilegeValidate(privKey = "com.bestpay.ecurrency.operations.web.controller.system.PrivController.modifyPrivInfo1")
    @ResponseBody
    @RequestMapping(value = "/modifyPrivInfo.do",method = RequestMethod.POST)
    public Map<String,Object> modifyPrivInfo(PrivDTO privDTO){
        PrivBO privBO = BeanMapperUtil.objConvert(privDTO, PrivBO.class);
        privManager.modifyPrivInfo(privBO);
        return new HashMap<>();
    }



}

package com.bestpay.ecurrency.operations.manager.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.model.Node;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.common.util.ReflectionUtils;
import com.bestpay.ecurrency.operations.common.util.TreeBuilder;
import com.bestpay.ecurrency.operations.dal.mapper.EoSymPrivMapper;
import com.bestpay.ecurrency.operations.dal.model.EoSymPrivDO;
import com.bestpay.ecurrency.operations.dal.model.EoSymPrivDOExample;
import com.bestpay.ecurrency.operations.manager.interfaces.IPrivManager;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/18 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
public class PrivManagerImpl implements IPrivManager {

    @Autowired
    private EoSymPrivMapper eoSymPrivMapper;

    public List<PrivBO> queryAllPrivInfoList(){
        EoSymPrivDOExample example = new EoSymPrivDOExample();
        example.setOrderByClause("parent_priv,show_seq");
        example.createCriteria().andStatEqualTo(EoSymPrivDOExample.Stat.S0A.name());
        List<EoSymPrivDO> eoSymPrivDOList = eoSymPrivMapper.selectByExample(example);
        List<PrivBO> resultList = new ArrayList<>();
        for(EoSymPrivDO eoSymPrivDO:eoSymPrivDOList){
            resultList.add(BeanMapperUtil.objConvertOld(eoSymPrivDO,PrivBO.class));
        }
        return resultList;
    }

    public int insertPrivInfo(EoSymPrivDO eoSymPrivDO){
        return eoSymPrivMapper.insert(eoSymPrivDO);
    }



    private<T extends Node> JSONObject tranJsTreeJSON(List<T> treeList, String propertyName) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (T node : treeList) {
            jsonArray.add(getJsonObject(node,propertyName));
        }
        jsonObject.put("data",jsonArray);
        jsonObject.put("check_callback",true);
        return jsonObject;
    }

    /**
     *
     * @param node
     * @param propertyName 通过反射属性名获取需要展示的名称
     * @param <T>
     * @return
     */
    private<T extends Node> JSONObject getJsonObject(T node, String propertyName){
        JSONObject jsonObject = new JSONObject();
        String showStr = (String) ReflectionUtils.getBeanValue(node,propertyName);
        jsonObject.put("text",showStr);
        if(node.isLeaf()){
            //判断该节点是否是按键类型
            if(StringUtils.isNotBlank(node.getType())&&node.getType().equals(EoSymPrivDO.PrivType.FUNC.name())){
                jsonObject.put("icon","fa fa-tag");
            }else{
                jsonObject.put("icon","fa fa-file-code-o");
            }
        }else{
            List<? extends Node> children =  node.getChildren();
            JSONArray array = new JSONArray();
            boolean menuFlag = true;
            for (Node child : children) {
                menuFlag = menuFlag&&child.getType().equals(EoSymPrivDO.PrivType.FUNC.name());
                JSONObject object = getJsonObject(child,propertyName);
                array.add(object);
            }
            if(menuFlag){
                jsonObject.put("icon","fa fa-file-code-o");
            }
            jsonObject.put("children",array);
            JSONObject stateObj = new JSONObject();
            stateObj.put("opened",true);
            jsonObject.put("state",stateObj);
        }
        Integer privId = (Integer) ReflectionUtils.getBeanValue(node,"privId");
        JSONObject privInfoJSON = new JSONObject();
        privInfoJSON.put("id",privId);
        jsonObject.put("attr",privInfoJSON);
        return jsonObject;
    }


    public JSONObject allPrivJSON(){
        List<PrivBO> privBOList = queryAllPrivInfoList();
        TreeBuilder tb =new TreeBuilder();
        List<PrivBO> treeList = tb.buildListToTree(privBOList);
        JSONObject jsonObject = tranJsTreeJSON(treeList,"privName");
        return jsonObject;
    }

    @Override
    public PrivBO queryPrivInfoDetail(PrivBO privBO) {
        EoSymPrivDOExample example = new EoSymPrivDOExample();
        example.createCriteria().andStatEqualTo(EoSymPrivDOExample.Stat.S0A.name()).andPrivIdEqualTo(privBO.getPrivId());
        List<EoSymPrivDO>  resultList = eoSymPrivMapper.selectByExample(example);
        if(resultList==null||resultList.isEmpty()||resultList.size()>1){
            throw new OperationsSystemException(OperationSystemErrorCode.DATABASE_SELECT_FAILED);
        }
        return BeanMapperUtil.objConvert(resultList.get(0),PrivBO.class);
    }

    @Override
    public void modifyPrivInfo(PrivBO privBO) {
        //查询条件
        EoSymPrivDOExample example = new EoSymPrivDOExample();
        example.createCriteria().andPrivIdEqualTo(privBO.getPrivId()).andStatEqualTo(EoSymPrivDOExample.Stat.S0A.name());
        //修改条件
        EoSymPrivDO modifyDO = BeanMapperUtil.objConvert(privBO,EoSymPrivDO.class);
        int i =eoSymPrivMapper.updateByExampleSelective(modifyDO,example);
        if (i==0){
            throw new OperationsSystemException(OperationSystemErrorCode.DATABASE_UPDATE_FAILED);
        }
    }
}

package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.manager.interfaces.IRoleprivManager;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/14 ProjectName: ecurrency-operations Version: 1.0
 */
@Slf4j
@Service
public class RoleprivManagerImpl implements IRoleprivManager {

    @Override
    public boolean validateRolePriv(List<PrivBO> privBOList,String privKey) {
        boolean flag = false;
        return existPrivByPrivUrl(privBOList,privKey,flag);
    }

    private boolean existPrivByPrivUrl(List<PrivBO> privBOList, String privKey,boolean flag){
        for(PrivBO privBO:privBOList){
            log.debug("开始判断权限，privBO{}",privBO);
            if(privBO.isLeaf()){
                flag =  flag||(privKey.equalsIgnoreCase(privBO.getPrivUrl()));
            }else{
                flag =  flag||privKey.equalsIgnoreCase(privBO.getPrivUrl())|| existPrivByPrivUrl((List<PrivBO>) privBO.getChildren(),privKey,flag);
            }
            if(flag){
                log.debug("找到权限配置,通过,privBO:{}",privBO);
                return flag;
            }
        }
        return flag;
    }
}

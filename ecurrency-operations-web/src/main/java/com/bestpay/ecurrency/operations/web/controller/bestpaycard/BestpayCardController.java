package com.bestpay.ecurrency.operations.web.controller.bestpaycard;

import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.manager.interfaces.IBestpayCardManager;
import com.bestpay.ecurrency.operations.manager.model.BestpayCardInfoBO;
import com.bestpay.ecurrency.operations.web.model.BestpayCardInfoDTO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 翼支付卡信息查询
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
@Controller
@RequestMapping("/bestpaycard")
public class BestpayCardController {

    @Autowired
    private IBestpayCardManager bestpayCardManager;

    /**
     * 访问卡信息查询页面
     * @return
     */
    @RequestMapping(value = "/cardInfo.do",method = RequestMethod.GET)
    public String cardInfo(){
            return "bestpaycard/cardInfo";
    }


    /**
     * 查询翼支付卡信息
     * @param cardNo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryCardInfo.do",method = RequestMethod.POST)
    public Map<String,Object> queryCardInfo(String cardNo){
        Map<String,Object> resultMap = new HashMap<>();
        if(StringUtils.isBlank(cardNo)){
            throw new OperationsSystemException(OperationSystemErrorCode.CARDNO_CANNOT_EMPTY);
        }else{
            BestpayCardInfoBO bestpayCardInfoBO = bestpayCardManager.queryCardInfo(cardNo);
            resultMap.put("bestpayCardInfoDTO", BeanMapperUtil.objConvert(bestpayCardInfoBO,BestpayCardInfoDTO.class));
        }
        return resultMap;
    }




}

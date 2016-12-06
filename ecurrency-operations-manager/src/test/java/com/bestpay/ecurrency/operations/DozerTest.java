package com.bestpay.ecurrency.operations;

import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.dal.model.EoSymStaffDO;
import com.bestpay.ecurrency.operations.manager.model.StaffBO;
import org.junit.Assert;
import org.junit.Test;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/21 ProjectName: ecurrency-operations Version: 1.0
 */
public class DozerTest {

    /**
     * 测试对象转换是否是引用复制还是值复制
     * 结果为 值复制
     */
    @Test
    public void dozerTest(){
        EoSymStaffDO eoSymStaffDO = new EoSymStaffDO();
        eoSymStaffDO.setStaffId("jwxa");
        StaffBO staffBO = BeanMapperUtil.objConvert(eoSymStaffDO,StaffBO.class);
        Assert.assertEquals("jwxa",staffBO.getStaffId());
        staffBO.setStaffId("wangkechen");
        Assert.assertEquals("jwxa",eoSymStaffDO.getStaffId());
        Assert.assertEquals("wangkechen",staffBO.getStaffId());
    }

}

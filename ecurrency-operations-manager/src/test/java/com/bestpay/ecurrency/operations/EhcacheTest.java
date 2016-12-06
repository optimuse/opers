package com.bestpay.ecurrency.operations;

import com.bestpay.ecurrency.operations.dal.model.EoSymRoleDOExample;
import com.bestpay.ecurrency.operations.dal.model.EoSymSysparamDO;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymSysparamManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 缓存测试类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */
@Slf4j
public class EhcacheTest extends BaseSpringTest {

    @Autowired
    private ISymSysparamManager sysparamManager;

    /**
     * 测试多次查询是否使用缓存
     */
    @Test
    public void testCache(){
        long startTime = System.currentTimeMillis();
        List<EoSymSysparamDO> eoSymSysparamDOList = sysparamManager.queryAllSysparamList();
        log.info(eoSymSysparamDOList.toString());
        long endTime = System.currentTimeMillis();
        log.info("-----------------------------------------"+(endTime-startTime));
        List<EoSymSysparamDO> eoSymSysparamDOList2 = sysparamManager.queryAllSysparamList();
        log.info(eoSymSysparamDOList2.toString());
        long endTime2 = System.currentTimeMillis();
        log.info("-----------------------------------------"+(endTime2-endTime));
    }

    /**
     * 测试缓存刷新
     */
    @Test
    public void testCacheRefresh(){
        List<EoSymSysparamDO> eoSymSysparamDOList = sysparamManager.queryAllSysparamList();
        log.info("-----------------------------------------"+eoSymSysparamDOList.size());

        EoSymSysparamDO insertDO = new EoSymSysparamDO();
        insertDO.setParamCode("redis.mode");
        insertDO.setParamVal("standAlone");
        insertDO.setParamName("redis模式");
        insertDO.setParamDesc("单点模式");
        insertDO.setStat(EoSymRoleDOExample.Stat.S0A.name());
        int i = sysparamManager.insert(insertDO);
        Assert.assertEquals(i,1);


        List<EoSymSysparamDO> eoSymSysparamDOList1 = sysparamManager.queryAllSysparamList();
        log.info("-----------------------------------------"+eoSymSysparamDOList.size());
        Assert.assertEquals(eoSymSysparamDOList1.size(),eoSymSysparamDOList.size()+1);

    }

    @Test
    public void insertBaseInfo(){
        EoSymSysparamDO insertDO = new EoSymSysparamDO();
        insertDO.setParamCode("redis.mode");
        insertDO.setParamVal("standAlone");
        insertDO.setParamName("redis模式");
        insertDO.setParamDesc("单点模式");
        insertDO.setStat(EoSymRoleDOExample.Stat.S0A.name());
        sysparamManager.insert(insertDO);

        insertDO.setParamCode("redis.hostname");
        insertDO.setParamVal("127.0.0.1");
        insertDO.setParamName("redis主机地址");
        insertDO.setParamDesc("IP");
        sysparamManager.insert(insertDO);

        insertDO.setParamCode("redis.port");
        insertDO.setParamVal("6379");
        insertDO.setParamName("redis服务端口");
        insertDO.setParamDesc("端口号");
        sysparamManager.insert(insertDO);

    }





}

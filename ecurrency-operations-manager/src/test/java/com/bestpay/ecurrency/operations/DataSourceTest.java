package com.bestpay.ecurrency.operations;

import com.bestpay.ecurrency.operations.dal.config.DataSourceContextHolder;
import com.bestpay.ecurrency.operations.dal.consts.DbName;
import com.bestpay.ecurrency.operations.manager.interfaces.IStaffManager;
import com.bestpay.ecurrency.operations.manager.model.StaffBO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 多数据源测试类
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/30 ProjectName: ecurrency-operations Version: 1.0
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/application-context.xml"})
//@Transactional(transactionManager = "transactionManager")
public class DataSourceTest {

    @Autowired
    private IStaffManager staffManager;

    /**
     * 单线程
     * 多数据源切换，如果要使用事务 请在事务执行前进行切换！
     */
    @Test
    public void testTyvc(){
        StaffBO staffBO = new StaffBO();
        staffBO.setOffset(0);
        staffBO.setLimit(10);
        staffBO.setStaffId("admin");
        try {
            DataSourceContextHolder.setDataSource(DbName.TYVC);
            log.info("当前数据源：{}",DataSourceContextHolder.getDataSource());
            staffManager.queryStaffList(staffBO);
            Assert.fail();
        } catch (Exception e) {
            log.info("tyvc没有该表，应该报错");
            e.printStackTrace();
        }
        try {
            DataSourceContextHolder.setDataSource(DbName.PCPF);
            log.info("当前数据源：{}",DataSourceContextHolder.getDataSource());
            log.info("pcpf应该能够正常查询");
            List<StaffBO> staffBOList =  staffManager.queryStaffList(staffBO);
            Assert.assertEquals(1,staffBOList.size());
        } catch (Exception e) {
            Assert.fail();
        }
    }

    /**
     * 测试多数据源的分页
     */
    @Test
    public void testMultiDataSourcePager(){
        StaffBO staffBO = new StaffBO();
        staffBO.setOffset(0);
        staffBO.setLimit(10);
        staffBO.setStaffId("admin");

        DataSourceContextHolder.setDataSource(DbName.TYVC);
        log.info("当前数据源：{}",DataSourceContextHolder.getDataSource());
        List<StaffBO> staffBOList =   staffManager.queryStaffList(staffBO);
        System.out.println(staffBOList);

        DataSourceContextHolder.setDataSource(DbName.PCPF);
        log.info("当前数据源：{}",DataSourceContextHolder.getDataSource());
        staffBOList =  staffManager.queryStaffList(staffBO);
        System.out.println(staffBOList);
    }

}

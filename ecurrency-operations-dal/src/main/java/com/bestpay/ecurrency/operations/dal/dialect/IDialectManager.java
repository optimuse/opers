package com.bestpay.ecurrency.operations.dal.dialect;

/**
 * 数据库方言管理器接口
 * @author jwxa
 *
 */
public interface IDialectManager {

    /**
     * 获取方言对应处理类
     * @return 类名全称
     */
    String getClassName();

    /**
     * 设置数据库类型
     * @param dbType 数据库类型
     */
    void setDbType(String dbType);

    /**
     * 获取数据库类型
     * @return 数据库名称
     */
    String getDbType();
}

package com.bestpay.ecurrency.operations.common.cache.redis;

import java.util.List;

/**
 * redisManager
 * <p>
 *      1、查询redis 数据库
 *      2、插入redis 数据库
 *      3、插入redis 数据库,设置有效期
 *      4、删除redis 保存对象
 *      5、更新 redis
 *      6、查询redis 数据库
 *      7、查询redis 数据库
 * </p>
 * User: wen Date: 2015/08/016 ProjectName: ecurreccy-operations Version: 1.0
 */
public interface RedisManager {

    /**
     * 查询redis 数据库
     *
     * @param keyEnum 查询关键字
     * @param clazz   指定返回对象类型
     * @param <T>     返回对象类型,集合泛型
     * @return List<T>  返回对象集合
     */
    <T> List<T> queryListByKey(final String keyEnum, final Class<T> clazz);

    /**
     * 插入redis 数据库
     *
     * @param obj     保存对象
     * @param keyEnum 关键字
     * @return boolean  插入结果
     */
    boolean insertObject(Object obj, String keyEnum);

    /**
     * 插入redis 数据库,设置有效期
     *
     * @param obj     保存对象
     * @param keyEnum 关键字
     * @param timeout 有效期（毫秒）
     * @return boolean  插入结果
     */
    boolean insertObject(Object obj, String keyEnum, long timeout);

    /**
     * 删除redis 保存对象
     *
     * @param keyEnum 查询关键字
     * @return boolean  删除结果
     */
    boolean deleteObject(final String keyEnum);

}

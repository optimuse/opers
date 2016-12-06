package com.bestpay.ecurrency.operations.common.cache.redis.impl;

import com.alibaba.fastjson.JSONObject;
import com.bestpay.ecurrency.operations.common.cache.redis.RedisManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis实现
 * <p>
 *      1、查询redis 数据库
 *      2、插入redis 数据库
 *      3、插入redis 数据库,设置有效期
 *      4、删除redis 保存对象
 *      5、更新 redis
 *      6、查询redis 数据库
 * </p>
 * User: wen Date: 2015/08/016 ProjectName: ecurreccy-operations Version: 1.0
 */
@Slf4j
@Component
public class RedisManagerImpl implements RedisManager {

    @Autowired(required = false)
    private StringRedisTemplate redisTemplate;

    /**
     * 3、查询redis 数据库
     *
     * @param keyEnum 查询关键字
     * @param clazz   指定返回List内存放的对象类型
     * @param <T>     返回对象类型,集合泛型
     * @return List<T>      返回对象集合
     */
    public <T> List<T> queryListByKey(final String keyEnum, final Class<T> clazz) {
        log.debug("queryListByKey request:{}", keyEnum);

        String resultStr = queryObjectByKey(keyEnum);
        if (StringUtils.isBlank(resultStr)) {
            return null;
        }

        List<T> value = JSONObject.parseArray(resultStr, clazz);

        log.debug("queryListByKey response:{}", value.toString());
        return value;
    }

    /**
     * 4、插入redis 数据库
     *
     * @param obj     保存对象
     * @param keyEnum 关键字
     * @return 对象类型, 泛型
     */
    @Override
    public boolean insertObject(final Object obj, final String keyEnum) {
        return insertObject(obj, keyEnum, 0L);
    }

    /**
     * 5、插入redis 数据库,设置有效期
     *
     * @param obj     保存对象
     * @param keyEnum 关键字
     * @param timeout 有效期（毫秒）
     * @return 对象类型, 泛型
     */
    @Override
    public boolean insertObject(final Object obj, final String keyEnum, final long timeout) {
        log.debug("insertObject request:key={},obj={},timeout={}", keyEnum, obj.toString(), timeout);

        final String value = JSONObject.toJSONString(obj);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] redisKey = redisTemplate.getStringSerializer().serialize(keyEnum);
                byte[] redisValue = redisTemplate.getStringSerializer().serialize(value);
                connection.set(redisKey, redisValue);
                if (timeout > 0) {
                    redisTemplate.expire(keyEnum, timeout, TimeUnit.MICROSECONDS);
                }
                return true;
            }
        });

        log.debug("insertObject response：{}", result);
        return result;
    }

    /**
     * 8、查询redis 数据库
     *
     * @param keyEnum 查询关键字
     * @return String
     */
    public String queryObjectByKey(final String keyEnum) {
        log.debug("queryObjectByKey request:{}", keyEnum);

        String resultStr = (String) redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] redisKey = redisTemplate.getStringSerializer().serialize(keyEnum);
                if (connection.exists(redisKey)) {
                    byte[] value = connection.get(redisKey);
                    return redisTemplate.getStringSerializer().deserialize(value);
                }
                return null;
            }
        });

        log.debug("queryObjectByKey response:{}", resultStr);
        return resultStr;
    }

    /**
     * 10、删除redis 保存对象
     *
     * @param keyEnum 查询关键字
     * @return 删除结果
     */
    @Override
    public boolean deleteObject(final String keyEnum) {
        log.debug("deleteObject request:key={}", keyEnum);

        Long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] redisKey = redisTemplate.getStringSerializer().serialize(keyEnum);
                return connection.del(redisKey);
            }
        });

        log.debug("deleteObject response：{}", result);
        return result > 0;
    }

}

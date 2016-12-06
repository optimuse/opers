package com.bestpay.ecurrency.operations.web.session;

import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.manager.interfaces.IPropertiesManager;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymSysparamManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */
@Configuration
public class SessionConfig {

    @Autowired
    private IPropertiesManager propertiesManager;

    private static final String REDIS_KEY_PREFIX = "redis.";
    private static final String REDIS_MODE_KEY = "redis.mode";
    /**
     * 单点模式,哨兵模式
     */
    private static final String[] REDIS_MODE = new String[]{"standalone", "sentinels"};

    private static final String REDIS_HOSTNAME = "redis.host";
    private static final String REDIS_PORT = "redis.port";
    private static final String REDIS_MASTER = "redis.master";
    private static final String REDIS_PASSWORD = "redis.password";
    /**
     * Jedis连接池配置
     */
    private static final String REDIS_MINIDLE = "redis.minIdle";
    private static final String REDIS_MAXIDLE = "redis.maxIdle";
    private static final String REDIS_MAXTOTAL = "redis.maxTotal";
    private static final String REDIS_TESTONBORROW = "redis.testOnBorrow";

    @Bean(name = "jedisConnFactory")
    public JedisConnectionFactory connectionFactory() {
        Map<String, String> redisConfigMap = propertiesManager.querySysparamMapByParmCodePrefix(REDIS_KEY_PREFIX);

        String redisMode = redisConfigMap.get(REDIS_MODE_KEY);
        if (redisMode.equalsIgnoreCase(REDIS_MODE[0])) {
            //单点模式
            return initHttpSessionFactory(redisConfigMap);
        } else if (redisMode.equalsIgnoreCase(REDIS_MODE[1])) {
            //哨兵模式
            return initSentinelFactory(redisConfigMap);
        } else {
            throw new OperationsSystemException(OperationSystemErrorCode.SYSTEM_ERROR);
        }
    }


    public JedisConnectionFactory initHttpSessionFactory(Map<String, String> redisConfigMap) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(redisConfigMap.get(REDIS_HOSTNAME));
        jedisConnectionFactory.setPort(Integer.parseInt(redisConfigMap.get(REDIS_PORT)));
        String pwd = redisConfigMap.get(REDIS_PASSWORD);
        if (StringUtils.isNotBlank(pwd)) {
            jedisConnectionFactory.setPassword(pwd);
        }
        return jedisConnectionFactory;
    }


    public JedisConnectionFactory initSentinelFactory(Map<String, String> redisConfigMap) {
        RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
        redisSentinelConfiguration.setMaster(redisConfigMap.get(REDIS_MASTER));
        Set<RedisNode> sentinels = new HashSet<>();
        String[] sentinelsHostArray = redisConfigMap.get(REDIS_HOSTNAME).split(",");
        String[] sentinelsPortArray = redisConfigMap.get(REDIS_PORT).split(",");
        for (int i=0;i<sentinelsHostArray.length;i++) {
            String host = sentinelsHostArray[i];
            int port = Integer.parseInt(sentinelsPortArray[i]);
            RedisNode node = new RedisNode(host, port);
            sentinels.add(node);
        }
        redisSentinelConfiguration.setSentinels(sentinels);
        //Jedis 连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(Integer.parseInt(redisConfigMap.get(REDIS_MINIDLE)));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(redisConfigMap.get(REDIS_MAXIDLE)));
        jedisPoolConfig.setMaxTotal(Integer.parseInt(redisConfigMap.get(REDIS_MAXTOTAL)));
        jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(redisConfigMap.get(REDIS_TESTONBORROW)));

        return new JedisConnectionFactory(redisSentinelConfiguration, jedisPoolConfig);
    }


}

package com.bestpay.ecurrency.operations.dal.dialect;

import com.bestpay.ecurrency.operations.dal.consts.DbType;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 默认的数据库方言管理器实现类，对数据库方言对象进行管理。
 * @author jwxa
 *
 */
public class DefaultDialectManager implements IDialectManager {

	private Map<String, String> dialects;

    public static final ThreadLocal<String> contextHolder =  new ThreadLocal<String>();

    public String getDbType() {
        return contextHolder.get();
    }

    public void setDbType(String dbType) {
        contextHolder.set (dbType);
    }

    public String getClassName(){
        String dbType = contextHolder.get();
        if(StringUtils.isBlank(dbType)){
            dbType = DbType.MYSQL.toString();
        }
        return dialects.get(dbType);
    }

    /**
	 * 方言Map key 数据库类型 value 类全名
	 * 由spring配置注入 spring-dataservice.xml
	 */
	public void setDialects(Map<String, String> dialects) {
		this.dialects = dialects;
	}

}

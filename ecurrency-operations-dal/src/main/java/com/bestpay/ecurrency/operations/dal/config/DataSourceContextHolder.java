package com.bestpay.ecurrency.operations.dal.config;


import com.bestpay.ecurrency.operations.dal.consts.DbName;

/**
 * DataSource上下文句柄，通过此类设置需要访问的对应数据源
 * 
 * @author 黄军
 *
 *         2013-6-24 下午12:50:17
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
	public class DataSourceContextHolder {
	/**
	 * DataSource上下文，每个线程对应相应的数据源key
	 */
	public static final ThreadLocal contextHolder = new ThreadLocal();

	public static void setDataSource(DbName dbName) {
		contextHolder.set(dbName.toString());
	}

	public static String getDataSource() {
		return (String) contextHolder.get();
	}

	public static void clearDataSource() {
		contextHolder.remove();
	}
}

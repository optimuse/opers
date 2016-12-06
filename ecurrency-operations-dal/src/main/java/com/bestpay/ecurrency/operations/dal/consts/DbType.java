package com.bestpay.ecurrency.operations.dal.consts;

/**
 * 公共数据源 User: XW <br/>
 * Date: 14-9-12 下午2:57 <br/>
 */
public enum DbType {
	MYSQL("mysql"),
    DB2("db2"),
    ORACLE("oracle"),
    SQLSERVER2005("sqlServer2005"),
    SQLSERVER("sqlServer")
    ;

	private String name;

	DbType(String val) {
		this.name = val;
	}

	@Override
	public String toString() {
		return this.name;
	}

}

package com.bestpay.ecurrency.operations.dal.model;

/**
 * common return
 * @author xuxueli 2015-12-4 16:32:31
 * @param <T>
 */
public class ReturnTDO<T> {
	public static final ReturnTDO<String> SUCCESS = new ReturnTDO<String>(null);
	public static final ReturnTDO<String> FAIL = new ReturnTDO<String>(500, null);
	
	private int code;
	private String msg;
	private T content;
	
	public ReturnTDO(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ReturnTDO(T content) {
		this.code = 200;
		this.content = content;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "ReturnTDO [code=" + code + ", msg=" + msg + ", content="
				+ content + "]";
	}

}

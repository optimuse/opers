package com.bestpay.ecurrency.operations.common.util;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties pro;

	public static Properties getProperties() {
		if (pro == null) {
			try {
				InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("properties/operations.properties");
				Properties p = new Properties();
				p.load(in);
				pro = p;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pro;
	}

	public static String getProper(String key) {
		Properties pro = PropertiesUtil.getProperties();
		String valSt = pro.get(key) == null ? null : pro.get(key) + "";
		return valSt;
	}

	public static void main(String[] args) {
//		System.out.println(PropertiesUtil.getProper("password"));
	}

}

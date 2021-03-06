package com.bestpay.ecurrency.operations.manager.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

/**
 * properties util
 * @author xuxueli 2015-8-28 10:35:53
 */
@Slf4j
public class PropertiesUtil {
	private static final String file_name = "config.properties";
	
	/**
	 * load properties
	 * @param propertyFileName
	 * @param
	 * @return
	 */
	public static Properties loadProperties(String propertyFileName) {
		Properties prop = new Properties();
		InputStreamReader  in = null;
		try {
			URL url = null;
			ClassLoader loder = Thread.currentThread().getContextClassLoader();
			url = loder.getResource(propertyFileName); 
			in = new InputStreamReader(new FileInputStream(url.getPath()), "UTF-8");
			prop.load(in);
		} catch (IOException e) {
			log.error("load {} error!", propertyFileName);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("close {} error!", propertyFileName);
				}
			}
		}
		return prop;
	}

	public static String getString(String key) {
		Properties prop = loadProperties(file_name);
		if (prop!=null) {
			return prop.getProperty(key);
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getString("triggerLogUrl"));
	}

}

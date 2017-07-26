package com.gs.config;

import java.io.IOException;
import java.util.Properties;

/**
 * 
 * ��ȡ�����ļ��Ĺ�����
 *
 */
public class ConfigUtil {

	private Properties prop;
	
	public ConfigUtil() {
		
	}
	
	public ConfigUtil(String path) {
		prop = new Properties(); // Properites������JDK�ṩר�����ڴ���.properties�ļ�����
		try {
			prop.load(ConfigUtil.class.getResourceAsStream(path)); // ��ȡ�����ļ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getString(String key) {
		return prop.getProperty(key);
	}
	
	public int getInt(String key) {
		return prop.getProperty(key) == null ? 0 : Integer.valueOf(prop.getProperty(key)); // getProperites(String key)ͨ�������ļ��е�key����ȡ���Ӧ��ֵ������ֵ ��String����
	}
	
	public double getDouble(String key) {
		return prop.getProperty(key) == null ? 0 : Double.valueOf(prop.getProperty(key));
	}
	 
}

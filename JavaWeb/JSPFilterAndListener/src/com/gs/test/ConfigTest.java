package com.gs.test;

import org.junit.Test;

import com.gs.common.Config;

public class ConfigTest {
	
	@Test
	public void testConfig() {
		// �����/���أ����ʾ��src·����ʼ�����������/���أ����ʾ��Config�����ڵİ�Ϊ��·��
		Config config = new Config("/config/config.properties"); 
		System.out.println(config.getString("max_file_size"));
	}

}

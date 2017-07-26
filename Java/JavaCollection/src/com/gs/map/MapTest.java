package com.gs.map;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	
	public static void main(String[] args) {
		Hashtable<String, String> map = new Hashtable<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value1"); // ��Ԫ����ӵ�Map�У�ÿ��Ԫ�ؿ���ͨ��ָ���ļ��ҵ�
		
		System.out.println(map.get("key3")); // get(Object key)����ָ���ļ��ҵ����Ӧ��ֵ
		map.remove("key3");
		if (map.containsKey("key3")) { // �ж��Ƿ������ĳ����
			System.out.println(map.get("key3")); // ���ݼ�remove�����ٴλ�ȡ���Ѿ��������ˣ����Է���Ϊnull
		}
		if (map.containsValue("value1")) { // �ж��Ƿ������ĳ��ֵ
			System.out.println("��value1ֵ");
		}
		// �Ȼ�ȡÿһ����Ŀ����set�еĶ���
		Set<Entry<String, String>> entrySet = map.entrySet(); // Entry��ָһ����ֵ�ԣ���ʾһ����Ŀ
		// �Դ洢��������Ŀ��Set���ϻ�ȡ������
		Iterator<Entry<String, String>> ite = entrySet.iterator();
		while (ite.hasNext()) {
			Entry<String, String> entry = ite.next(); // �˵������е�ÿһ����Ŀ����һ����Ŀ������Ŀ������key��key����Ӧ��value
			System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue()); // ʹ��Entry��Ŀ���getKey()��ȡ����Ŀ�ļ���getValue()��ȡ����Ŀ��ֵ
		}
	}

}

package com.gs.exercise;

public class Student {
	
	String name;
	int age;
	float score;
	
	public int parseInt(String str) {
		return Integer.valueOf(str);
	}
	
	public float parseFloat(String str) {
		return Float.valueOf(str);
	}
	
	/**
	 * ���һ���಻����ʵ��toString����������System.out.println����д�ӡ�����������
	 * ����ļ�����+@+hashcode(��ϣ��)
	 * 
	 * �����Ҫ���������ص�һЩ����ֵ��������Ϣ��������ʵ��toString����
	 */
	public String toString() {
		return "name: " + name + ", age: " + age + ", score: " + score;
	}

}

package com.gs.exercise;

public class MyClass {
	
	String name;
	static int a;
	
	public void test() {
		test1(); // ʵ���������Ե����෽��
		name = "name";
		a = 10; // ʵ���������Ե��������
	}
	
	public static void test1() {
		// test(); // �෽�����ɵ���ʵ������
		// name = "name"; // �෽�������Ե���ʵ������
		a = 10;
	}

}

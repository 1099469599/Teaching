package com.gs.four;

public class Teacher extends Person {

	// @Override ��ʾ�÷�������д�ķ���
	@Override
	public void sleep() {
		System.out.println("Teacher sleep()");
	}
	
	@Override
	public void read() {
		System.out.println("Teacher read()");
	}

}

package com.gs.two;

public class Person1 {

	String name;
	int age;
	
	/**
	 * ��̬������
	 */
	static {
		System.out.println("Person1 static������");
	}
	
	/**
	 * ��̬������
	 */
	{
		System.out.println("Person1 ��̬������");
	}
	
	public Person1() {
		System.out.println("Person1()");
	}
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void read() {
		System.out.println("Person1 read()");
	}
	
	public void run() {
		
	}
	
}

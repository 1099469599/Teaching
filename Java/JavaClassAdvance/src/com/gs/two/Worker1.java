package com.gs.two;

public class Worker1 extends Person1 {

	private String company; // ��˾
	double salary; // н��
	
	static {
		System.out.println("Worker1 static������");
	}
	
	{
		System.out.println("Worker1 ��̬������");
	}
	
	public Worker1() {
		System.out.println("Worker1()");
	}
	
	public Worker1(String name, int age, String company, double salary) {
		// super�ؼ��֣�������ʾ������� super();��ʾ����Ĺ��췽��
		// ʹ��super���ø���Ĺ��췽�������������ǰ��
		super(name, age); // �����౾���name��age��ֵ
		System.out.println("Worker1(String, int, String, double)");
		this.company = company;
		this.salary = salary;
		// super.age = 10; // �����౾��ֵ�������Ǹ���
		System.out.println("");
		super.read(); // ��super�����ó�Ա����������õĸ���ķ���
		read();
	}
	
	public void work() {
		
	}
	
	public void read() {
		System.out.println("worker1 read()");
	}
	/**
	 * ��������д�����еķ��������෽���ķ���Ȩ�޲���С�ڸ����з�������ķ���Ȩ��
	protected void run() {
		
	}
	*/
	
}

package com.gs.two;

public class PersonTest1 {
	
	public static void main(String[] args) {
		Person1 person = new Person1();
		person.age = 20;
		System.out.println(person.age);
		Worker1 worker = new Worker1("worker1", 15, "ABC", 3000); // ���๹�췽��ǰ��ִ�и���Ĺ��췽��
		System.out.println(person.age);
		worker.read(); // Worker1��д��Person1�����е�read()���� ����worker�������read����ʱ��ʹ����������д�ķ���
	}

}

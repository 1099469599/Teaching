package com.gs.four;

public class PersonTest {
	public static void main(String[] args) {
		Student stu = new Student(); // Ҳ����ֱ����Person�������������
		stu.sleep();
		stu.read();
		stu.run();
		
		Person teacher = new Teacher();
		teacher.sleep();
		teacher.read();
	}
}

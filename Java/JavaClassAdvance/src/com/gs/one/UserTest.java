package com.gs.one;

public class UserTest {

	public static void main(String[] args) {
		User user = new User("AAAA", 20, 170, 100);
		System.out.println(user.getName()); // ����ȥ����user�����private��Ա������������User���ṩget[��������]()
		System.out.println(user.getAge());
		user.setName("BBBB");
		System.out.println(user.getName());
	}

}

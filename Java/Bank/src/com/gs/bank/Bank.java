package com.gs.bank;

import java.util.Scanner;

public class Bank {
	
	BankAccount1 acc; // ����BankAccount1����
	
	Scanner scanner = new Scanner(System.in);
	
	public void openAccount() {
		System.out.println("�û���");
		String name = scanner.next();
		System.out.println("����");
		String password = scanner.next();
		acc = new BankAccount1(name, password); // ʵ����acc����
		System.out.println("�˺ţ�" + acc.number);
	}
	
	public boolean check() {
		System.out.println("�˺�");
		int number = scanner.nextInt();
		System.out.println("����");
		String pwd = scanner.next();
		if (acc.number == number && pwd.equals(acc.password)) {
			return true;
		}
		System.out.println("�˺Ż���������������");
		return false;
	}
	
	public void save() {
		if (check()) {
			System.out.println("�������");
			acc.money += scanner.nextDouble();
			System.out.println(acc);
		}
	}
	
	public void get() {
		if (check()) {
			System.out.println("ȡ����");
			acc.money -= scanner.nextDouble();
		}
	}
	
	public void query() {
		if (check()) {
			System.out.println(acc);
		}
	}
	
	public void transfer() {
		if (check()) {
			// TODO
		}
	}
	
	public void exit() {
		scanner.close();
		System.exit(-1);
	}
	
}

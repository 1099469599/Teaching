package com.gs.bank;

import java.util.Random;
import java.util.Scanner;

public class BankAccount {
	
	String name; // �˺�����
	int number; // �˺�
	String password; // �˺�����
	double money; //���˺����
	
	Scanner scanner = new Scanner(System.in);
	
	public void openAccount() {
		System.out.println("�û���");
		this.name = scanner.next();
		System.out.println("����");
		String pwd1 = scanner.next();
		System.out.println("ȷ������");
		String pwd2 = scanner.next();
		if (pwd1.equals(pwd2)) { // ������String�ַ����������ݱȽ�
			this.password = pwd1;
			Random random = new Random(); // java.util.Random �������������
			this.number = random.nextInt(50000); // random.nextInt()ָ������һ������������� nextInt(50000)��ʾ��0-50000�����������
			System.out.println("�ɹ��������˺ţ�" + this.number);
		} else {
			System.out.println("����ʧ�ܣ��������벻һ��");
		}
	}
	
	public boolean check() {
		System.out.println("�����˺�");
		int number = scanner.nextInt();
		System.out.println("��������");
		String pwd = scanner.next();
		if (number == this.number && pwd.equals(this.password)) {
			return true;
		}
		System.out.println("�˺Ż���������������");
		return false;
	}
	
	public void save() {
		if (check()) {
			System.out.println("�������");
			this.money += scanner.nextDouble();
			System.out.println(this);
		} 
	}
	
	public void get() {
		if (check()) {
			System.out.println("ȡ������ ");
			double money = scanner.nextDouble();
			if (money > this.money) {
				System.out.println("���̲���");
			} else {
				this.money -= money;
				System.out.println("ȡ��ɹ�");
				System.out.println(this);
			}
		}
	}
	
	public void query() {
		if (check()) {
			System.out.println(this);
		}
	}
	
	public void transfer() {
		if (check()) {
			// TODO �Ժ���ʵ��
		}
	}
	
	public void exit() {
		scanner.close(); 
		System.exit(-1); // System.exit(int status) // �رյ�ǰӦ�ó���
	}
	
	public String toString() {
		return "�˺�����" + name + ", �˺ţ� " + number + ", �� " + money;
	}
	
	public static void main(String[] args) {
		BankAccount acc = new BankAccount();
		int choice = 0;
		do {
			System.out.println("Welcome to my Bank");
			System.out.println("1������\t2�����\t3��ȡ��\t4����ѯ\t5��ת��\t6���˳�");
			choice = acc.scanner.nextInt();
			switch (choice) {
			case 1:
				acc.openAccount();
				break;
			case 2:
				acc.save();
				break;
			case 3:
				acc.get();
				break;
			case 4:
				acc.query();
				break;
			case 5:
				acc.transfer();
				break;
			case 6:
				acc.exit();
				break;
			default:
				break;
			}
		} while (choice != 6);
	}
}

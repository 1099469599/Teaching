package com.gs.bank;

public class BankTest {
	
	public static void main(String[] args) {
		Bank bank = new Bank(); // ʵ����Bank���󣬲���Bank���еķ���
		int choice = 0;
		do {
			System.out.println("Welcome to my Bank");
			System.out.println("1������\t2�����\t3��ȡ��\t4����ѯ\t5��ת��\t6���˳�");
			choice = bank.scanner.nextInt();
			switch (choice) {
			case 1:
				bank.openAccount();
				break;
			case 2:
				bank.save();
				break;
			case 3:
				bank.get();
				break;
			case 4:
				bank.query();
				break;
			case 5:
				bank.transfer();
				break;
			case 6:
				bank.exit();
				break;
			default:
				break;
			}
		} while (choice != 6);
	}

}

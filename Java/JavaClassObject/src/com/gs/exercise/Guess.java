package com.gs.exercise;

import java.util.Scanner;

public class Guess {

	String name;
	int age;

	public Guess() {

	}

	public Guess(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void guess() {
		Scanner scanner = new Scanner(System.in);
		boolean flag = false; // ���û�в¶�
		do {
			System.out.println("����������");
			String name = scanner.next();
			System.out.println("����������");
			int age = scanner.nextInt();
			if (age == this.age && name.equals(this.name)) {
				flag = true;
				System.out.println("���ˣ�");
			} else {
				System.out.println("���ˣ�");
			}
		} while (!flag);
		scanner.close();
	}

	public static void main(String[] args) {
		Guess guess = new Guess("AA", 20);
		guess.guess();
	}

}

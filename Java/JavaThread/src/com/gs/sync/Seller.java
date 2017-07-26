package com.gs.sync;

public class Seller extends Thread {

	private static int total = 100;
	
	public Seller(String name) {
		super(name);
	}

	@Override
	public void run() {
		sell();
	}
	
	private void sell() {
		while (total > 0) {
			System.out.println(getName() + "���۳�һ��Ʊ��Ʊ�ţ�" + total);
			total -= 1; // ��seller1δִ�д��д���ǰseller2�Ϳ��ܽ�����run�����������Ѿ���ǰһ�������
			System.out.println(getName() + "��ʣ�࿪ʼƱ�ţ�" + total);
		}
	}
	
	public static void main(String[] args) {
		Seller seller1 = new Seller("seller1");
		seller1.start();
		Seller seller2 = new Seller("seller2");
		seller2.start();
		Seller seller3 = new Seller("seller3");
		seller3.start();
		Seller seller4 = new Seller("seller4");
		seller4.start();
	}

}

package com.gs.sync;

public class SellerSync implements Runnable {

	private int total = 100;
	
	@Override
	public void run() {
		while (true) {
			sell();
		}
	}
	
	private synchronized void sell() {
		if (total > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Thread.currentThread()��ȡ��ǰ����ִ�е��߳�
			System.out.println(Thread.currentThread().getName() + "�۳�һ��Ʊ��Ʊ�ţ�" + total);
			total -= 1;
			System.out.println(Thread.currentThread().getName() + "ʣ�࿪ʼƱ�ţ�" + total);
		}
	}
	
	public static void main(String[] args) {
		SellerSync seller = new SellerSync();
		Thread seller1 = new Thread(seller, "seller1");
		seller1.start();
		Thread seller2 = new Thread(seller, "seller2");
		seller2.start();
		Thread seller3 = new Thread(seller, "seller3");
		seller3.start();
		Thread seller4 = new Thread(seller, "seller4");
		seller4.start();
	}

}

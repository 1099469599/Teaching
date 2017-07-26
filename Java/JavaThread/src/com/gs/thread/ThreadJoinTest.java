package com.gs.thread;

public class ThreadJoinTest {
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new ThreadJoin1());
		Thread thread2 = new Thread(new ThreadJoin2());
		thread1.start();
		try {
			thread1.join(); // �ȴ�thread1�߳�ִ����ϣ���thread1ִ����Ϻ������߳���ִ��
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start(); // �����̵߳���������join��
	}

}

class ThreadJoin1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("aaaaaaa");
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class ThreadJoin2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			System.out.println("bbbbbbb");
			try {
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

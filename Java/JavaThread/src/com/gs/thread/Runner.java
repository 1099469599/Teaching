package com.gs.thread;

public class Runner implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("�����ܵ�" + (i + 1) + "Ȧ");
			try {
				Thread.sleep(2 * 1000); // ���߳�����2000ms����λΪms
			} catch (InterruptedException e) { // java.lang.InterruptedException�� �߳��ж��쳣
				e.printStackTrace();
			} 
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Runner()).start();
	}

}

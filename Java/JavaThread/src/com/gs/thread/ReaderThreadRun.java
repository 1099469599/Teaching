package com.gs.thread;

public class ReaderThreadRun implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("reader1�ڶ���...");
		}
	}
	
	public static void main(String[] args) {
		ReaderThreadRun rtr = new ReaderThreadRun();
		Thread rtrThread = new Thread(rtr, "reader1"); // ʹ��Thread��������ʵ����Runnable�ӿڵ��߳���
		rtrThread.start();
		Reader2ThreadRun rtr2 = new Reader2ThreadRun();
		Thread rtr2Thread = new Thread(rtr2, "reader2");
		rtr2Thread.start();
	}

}

class Reader2ThreadRun implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println("reader2�ڶ���...");
		}
	}
	
}

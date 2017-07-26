package com.gs.thread;

public class ReaderThread extends Thread {
	
	
	
	public ReaderThread() {
		super();
	}

	public ReaderThread(String name) {
		super(name);
	}

	// ��дrun�������߳����ܵĴ��붼�ڴ�run������
	@Override
	public void run() {
		while (true) {
			System.out.println(this.getName());
			System.out.println("read1�ڶ���...");
		}
	}
	
	public static void main(String[] args) {
		ReaderThread rt = new ReaderThread("reader1");
		Reader2Thread rt2 = new Reader2Thread();
		rt.start(); // �����߳�
		rt2.start();
	}

}

class Reader2Thread extends Thread {
	
	@Override
	public void run() {
		while (true) {
			System.out.println("reader2�ڶ���...");
		}
	}
	
}

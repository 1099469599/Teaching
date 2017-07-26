package com.gs.thread;

import java.io.IOException;

public class ThreadSleepTest {

	public static void main(String[] args) throws IOException {
		try {
			Thread.sleep(2 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread thread1 = new Thread(new ThreadSleep1());
		//thread1.start();
		//thread1.interrupt(); // thread1�߳�������һ�飬���Ž���������״̬�����ŵ���interruptʹ�߳��жϣ�������״̬�ı�Ϊ������״̬��Ҳ��������̬�������߳��ٴ�����ִ��
		
		Thread thread2 = new Thread(new ThreadSleep2());
		thread2.start();
		
		System.in.read();
		thread2.interrupt(); // ���������ߵ�thread2
	}
}

class ThreadSleep1 implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("thread1 running...");
				Thread.sleep(5 * 1000 * 60);
			} catch (InterruptedException e) {
				System.out.println("�̱߳��ж�"); // ֻ���̱߳��жϣ��ŻᲶ׽��InterruptedException
			}
		}
	}
	
}

class ThreadSleep2 implements Runnable {

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("thread2 running....");
				Thread.yield(); // ��ǰ�߳�Ӧ����ִͣ�У���ȷ����ͣ�೤ʱ�䣬һ��cpu�ǿ��еģ����߳̾ͻ����»�ȡcpuʱ�䣩����cpuʱ���ø������߳�
				Thread.sleep(5 * 1000);
			} catch (InterruptedException e) {
				System.out.println("�̱߳��ж�");
			}
		}
	}
	
}

package com.gs.thread;

public class Reader {
	
	public static void reader1() {
		while (true) {
			System.out.println("reader1�ڶ���....");
		}
	}
	
	public static void reader2() {
		while (true) {
			System.out.println("reader2�ڶ���....");
		}
	}
	
	public static void main(String[] args) {
		reader1(); // ����reader1һֱ�ڶ��飬��reader2����û�л����ȡcpuʱ�䣬����reader2��Զ�����ܽ��뵽���鷽����������Ҫ�����߳������
		reader2();
	}

}

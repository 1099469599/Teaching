package com.gs.advice;

public class LoginActionAdvice {
	
	public void beforeExecute() {
		System.out.println("before");
	}
	
	public void afterExecute() {
		System.out.println("��¼�ɹ�����¼��Ϣ�����ݿ�");
	}
	
	public void throwExecute() {
		System.out.println("�������쳣");
	}

}

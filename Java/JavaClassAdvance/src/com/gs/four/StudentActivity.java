package com.gs.four;

public class StudentActivity implements Activity, Driver {

	@Override
	public void sing() {
		System.out.println("student sing....");
	}

	@Override
	public void dance() {
		System.out.println("student dance...");
	}
	
	@Override
	public void drive() {
		System.out.println("δ��18����Ŀ����˳�...");
	}

}

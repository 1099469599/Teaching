package com.gs.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TestAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		// miʵ��������spring�Ķ�̬���������ɵ�һ������������������������TestServiceImpl��test����
		System.out.println("��ã�ִ��ǰ");
		Object obj = mi.proceed(); // TestServiceImpl�Ķ���ȥִ��test����
		System.out.println("ִ�к�");
		return obj;
	}

}

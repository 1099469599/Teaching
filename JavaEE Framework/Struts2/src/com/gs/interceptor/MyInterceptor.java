package com.gs.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends  AbstractInterceptor {

	private static final long serialVersionUID = 4280873003624264212L;

	@Override
	public void destroy() {
		System.out.println("����������");
	}

	@Override
	public void init() {
		System.out.println("���������ڳ�ʼ��"); // WEB���ڳ�ʼ������strutsʱ���г�ʼ��
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ActionInvocation������ִ��Action����ķ�����һ������
		Map<String, Object> map = invocation.getInvocationContext().getParameters();
		System.out.println(((String[])map.get("name"))[0]);
		System.out.println("MyInterceptor...");
		return invocation.invoke();
		
	}

}

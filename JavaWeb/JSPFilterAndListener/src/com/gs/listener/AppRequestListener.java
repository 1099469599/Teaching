package com.gs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class AppRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("��������....");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("�����ʼ��....");
		arg0.getServletRequest();
	}

}

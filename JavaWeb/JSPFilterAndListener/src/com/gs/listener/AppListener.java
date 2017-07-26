package com.gs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.gs.common.Config;

public class AppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Ӧ�ó�������....");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Ӧ�ó����ʼ��....");
		Config config = new Config("/config/config.properties");
		int maxFileSize = config.getInt("max_file_size");
		ServletContext sc = arg0.getServletContext();
		sc.setAttribute("max_file_size", maxFileSize);
	}

}

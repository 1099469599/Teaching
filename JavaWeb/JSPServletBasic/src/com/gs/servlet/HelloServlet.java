package com.gs.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �Զ����Servlet��̳���javax.serlvet.http.HttpServlet��
 */
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = -470818723804064268L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("HelloServlet��ʼ��.....");
	}
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet������.....");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("HelloServlet���ڴ���...hello!");
	}
	
	
}

package com.gs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceServlet extends HttpServlet {

	private static final long serialVersionUID = -2093995948416680583L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // ����HttpServletRequest����ı��뷽ʽΪutf-8����jspҳ���еı��뱣��һ��
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8"); // response���ص����ݵ�������ʲô
		
		System.out.println(req.getMethod()); // ��ȡ���󷽷�
		String name = req.getParameter("name");
		System.out.println(name);
		
		PrintWriter out = res.getWriter(); // ��HttpServletResponse�����ȡһ������������������������ݿ��Է��ص��ͻ���
		out.print("<!doctype html>"); // ͨ��out���������������ͻ��� 
		out.print("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<div style='color:white;background-color:black;'>");
		out.print(name);
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}

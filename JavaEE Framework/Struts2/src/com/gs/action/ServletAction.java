package com.gs.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServletAction extends ActionSupport {

	private static final long serialVersionUID = 6106254646911857857L;
	
	@SuppressWarnings("unused")
	public String execute() {
		
		ActionContext actionContext = ActionContext.getContext();
		actionContext.getParameters(); // ��ȡ���е��������������Map
		actionContext.getApplication(); // ��ȡApplication�� ServletContext   ����Map
		actionContext.getSession(); // ��ȡsession�ڵļ�ֵ����Ϣ   ����Map
		actionContext.put("aaa", "aaa"); // �����ݴ洢��action������
		actionContext.get("aaa"); // ��action��������ȥ��ȡ����
		
		HttpServletRequest req = ServletActionContext.getRequest();
		HttpSession session = req.getSession();
		HttpServletResponse resp = ServletActionContext.getResponse();
		ServletContext app = ServletActionContext.getServletContext();
		PageContext pc = ServletActionContext.getPageContext();
		ActionContext ac = ServletActionContext.getActionContext(req);
		
		return SUCCESS;
	}

}

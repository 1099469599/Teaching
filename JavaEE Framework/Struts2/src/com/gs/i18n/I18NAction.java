package com.gs.i18n;

import com.opensymphony.xwork2.ActionSupport;

public class I18NAction extends ActionSupport {
	
	private static final long serialVersionUID = -6273088310620080686L;

	public String showPage() {
		System.out.println(getText("test")); // ������Action����ͨ��getText�ķ���ȥ��ȡ���ʻ��ļ������õ�����
		return "show_page";
	}

}

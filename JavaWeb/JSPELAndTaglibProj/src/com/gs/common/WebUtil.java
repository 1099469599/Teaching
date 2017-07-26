package com.gs.common;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	public static String getUriMethod(HttpServletRequest req) {
		String uri = req.getRequestURI(); // ��������ѯ�ַ�������
		return uri.substring(uri.lastIndexOf("/") + 1);
	}
	
	public static String getUriMethod(HttpServletRequest req, int index) {
		String uri = req.getRequestURI(); // ��������ѯ�ַ�������
		// /pager?pageNo=1
		// /pager/1  ==   ��ȡ�ĸ�/�����ֵ 
		if (index == 1) {
			return uri.substring(uri.lastIndexOf("/") + 1);
		} else if (index == 2){
			String newUri = uri.substring(0, uri.lastIndexOf("/")); // /pager
			return newUri.substring(newUri.lastIndexOf("/") + 1);
		} else {
			return uri;
		}
	}

}

package com.gs.common;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	public static final String DEFAULT_UPLOADS = "uploads";
	
	public static String getUriMethod(HttpServletRequest req) {
		String uri = req.getRequestURI(); // ��������ѯ�ַ�������
		return uri.substring(uri.lastIndexOf("/") + 1);
	}
	
	/**
	 * �˷���ȥ��ȡ��վ�ڷ������˵���ʵ·���ĸ�·��
	 * 
	 * getRealPath(String); ��ʾȥ��ȡ��վĳ����Դ����ʵ·��
	 * getRealPath("/");��ʾ��ȡ��վ��·������ʵ·��
	 * @param req
	 */
	public static String mkUpload(HttpServletRequest req) {
		String path = req.getServletContext().getRealPath("/");
		File file = new File(path, DEFAULT_UPLOADS);
		if (!file.exists()) {
			file.mkdir();
		}
		return file.getAbsolutePath();
	}

}

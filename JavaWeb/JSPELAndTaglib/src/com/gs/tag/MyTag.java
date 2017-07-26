package com.gs.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport {
	
	private static final long serialVersionUID = -6030518045492522638L;
	
	private PageContext pageContext;
	
	/**
	 * ��web�������õ�һ���������Ѵ��ݹ�����pageContext���󱣴浽���ǵ�PageContext������
	 * @param pageContext
	 */
	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.write("My Tag");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
	

}

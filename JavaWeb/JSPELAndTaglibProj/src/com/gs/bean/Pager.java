package com.gs.bean;

import java.util.List;

public class Pager<T> {
	
	private int pageNo; // �ڼ�ҳ
	private int pageSize; // ÿһҳ��ʾ���ٸ�
	private int total; // �ܼ�¼��
	private List<T> result; // ��ҳ��ѯ���Ľ��
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	
}

package com.gs.qq.ui.common;

import java.util.List;
import java.util.Vector;

import com.gs.bean.Account;

public class List2TableVector {
	
	/**
	 * �������˻�ת����JTable�е�ÿһ��
	 * @param accounts
	 * @return
	 */
	public Vector<Vector<String>> toVector(List<Account> accounts) {
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		for (Account a : accounts) {
			Vector<String> rowData = new Vector<String>(); // һ��account��ӦJTable�е�һ��
			rowData.add(a.getNumber()); // ��ÿһ���ֶ���ӵ�vector��
			rowData.add(a.getNickname());
			data.add(rowData); // ��ÿһ����ӵ�Vector��
		}
		return data;
	}

}

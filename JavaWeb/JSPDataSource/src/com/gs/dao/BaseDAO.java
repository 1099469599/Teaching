package com.gs.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDAO {

	protected Connection conn;
	public void getConn() {
		try {
			Context context = new InitialContext(); // ��ȡjndi������
			Object obj = context.lookup("java:comp/env/datasource/mysql"); // ͨ����Դ��������ȡ��Դ
			if (obj instanceof DataSource) { // ����Դ�����ж�
				DataSource dataSource = (DataSource) obj; // ����Դ������ת��
				conn = dataSource.getConnection(); // DataSource�����ӳ��л�ȡ���� 
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}

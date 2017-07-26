package com.gs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	
	public static void main(String[] args) {
		User user = new User();
		user.setId("1002");
		user.setName("10001");
		user.setPassword("10001");
		try {
			// ʹ��Class.forName(ָ�������ȫ�޶���)��ʾ��ȫ�޶�������ʾ������ص�JVM��
			// ������������ʵ���Ǽ���***Driver.class���ļ�������SQLServer��˵��com.microsoft.sqlserver.jdbc.SQLServerDriver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=jdbc", "sa", "123456");
			Statement stmt = conn.createStatement();
			stmt.execute("insert into t_user(id, name, password) values('1005', '1005', '1005')");
			stmt.execute("delete from t_user where id = '1001'");
			String updateSQL = "update t_user set name = '" + user.getName() + "'" + " where id = '" + user.getId() + "'";
			System.out.println("update sql: " + updateSQL);
			int row = stmt.executeUpdate(updateSQL);
			System.out.println("���µ������� " + row);
			ResultSet rs = stmt.executeQuery("select * from t_user");
			while (rs.next()) {
				System.out.println("id: " + rs.getString("id") + ", name: " + rs.getString("name") + ", password: " + rs.getString(3));
			}
			rs.close(); // �رս����
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { // java.sql.SQLException ��ʾ���ݿ��쳣
			e.printStackTrace();
		}
	}

}

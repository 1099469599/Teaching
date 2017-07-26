package com.gs.qq.ui.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import com.gs.bean.Account;
import com.gs.common.ReflectUtil;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.client.Client;
import com.gs.qq.ui.LoginFrame;
import com.gs.qq.ui.MainFrame;

public class LoginListener extends MouseAdapter {

	private LoginFrame loginFrame;
	private JComboBox<String> accBox;
	private JPasswordField pwd;
	
	/**
	 * ʵ����һ��������¼��ť�ļ�����
	 * �˼�������Ҫ֪������Դ���ĸ�����
	 * ����Ҫ��ȡ�˺ź�����
	 * @param loginFrame
	 * @param accBox
	 * @param pwd
	 */
	public LoginListener(LoginFrame loginFrame, JComboBox<String> accBox, JPasswordField pwd) {
		this.loginFrame = loginFrame;
		this.accBox = accBox;
		this.pwd = pwd;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String number = accBox.getItemAt(0); // ��ȡ�˺ţ� ��ָ��checkbox��ѡ���
		if (number == null) { // ���û���˺���Ϣ������ζ�ź��п������û��ֶ������
			number = (String) ReflectUtil.getFieldValue(JComboBox.class, accBox, "selectedItemReminder"); // ��ȡ�û��ֶ�������˺�
			
		}
		if (number != null && !number.equals("") ) {
			System.out.println("aaaa");
			AccountDAO accountDAO = new AccountDAOImpl();
			Account a = accountDAO.query(number, new String(pwd.getPassword()));
			if (a != null) { // ������ݿ����и� �˺ţ���ɵ�¼����
				System.out.println("bbb");
				Client client = new Client(); // ʵ����Client��
				client.login(a);
				loginFrame.dispose();
				new MainFrame(client, a); // ���Ѿ���¼���û���Ϣ���ݸ������棬�Ѵ��û���Ӧ��Client����Ҳ���ݸ�������
				
			}else {
				JOptionPane.showMessageDialog(loginFrame, "�˺Ż��������");
			}
		}
	}

}

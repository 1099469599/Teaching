package com.gs.qq.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import com.gs.bean.Account;
import com.gs.bean.Message;
import com.gs.common.DateUtil;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.client.Client;

public class FriendSearchTableListener extends MouseAdapter implements ActionListener {

	private String number;
	private Account account;
	private AccountDAO accountDAO;
	private Client client;
	
	public FriendSearchTableListener(Client client, Account account) {
		this.client = client;
		this.account = account;
		accountDAO = new AccountDAOImpl();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table = (JTable) e.getSource();
		int index = table.getSelectedRow(); // ��ȡ���������һ�е�������ͨ�����������Դ�TableModel�л�ȡָ����account��Ϣ
		if (e.getButton() == MouseEvent.BUTTON3 && index > -1) { // MouseEvent.BUTTON3����Ҽ� BUTTON1������ BUTTON2����
			number = (String) table.getModel().getValueAt(index, 0); // ��ȡָ���е��˺���Ϣ
			JPopupMenu menu = new JPopupMenu();
			JMenuItem viewItem = new JMenuItem("�鿴����");
			viewItem.setActionCommand("view");
			viewItem.addActionListener(this);
			JMenuItem addItem = new JMenuItem("��Ӻ���");
			addItem.setActionCommand("add");
			addItem.addActionListener(this);
			menu.add(viewItem);
			menu.add(addItem);
			table.add(menu);
			menu.show(table, e.getX(), e.getY()); // show�����Ѹ��Ҽ��˵���ʾ����
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("view")) {
			Account a = accountDAO.query(number);
			if (a != null) {
				// TODO �����´�����ʾ���û�����Ϣ
			}
		} else if (action.equals("add")) {
			// TODO ������Ϣ���Է��˺ţ�������Ӻ���
			Account toAccount = accountDAO.query(number); // ��ͨ��ѡ���е�numberȥ���ݿ��в��Ҹ��˻���������Ϣ
			Message m = new Message(Message.REQUEST_MSG, account, toAccount, DateUtil.getDate(), account.getNickname() + "���������Ϊ����");
			client.sendMessage(m);
		}
	}

}

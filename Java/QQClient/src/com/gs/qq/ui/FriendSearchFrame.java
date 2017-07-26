package com.gs.qq.ui;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.gs.bean.Account;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.client.Client;
import com.gs.qq.ui.common.List2TableVector;
import com.gs.qq.ui.listener.FriendSearchTableListener;

public class FriendSearchFrame extends JFrame {

	private static final long serialVersionUID = -1630610494782811908L;
	private Account account;
	private Client client;
	public FriendSearchFrame(Client client, Account account) {
		this.client = client;
		this.account = account;
		setSize(600, 400);
		setTitle("���Һ���");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setIconImage(new ImageIcon("img/qq_icon.png").getImage());
		top();
		center();
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setVisible(true);
	}
	
	private void top() {
		// TODO ���ɸѡ�Ŀؼ�
	}
	
	private void center() {
		JTable table = new JTable();
		Vector<String> columnNames = new Vector<String>(); // ����ÿһ�е�����
		columnNames.add("�˺�");
		columnNames.add("�ǳ�");
		List2TableVector toVector = new List2TableVector(); // ��List�б�ת����JTable����ʹ�õ�Vector<Vector>����
		AccountDAO accountDAO = new AccountDAOImpl();
		DefaultTableModel dataModel = new DefaultTableModel(toVector.toVector(accountDAO.queryAll()), columnNames); // ʵ�����ṩ���ݵ�model��
		table.setModel(dataModel);
		table.addMouseListener(new FriendSearchTableListener(client, account));// ��������Ҽ����
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 20, 560, 360);
		add(scrollPane);
	}

}

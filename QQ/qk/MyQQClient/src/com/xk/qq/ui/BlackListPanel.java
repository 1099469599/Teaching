package com.xk.qq.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.xk.bean.Account;
import com.xk.qq.client.Client;
import com.xk.qq.ui.listener.AddListener;
import com.xk.qq.ui.listener.DeleteFriendListener;
import com.xk.qq.ui.listener.ExitListener;

public class BlackListPanel extends JPanel{
	
	private static final long serialVersionUID = 9126170339497812340L;

	private DefaultListModel<Account> blackModel;
	private MainFrame mainFrame;
	private Account account;
	private Client client;
	private int index = -1;

	public BlackListPanel(MainFrame mainFrame,List<Account> accounts,Client client,Account account){
		this.mainFrame = mainFrame;
		this.account = account;
		this.client  =client;
		JList<Account> fined = new JList<Account>();
		fined.setFixedCellHeight(65);
		fined.setFixedCellWidth(260);
		fined.setVisibleRowCount(5);
		blackModel = new DefaultListModel<Account>();
		if(account != null){
			for(Account a: accounts){
			blackModel.addElement(a);
			}
		}
		fined.setModel(blackModel);
		fined.setOpaque(false);
		fined.setCellRenderer(new BlackListCellRederer()); // �������ڻ����б���ÿ����Ԫ��ί�С�
		fined.addMouseMotionListener(new FinedMouseListener());
		fined.addMouseListener(new AddListener(this,client,account,mainFrame));
		JScrollPane scrollPane = new JScrollPane(fined); 
		scrollPane.setBounds(0,0,260,65);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		add(scrollPane);
		setOpaque(false);
		
	}
	
	class FinedMouseListener implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			@SuppressWarnings("rawtypes")
			JList list = (JList)e.getSource(); // ��ȡ���λ�� 
			index = list.locationToIndex(e.getPoint());// // locationToIndex(Point)
			list.setSelectedIndex(index); // �����������λ�õ��Ǹ���Ŀ����������Ϊ��ѡ�У�һ������Ϊ��ѡ�У���CellRenderer���isSelected��Ϊtrue
		}
		
	}
	
	public void updateFriendList(Account account) {
		blackModel.addElement(account);
	}

	public void delteFriedndList(Account toaccount){
		blackModel.removeElement(toaccount);
	}
}

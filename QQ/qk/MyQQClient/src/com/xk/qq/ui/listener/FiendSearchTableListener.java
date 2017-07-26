package com.xk.qq.ui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import com.xk.bean.Account;
import com.xk.bean.Message;
import com.xk.common.DateUtil;
import com.xk.dao.AccountDAO;
import com.xk.dao.AccountDAOImpl;
import com.xk.qq.client.Client;
import com.xk.qq.ui.FriendSearchFrame;
import com.xk.qq.ui.LookFrame;

public class FiendSearchTableListener extends MouseAdapter implements ActionListener{
	
	private Account account;
	private String number;
	private AccountDAO accountDAO;
	private Client client;
	private FriendSearchFrame friend;
	
	public  FiendSearchTableListener(Account account,Client client,FriendSearchFrame friend){
		this.account = account;
		this.client = client;
		accountDAO = new AccountDAOImpl();
		this.friend = friend;
		
	}
	private int index = -1;
	private JTable table;
	@Override
	public void mouseClicked(MouseEvent e) {
		table = (JTable)e.getSource();
		index = table.getSelectedRow();
		if(e.getButton() == MouseEvent.BUTTON3 && index > -1){
			number = (String) table.getModel().getValueAt(index,0); // ��ȡָ���˺���Ϣ
			JPopupMenu menu = new JPopupMenu();
			JMenuItem dataItem = new JMenuItem("�鿴��������");
			dataItem.setActionCommand("data");
			dataItem.addActionListener(this);
			JMenuItem fiendItem = new JMenuItem("��Ӻ���");
			fiendItem.setActionCommand("fiend");
			fiendItem.addActionListener(this);
			menu.add(dataItem);
			menu.add(fiendItem);
			menu.show(table, e.getX(), e.getY());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if(action.equals("data")){
			Account a = accountDAO.queryFriend(number);
			if(a != null ){
				if(!friend.getLookFrames().containsKey(a)){
					LookFrame lookFrame = new LookFrame(a,null);
					lookFrame.setVisible(true);
					lookFrame.updateLook(a);
					friend.getLookFrames().put(a,lookFrame);
				}else {
					friend.getLookFrames().get(a).setVisible(true);
				}
				// TODO �鿴�������ϵĴ���
			}
		}else if(action.equals("fiend")){
			Account toAccount = accountDAO.queryFriend(number);
			
			if(!accountDAO.queryFriend(account.getNumber(), toAccount.getNumber())){
				Message message = new Message(Message.REQUEST_MSG,DateUtil.getDate(),account,toAccount,"�������Ϊ����");
				client.sendMessage(message);
			}else {
				JOptionPane.showMessageDialog(friend, "�Ѿ���������˲����ڼ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
	}

}

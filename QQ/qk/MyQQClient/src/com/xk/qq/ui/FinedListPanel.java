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
import com.xk.qq.ui.listener.DeleteFriendListener;
import com.xk.qq.ui.listener.ExitListener;

public class FinedListPanel extends JPanel{
	
	private static final long serialVersionUID = 9126170339497812340L;

	private DefaultListModel<Account> finedModel;
	private MainFrame mainFrame;
	private Account account;
	private Client client;
	private int index = -1;
	
	public FinedListPanel(MainFrame mainFrame,List<Account> accounts,Client client,Account account){
		this.mainFrame = mainFrame;
		this.account = account;
		this.client  =client;
		JList<Account> fined = new JList<Account>();
		fined.setFixedCellHeight(65);
		fined.setFixedCellWidth(260);
		fined.setVisibleRowCount(5);
		finedModel = new DefaultListModel<Account>();
		if(account != null){
			for(Account a: accounts){
			finedModel.addElement(a);
			}
		}
		fined.setModel(finedModel);
		fined.setOpaque(false);
		fined.setCellRenderer(new FinedListCellRederer()); // �������ڻ����б���ÿ����Ԫ��ί�С�
		fined.addMouseMotionListener(new FinedMouseListener());
		fined.addMouseListener(new DeleteFriendListener(this,client,account,mainFrame));
		fined.addMouseListener(new ClickMouseListener(client,mainFrame,account));
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
	
	class ClickMouseListener extends MouseAdapter {
		private MainFrame mainFrame;
		private Client client;
		private Account account;
		public ClickMouseListener(Client client, MainFrame mainFrame,Account account){
			this.client = client;
			this.mainFrame = mainFrame;
			this.account = account;
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2){ // �������
				@SuppressWarnings("rawtypes")
				JList list = (JList)e.getSource(); // ��ȡ���λ�� 
				if(index >= 0){
					Account toAccount = (Account) list.getModel().getElementAt(index); // ��ȡ��������ĸ��˺�
					if(!mainFrame.getChatFrames().containsKey(toAccount)){
						ChatFrame chatFrame = new ChatFrame(client,account,toAccount);
						chatFrame.setVisible(true);
						mainFrame.getChatFrames().put(toAccount, chatFrame);
					}else {
						mainFrame.getChatFrames().get(toAccount).setVisible(true);
					}
				}
			}
		}
		
		
	}
	public void updateFriendList(Account account) {
		finedModel.addElement(account);
	}
	public void updateFriendState(Account account){
		int idenx = finedModel.indexOf(account);
		finedModel.removeElement(account);
		finedModel.insertElementAt(account,idenx);
	}
	public void delteFriedndList(Account toaccount){
		finedModel.removeElement(toaccount);
	}
}

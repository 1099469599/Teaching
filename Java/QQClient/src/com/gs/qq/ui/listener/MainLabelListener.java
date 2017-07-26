package com.gs.qq.ui.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.gs.bean.Message;
import com.gs.common.DateUtil;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.client.Client;
import com.gs.qq.ui.MainFrame;
import com.gs.qq.ui.MainFrame.ReqThread;

public class MainLabelListener extends MouseAdapter {

	private MainFrame mainFrame;
	private Client client;
	
	/**
	 * ���û����ϵͳ��Ϣͼ���ʱ����Ҫ��ʾdialog����ͼ���л���Ĭ�ϵ�ͼ��
	 * @param client
	 * @param mainFrame
	 */
	public MainLabelListener(Client client, MainFrame mainFrame) {
		this.client = client;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel lbl = (JLabel) e.getSource();
		String name = lbl.getName();
		if (name.equals("reqMsg")) {
			ReqThread reqThread = mainFrame.getReqThread(); // ȥ��ȡ�Ƿ��Ѿ��������л�ͼ����߳�
			if (reqThread != null) { // ����Ѿ������˸��̣߳�ͼ����������
				mainFrame.getReqMsgLbl().setIcon(new ImageIcon("img/qme.png")); // �л�ΪĬ��ͼ��
				reqThread.setNeedRunning(false); // ֹͣ���߳�
				Message message = mainFrame.getMessage();
				// չ����Ӻ��ѵĶԻ���
				int result = JOptionPane.showConfirmDialog(mainFrame, message.getFromAccount().getNumber() + "��Ҫ�����Ϊ����", "��Ӻ���", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (result == JOptionPane.OK_OPTION) { // ͬ����Ӻ���
					AccountDAO accountDAO = new AccountDAOImpl();
					accountDAO.addFriend(message.getToAccount().getNumber(), message.getFromAccount().getNumber());
					Message m = new Message(Message.REQUEST_REV_MSG,message.getToAccount(), message.getFromAccount(), DateUtil.getDate(), message.getToAccount().getNickname() + "�������Ϊ����");
					client.sendMessage(m);
					mainFrame.updateFriendList(message.getFromAccount());
				}
			}
		}
	}

}

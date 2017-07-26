package com.xk.qq.ui.listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.xk.bean.Message;
import com.xk.common.DateUtil;
import com.xk.dao.AccountDAO;
import com.xk.dao.AccountDAOImpl;
import com.xk.qq.client.Client;
import com.xk.qq.ui.MainFrame;
import com.xk.qq.ui.MainFrame.RepThread;

public class MainLblListener extends MouseAdapter {
	
	private Client client;
	private MainFrame mainFrame;
	
	
	/**
	 * ���û����ϵͳ��Ϣͼ���ʱ����Ҫ��ʾdialog����ͼ���л���Ĭ�ϵ�ͼ��
	 * @param client
	 * @param mainFrame
	 */
	public MainLblListener(Client client,MainFrame mainFrame){
		this.client = client;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel lbl = (JLabel)e.getSource();
		String name = lbl.getName();
		if(name.equals("repLbl")){
			AccountDAO accountDAO = new AccountDAOImpl();
			RepThread repThread = mainFrame.getRepThread(); // ��ȡ�Ѿ��������߳��л�ͼ��
			if(repThread != null){  // ����Ѿ�������ͼ��������
				mainFrame.getVoiceLbl().setIcon(new ImageIcon("images/voice_def.png")); // ����ͼ��ΪĬ��ͼ��
				repThread.setNeedRunning(false); 		// ���߳�ֹͣ
				Message message = mainFrame.getMessage(); 
					// ������Ӻ��ѶԻ���
				
				if(!accountDAO.queryFriend(message.getFromAccount().getNumber(),message.getToAccount().getNumber())){
					int result = JOptionPane.showConfirmDialog(mainFrame, message.getFromAccount().getNumber() + "��Ҫ�����Ϊ����","��Ӻ���",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.OK_OPTION){ // ���ͬ��ú���
						mainFrame.getVoiceLbl().setIcon(new ImageIcon("images/voice_def.png"));
						accountDAO.addFriend(message.getToAccount().getNumber(), message.getFromAccount().getNumber()); // �Ѻ�����ӵ����ݿ�
						Message m = new Message(Message.REQUEST_REV_MSG,DateUtil.getDate(),message.getToAccount(),message.getFromAccount(),"�������Ϊ����");
						// �ɸú���getToAccount������Ϣ˵���������Ϊ����
						client.sendMessage(m);
						mainFrame.updateFriendList(message.getFromAccount());
						accountDAO.deleteBalck(message.getToAccount().getNumber(), message.getFromAccount().getNumber());
						mainFrame.deleteBlckList(message.getFromAccount());
					}
				}
				
			}
		}
	}


}

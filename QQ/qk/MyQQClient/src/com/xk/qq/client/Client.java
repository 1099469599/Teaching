package com.xk.qq.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.xk.bean.Account;
import com.xk.bean.Message;
import com.xk.dao.AccountDAO;
import com.xk.dao.AccountDAOImpl;
import com.xk.qq.ui.ChatFrame;
import com.xk.qq.ui.MainFrame;

public class Client {
	private Socket socket;
	private MainFrame mainFrame;
	
	
	
	/**
	 * �����������ø�������
	 * @param mainFrame
	 */
	public void setMainframe(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	
	/**
	 * �ͻ��������˽������� ������¼QQ�˺�
	 * ��Ҫ�Ѵ�QQ�˺ŷ��͵�����ˣ��������˴��ڴ�QQ�˺ţ���������
	 * 
	 * �������ͻ��˵Ķ��̣߳���ͣ��ȥ��ȡ�Ƿ��������ڷ���˵���Ϣ
	 * @param account
	 */
	public void login(Account account){
		try {
			socket = new Socket("localhost",1998);	//���ӷ����
			ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream()); // ��ȡQQ��
			oout.writeObject(account);	
			new Thread(new MessageReadThread(socket)).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��QQ���ѷ�����Ϣ
	 * ����д�߳̽�����Ϣ����
	 * @param message
	 */
	public void sendMessage(Message message){
		new Thread(new MessageWriteThread(socket,message)).start();
	}
	
	/**
	 * ��ͣ�شӷ���˶�ȡ��Ϣ�������ȡ�� ����Ϣ������ζ���к��ѷ�����Ϣ���Լ�
	 *
	 */
	class MessageReadThread implements Runnable {
		private Socket socket;
		public MessageReadThread(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			while(true){
					
				try {
					ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
					Message message = (Message)oin.readObject();	// ��ͣ�ӷ���˶���Ϣ
					if(message != null){	// �������Ϣ������Ϣ������
						if(message.getType() == Message.NORMAL_MSG){
							// TODO ���˵�������δ�򿪣�ͬ���������Ϣͼ�������������������Ѿ��򿪣���ֱ����ʾ���������
							System.out.println("���ԣ�" + message.getFromAccount().getNumber() + "����Ϣ");
							System.out.println(message.getMessage());
							System.out.println("���¶Է��Ĵ���:" + message.getFromAccount().getNumber());
							mainFrame.getChatFrames().get(message.getFromAccount()).updateMessage(message);
						}else if(message.getType() == Message.REQUEST_MSG){
							// TODO ����������������� ����������
							mainFrame.receiveRepThread(message);
						}else if(message.getType() == Message.REQUEST_REV_MSG){
							Account account = message.getFromAccount();
							AccountDAO accountDAO = new AccountDAOImpl();
							// ���նԷ���Ϣ��ͬʱҲ�ѶԷ��ӵ������б���
							accountDAO.addFriend(message.getToAccount().getNumber(), message.getFromAccount().getNumber());
							mainFrame.updateFriendList(account); // ���º����б�
							
							accountDAO.deleteBalck(message.getToAccount().getNumber(), message.getFromAccount().getNumber());
							mainFrame.deleteBlckList(account);
						}else if(message.getType() == Message.STATES_CHANGE){
							Account account = message.getFromAccount();
							mainFrame.updateFriendStates(account);
						}else if(message.getType() == Message.DELETE_MSG){
							Account account = message.getFromAccount();
							AccountDAO accountDAO = new AccountDAOImpl();
							accountDAO.deleteFriend(message.getToAccount().getNumber(),message.getFromAccount().getNumber());
							mainFrame.deleteFriend(account);
						}else if(message.getType() == Message.LOGOUT_MSG){
							Account account = message.getFromAccount();
							mainFrame.updateFriendStates(account);
						}else if(message.getType() == Message.BLACKLIST_MSG){
							Account account = message.getFromAccount();
							AccountDAO accountDAO = new AccountDAOImpl();
							accountDAO.deleteFriend(message.getToAccount().getNumber(),message.getFromAccount().getNumber());
							mainFrame.deleteFriend(account);
							
							accountDAO.addBlack(message.getToAccount().getNumber(), message.getFromAccount().getNumber());
							mainFrame.updateBlackList(account);
							
						}else if(message.getType() == Message.SHAKE_MSG){
							mainFrame.getChatFrames().get(message.getFromAccount()).updateShake();
				
						}
						
					}
				} catch(SocketException e){
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	/**
	 * д��Ϣ�߳�
	 * һ������Ϣ���͵��˷���ˣ�����߳�����
	 */
	
	class MessageWriteThread implements Runnable {
		private Socket socket;
		private Message message;
		public MessageWriteThread(Socket socket, Message message) {
			this.socket = socket;
			this.message = message;
		}
		@Override
		public void run() {
			try {
				ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
				oout.writeObject(message);
				
			} catch(SocketException e){
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

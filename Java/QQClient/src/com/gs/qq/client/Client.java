package com.gs.qq.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

import com.gs.bean.Account;
import com.gs.bean.Message;
import com.gs.common.Constants;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.ui.MainFrame;

/**
 * QQ�ͻ��ˣ��������ӷ�����
 * ��Ϣ�Ľ����뷢��
 * @param <QQMessageMusic>
 *
 */
public class Client<QQMessageMusic> {
	
	private Socket socket;
	private MainFrame mainFrame;
	
	public Client() {
		
	}
	
	/**
	 * �����������ø�������
	 * @param mainFrame
	 */
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	/**
	 * �ͻ��������˽������� ������¼QQ�˺�
	 * ��Ҫ�Ѵ�QQ�˺ŷ��͵�����ˣ��������˴��ڴ�QQ�˺ţ���������
	 * 
	 * �������ͻ��˵Ķ��̣߳���ͣ��ȥ��ȡ�Ƿ��������ڷ���˵���Ϣ
	 * @param account
	 */
	public void login(Account account) {
		try {
			socket = new Socket("localhost", Constants.PORT);
			if (socket == null) {
				System.out.println("aaaa");
			}
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(account);
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
	public void sendMessage(Message message) {
		MessageWriteThread writer = new MessageWriteThread(socket);
		writer.setMessage(message);
		new Thread(writer).start();
	}
	
	/**
	 * ��ͣ�شӷ���˶�ȡ��Ϣ�������ȡ�� ����Ϣ������ζ���к��ѷ�����Ϣ���Լ�
	 *
	 */
	class MessageReadThread implements Runnable {

		private Socket socket;
		
		public MessageReadThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(Constants.MESSAGE_DELAY);
					ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
					Message message = (Message) oin.readObject();
					if (message != null) {
						if (message.getType() == Message.NORMAL_MSG) {
							// TODO ���˵�������δ�򿪣�ͬ���������Ϣͼ�������������������Ѿ��򿪣���ֱ����ʾ���������
							System.out.println("��������" + message.getFromAccount().getNumber() + "����Ϣ");
							System.out.println( message.getMessage());
							mainFrame.getChatFrames().get(message.getFromAccount()).updateMessage(message);
						} else if (message.getType() == Message.REQUEST_MSG) {
							mainFrame.receiveRequestMsg(message); // ��������ͼ����ʾ
							
						} else if (message.getType() == Message.REQUEST_REV_MSG) {
							Account account = message.getFromAccount();
							AccountDAO accountDAO = new AccountDAOImpl();
							accountDAO.addFriend(message.getToAccount().getNumber(), message.getFromAccount().getNumber());
							mainFrame.updateFriendList(account); // ���º����б�
						} else if (message.getType() == Message.STATUS_CHANGE_MSG) {
							Account account = message.getFromAccount();
							mainFrame.updateFriendStatus(account);
						}
					}
				} catch (SocketException e) {
					try {
						socket.close();
						break;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
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
		
		public MessageWriteThread(Socket socket) {
			this.socket = socket;
		}
		
		public Message getMessage() {
			return message;
		}

		public void setMessage(Message message) {
			this.message = message;
		}

		@Override
		public void run() {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(message);
				System.out.println("������Ϣ��" + message.getToAccount().getNumber());
			} catch (SocketException e) {
				if (!socket.isClosed()) {
					try {
						socket.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}

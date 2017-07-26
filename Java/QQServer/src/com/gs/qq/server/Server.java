package com.gs.qq.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gs.bean.Account;
import com.gs.bean.Message;
import com.gs.common.Constants;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.bean.QQSocket;

/**
 * QQ����ˣ�����ȴ�Socket���ӣ���������socket����
 * ��Ϣ�Ľ�����ת������
 *
 */
public class Server {
	
	private List<QQSocket> sockets;
	
	public Server() {
		sockets = new ArrayList<QQSocket>(); 
		new Thread(new Connector()).start();
	}
	
	/**
	 * ͨ���߳����������ӣ��˽����Ĺ�������Զ��ֹͣ�ģ�һֱ��Ҫ�ȴ��ͻ���QQ�û���¼
	 * һ���пͻ��˵�¼����Ѵ�������QQ�˺Ź��������QQSocket�����ٱ��浽����˳��е�����������Ϣ���б��У�private List<QQSocket> sockets;��
	 * 
	 * ���������ӵĶ��̣߳�ȥ��ȡ��QQ�˺Ŷ�Ӧ�Ŀͻ��˷��͹�������Ϣ
	 *
	 */
	class Connector implements Runnable {

		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(Constants.PORT);
				while (true) {
					System.out.println("���������ڵȴ��ͻ��˵�����");
					Socket socket = serverSocket.accept();
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					Account account = (Account) ois.readObject(); // ��ȡ��¼�˺�
					System.out.println(account.getNumber() + "�ѵ�¼");
					account.setStatus(Constants.STATUS_ONLINE);
					QQSocket qqSocket = new QQSocket(account, socket);
					sockets.add(qqSocket);
					AccountDAO accountDAO = new AccountDAOImpl();
					accountDAO.updateStatus(account.getNumber(), Constants.STATUS_ONLINE);
					new Thread(new MessageReadThread(qqSocket)).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * ����˶�ȡ�ͻ�����Ϣ�߳�
	 * һ���ͻ��˽��������ӣ���ͻ����ڲ���ʱ������Ϣ���͹��������Է���˱��벻ͣ��ȥ��ȡ�Ƿ��пͻ�����Ϣ
	 * 
	 * ��ȡMessage��������ʹ��ObjectInputStream
	 * 
	 * һ������Ϣ����ȡ������ζ��Ҫ�Ѵ���Ϣת�������ѣ�ת�����Է�����ǰ�������ж��Ѿ��������������Ƿ��иú��ѣ�����У���ʹ��ObjectOutputStream
	 * �Ѵ���Ϣת��������д�̰߳���Ϣ���ͳ�ȥ��
	 *
	 */
	class MessageReadThread implements Runnable {

		private QQSocket qqSocket;
		
		public MessageReadThread(QQSocket qqSocket) {
			this.qqSocket = qqSocket;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(Constants.MESSAGE_DELAY);
					ObjectInputStream oin = new ObjectInputStream(qqSocket.getSocket().getInputStream());
					Message message = (Message) oin.readObject();
					System.out.println("��ȡ������" + message.getFromAccount().getNumber() + "����Ϣ");
					Socket toSocket = searchSocket(message.getToAccount()); // ��ȡ�Է��˺�����Ӧ��Socket����
					if (toSocket != null) {
						if (message.getType() == Message.LOGOUT_MSG) {
							System.out.println(message.getFromAccount().getNumber() + "���˳�");
							removeAccountScoket(message.getFromAccount());
							AccountDAO accountDAO = new AccountDAOImpl();
							accountDAO.updateStatus(message.getFromAccount().getNumber(), Constants.STATUS_OFFLINE);
						} else if (message.getType() == Message.STATUS_CHANGE_MSG) {
							AccountDAO accountDAO = new AccountDAOImpl();
							List<Account> accounts = accountDAO.queryNotLeaveFriends(message.getFromAccount().getNumber());
							for (Account a : accounts) {
								Socket toSocket1 = searchSocket(a); // ��ȡ�Է��˺�����Ӧ��Socket����
								if (toSocket1 != null) {
									MessageWriteThread writer = new MessageWriteThread(toSocket1);
									writer.setMessage(message);
									new Thread(writer).start();
								}
							}
						} else {
							MessageWriteThread writer = new MessageWriteThread(toSocket);
							writer.setMessage(message);
							new Thread(writer).start();
						}
					}
				} catch (SocketException e) {
					try {
						qqSocket.getSocket().close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					sockets.remove(qqSocket);
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
	 * �������ͻ���ת����Ϣ���߳�
	 * 
	 * ����ͻ�������Ϣ����������Ҫ�������߳���ת��������ת����ϣ����߳�����
	 *
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
				System.out.println("����Ϣ���͵�" + message.getToAccount().getNumber());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ж�ĳ��QQ�˺��Ƿ��Ѿ������������ ������
	 * @param account
	 * @return
	 */
	private Socket searchSocket(Account account) {
		for (QQSocket qqSocket : sockets) {
			Account a = qqSocket.getAccount();
			if (a.equals(account)) {
				return qqSocket.getSocket();
			}
		}
		return null;
	}
	
	private void removeAccountScoket(Account account) {
		Iterator<QQSocket> ite = sockets.iterator();
		while (ite.hasNext()) {
			QQSocket qqSocket = ite.next();
			if (qqSocket.getAccount().equals(account)) {
				ite.remove();
				break;
			}
		}
	}

	
}

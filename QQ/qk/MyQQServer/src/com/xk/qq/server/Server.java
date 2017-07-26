package com.xk.qq.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xk.bean.Account;
import com.xk.bean.Message;
import com.xk.common.Constants;
import com.xk.common.DateUtil;
import com.xk.dao.AccountDAO;
import com.xk.dao.AccountDAOImpl;
import com.xk.qq.bean.QQSocket;

/**
 * QQ����ˣ�����ȴ�Socket���ӣ���������socket����
 * ��Ϣ�Ľ�����ת������
 *
 */
public class Server {
	
	private List<QQSocket> sockets; 
	
	public Server() {
		sockets = new ArrayList<QQSocket>();
		new Thread(new Connect()).start();
	}
	
	/**
	 * ͨ���߳����������ӣ��˽����Ĺ�������Զ��ֹͣ�ģ�һֱ��Ҫ�ȴ��ͻ���QQ�û���¼
	 * һ���пͻ��˵�¼����Ѵ�������QQ�˺Ź��������QQSocket�����ٱ��浽����˳��е�����������Ϣ���б��У�private List<QQSocket> sockets;��
	 * 
	 * ���������ӵĶ��̣߳�ȥ��ȡ��QQ�˺Ŷ�Ӧ�Ŀͻ��˷��͹�������Ϣ
	 *
	 */
	
	class Connect implements Runnable{
		
		@Override
		public void run() {
			try {
				ServerSocket serverSocket = new ServerSocket(1998);
				while(true){
					System.out.println("���������ڵȴ��ͻ������ӡ�������");
					Socket socket = serverSocket.accept(); // ��ͣ�ĵ�����
					ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
					Account account = (Account)oin.readObject(); // ��ȡ��¼�û�
					System.out.println(account.getNumber() + "�ѵ�¼");
					account.setState(Constants.STATUS_ONLINE);
					QQSocket qqSocket = new QQSocket(account,socket); // ��ȡ�û���socket
					sockets.add(qqSocket);	// �ٱ��浽����˳��е�����������Ϣ�ŵ�������
					AccountDAO accountDAO = new AccountDAOImpl();
					accountDAO.updateStatus(account.getNumber(), Constants.STATUS_ONLINE);
					new Thread(new MessageReadThread(qqSocket)).start();// ȥ��ȡ��QQ�˺Ŷ�Ӧ�Ŀͻ��˷��͹�������Ϣ
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
	class MessageReadThread implements Runnable{
		private QQSocket qqSocket;
		
		public MessageReadThread(QQSocket qqSocket){
			this.qqSocket = qqSocket;
		} 
		
		@Override
		public void run() {
			while(true){
//				synchronized (Object.class) {
				try {
					ObjectInputStream oin = new ObjectInputStream(qqSocket.getSocket().getInputStream());
					Message message = (Message)oin.readObject();	//��ȡ��Ϣ
					Socket toSocket = searchSocket(message.getToAccount());	// �Է��û�
					if(toSocket != null){ // ����д������� ������û�
						if(message.getType() == Message.LOGOUT_MSG){
							System.out.println(message.getFromAccount().getNumber()+ "���˳�");
							removeAccountSocket(message.getFromAccount());
							AccountDAO accountDAO = new AccountDAOImpl();
							message.getFromAccount().setState(Constants.STATUS_OFFLINE);
							List<Account> accounts = accountDAO.queryNotLeaveFriends(message.getFromAccount().getNumber());
							accountDAO.updateStatus(message.getFromAccount().getNumber(),message.getFromAccount().getState());
							for(Account a: accounts){
								Socket toSocket1 = searchSocket(a);	// ��ȡ�Է��û���socket����
								if(toSocket1 != null){
									MessageWriteThread write = new MessageWriteThread(toSocket1);//��ô����Ϣ���Է�
									write.setMessage(message);	// ��������Ϣ
									new Thread(write).start();	// �����߳�
									accountDAO.updateStatus(message.getFromAccount().getNumber(), message.getFromAccount().getState());
								}
							}
						}else if(message.getType() == Message.STATES_CHANGE){
							AccountDAO accountDAO = new AccountDAOImpl();
							List<Account> accounts = accountDAO.queryNotLeaveFriends(message.getFromAccount().getNumber());
							accountDAO.updateStatus(message.getFromAccount().getNumber(), message.getFromAccount().getState());
							for(Account a: accounts){
								Socket toSocket1 = searchSocket(a);	// ��ȡ�Է��û���socket����
								if(toSocket1 != null){
									MessageWriteThread write = new MessageWriteThread(toSocket1);//��ô����Ϣ���Է�
									write.setMessage(message);	// ��������Ϣ
									new Thread(write).start();	// �����߳�
									accountDAO.updateStatus(message.getFromAccount().getNumber(), message.getFromAccount().getState());
								}
							}
								
							
						}else {
							MessageWriteThread write = new MessageWriteThread(toSocket);//��ô����Ϣ���Է�
							write.setMessage(message);	// ��������Ϣ
							new Thread(write).start();	// �����߳�
						}
					}
				}catch(SocketException e){	// �������socket�쳣
					try {
						qqSocket.getSocket().close(); // ��ô�ص�
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				}catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
//			}
			}
		}
		
	}
	
	/**
	 * �������ͻ���ת����Ϣ���߳�
	 * 
	 * ����ͻ�������Ϣ����������Ҫ�������߳���ת��������ת����ϣ����߳�����
	 *
	 */
	
	class MessageWriteThread implements Runnable{
		private Socket socket;
		private Message message;
		public Message getMessage() {
			return message;
		}

		public void setMessage(Message message) {
			this.message = message;
		}

		public MessageWriteThread(Socket socket){
			this.socket = socket;
		}
		
		@Override
		public void run() {
			try {
				ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
				oout.writeObject(message); // ����ͻ�������Ϣ����������Ҫ�������߳���ת��������ת����ϣ����߳�����
			} catch(SocketException e){	// �������socket�쳣
				try {
					socket.close(); // ��ô�ص�
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * �ж�ĳ��QQ�˺��Ƿ��Ѿ������������ ������
	 * @param account
	 * @return
	 */
	
	private Socket searchSocket(Account account){
		for(QQSocket qqSocket: sockets){
			Account accounts = qqSocket.getAccount();
			if(accounts.equals(account)){ // �ж�ĳ���˺��Ƿ��¼
				return qqSocket.getSocket();
			}
			
		}
		return null;
	}
	
	private void removeAccountSocket(Account account) {
		Iterator<QQSocket> iter = sockets.iterator();
		while(iter.hasNext()){
			QQSocket qqSocket = iter.next();
			if(qqSocket.getAccount().equals(account)){
				iter.remove();
				break;
			}
		}
	}
}

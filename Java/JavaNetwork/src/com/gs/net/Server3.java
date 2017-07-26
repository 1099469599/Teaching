package com.gs.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
	
	private ServerSocket ss;
	
	public Server3() {
		try {
			ss = new ServerSocket(8888);
			while (true) {
				System.out.println("�ȴ�����...");
				Socket socket = ss.accept();
				System.out.println("���ӳɹ�...");
				new Thread(new ReadThread(socket)).start();
				new Thread(new WriteThread(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ӿͻ��˶�ȡ��Ϣ
	 */
	class ReadThread implements Runnable {

		private Socket socket;
		
		public ReadThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(5000);
					InputStream in = socket.getInputStream();
					ObjectInputStream oin = new ObjectInputStream(in);
					System.out.println("����˶�ȡ�ͻ�����Ϣ");
					Object obj = oin.readObject();
					if (obj instanceof QUser) {
						QUser user = (QUser) obj;
						System.out.println(user.getQq() + ", " + user.getName());
					}
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * ��ͻ���д��Ϣ
	 */
	class WriteThread implements Runnable {

		private Socket socket;
		
		public WriteThread(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				try {
					Thread.sleep(5000);
					QUser user = new QUser();
					user.setQq("10000");
					user.setName("����");
					OutputStream out = socket.getOutputStream();
					ObjectOutputStream oout = new ObjectOutputStream(out); // ��ȡ���������
					System.out.println("�������ͻ��˷�����Ϣ");
					oout.writeObject(user);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Server3();
	}

}

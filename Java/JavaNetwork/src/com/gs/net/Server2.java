package com.gs.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
	
	private ServerSocket ss;
	
	public Server2() {
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
					byte[] bytes = new byte[1024];
					int total = in.read(bytes);
					System.out.println("����˶�ȡ�ͻ�����Ϣ");
					System.out.println(new String(bytes, 0, total));
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
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
					OutputStream out = socket.getOutputStream();
					System.out.println("�������ͻ��˷�����Ϣ");
					out.write("���".getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Server2();
	}

}

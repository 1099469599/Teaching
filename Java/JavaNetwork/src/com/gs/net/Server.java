package com.gs.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		try {
		ServerSocket ss = new ServerSocket(8888);
			while (true) {
				Socket socket = ss.accept(); // �ȴ��ͻ��˵����ӣ����ؿͻ��������˽����õ�����
				System.out.println(socket.getInetAddress().getHostName()); // �ڷ���˵��� ��ȡ���ǿͻ��˵�IP��ַ
				System.out.println(socket.getLocalAddress().getHostName()); // �ڷ���˵��� ��ȡ���Ƿ�����Լ���IP��ַ
				OutputStream out = socket.getOutputStream(); // ��ȡ��socket���ӵ�����������Դӷ���˷������ݵ��ͻ���
				out.write("���".getBytes());
				InputStream is = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int total = is.read(bytes);
				System.out.println(new String(bytes, 0, total));
				System.out.println("�ͻ����Ѿ�����");
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package com.gs.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server1 {
	
	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket(8888, InetAddress.getByName("localhost"));
			byte[] bytes = new byte[1024];
			DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
			ds.receive(dp); // �������ݱ������յ������ݻ����new DatagramPacketʱ��ָ�����ֽ�������
			System.out.println(new String(bytes, 0, dp.getLength())); // getLength()�������Ի�ȡ���ݱ������ݵĳ���
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

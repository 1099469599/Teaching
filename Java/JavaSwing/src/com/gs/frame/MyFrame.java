package com.gs.frame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;

public class MyFrame extends Frame {
	
	public MyFrame() {
		setTitle("�ҵĴ���"); // ���ñ���
		setSize(300, 200); // ���ô��ڴ�С�� Ĭ��0�� 0
		setLocation(200, 200);
		setBackground(Color.BLUE); // ���ñ���ɫ
		
		Panel panel = new Panel();
		panel.setSize(100, 100);
		panel.setLocation(20, 80);
		panel.setBackground(Color.GREEN);
		
		Panel panel1 = new Panel();
		panel1.setSize(50, 50);
		panel1.setLocation(20, 20);
		panel1.setBackground(Color.RED);
		panel.setLayout(null); // ��panel���ò��ֹ�����
		panel.add(panel1); // ��panel1��������ӵ�panel�����
		
		this.setLayout(null); // ����ǰ����������ò��ֹ�����Ϊnull
		add(panel); // ��panel��������ӵ���ǰframe����
		setVisible(true); // ���øô��ڿɼ��� Ĭ�ϲ��ɼ�
		
		// ����ǰ������Ӵ��������
		addWindowListener(new WindowAdapter() {
			
			// ���������ڱ��ر�ʱ�����յ������ڹر��¼������ڴ�ʱ���԰����������˳�
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("�������ڹر�...");
				System.exit(0);
				// dispose(); // �ͷŵ�ǰ������ռ�õ���Ļ��Դ
			}
			
		});
	}

}

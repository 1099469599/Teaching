package com.gs.frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutFrame extends Frame {
	
	public BorderLayoutFrame() {
		setTitle("�߿򲼾�");
		setSize(300, 300);
		setLocation(200, 200);
		
		setLayout(new BorderLayout()); // ���ñ߿򲼾ֹ�����
		
		Button button1 = new Button("��");
		add(button1, BorderLayout.NORTH);
		
		Button button2 = new Button("��");
		add(button2, BorderLayout.WEST);
		
		Button button3 = new Button("��");
		add(button3, BorderLayout.EAST);
		
		Button button4 = new Button("��");
		add(button4, BorderLayout.SOUTH);
		
		Button button5 = new Button("��");
		add(button5, BorderLayout.CENTER);
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new BorderLayoutFrame();
	}

}

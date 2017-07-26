package com.gs.frame;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComponentFrame extends Frame {
	
	public ComponentFrame() {
		setTitle("�ҵİ�ť����");
		setSize(500, 500);
		setLocation(300, 200);
		
		Button b1 = new Button("��ť1"); // ʵ����һ����ť
		// b1.setLabel("��ť1"); // ���ð�ť��ʾ���ı�
		b1.setSize(100, 100); // ���ð�ť��С 
		b1.setLocation(20, 50); // ���ð�ťλ��
		
		add(b1);
		
		Label label = new Label(); // ʵ����һ����ǩ���
		label.setText("��ǩ");
		label.setSize(100, 100);
		label.setLocation(120, 50);
		
		add(label);
		
		TextField text = new TextField();
		text.setText("�ı�������ʾ���ı�");
		text.setSize(200, 50);
		text.setLocation(220, 50);
		add(text);
		
		
		setLayout(null);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

}

package com.gs.frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends Frame {
	
	public LoginFrame() {
		setTitle("QQ��¼");
		setSize(400, 300);
		setLocation(500, 200);
		setLayout(new BorderLayout());
		
		Panel centerPanel = new Panel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		Panel namePanel = new Panel();
		Panel pwdPanel = new Panel();
		
		Label nameLbl = new Label("�˺�");
		Label pwdLbl = new Label("����");
		
		TextField nameTxt = new TextField(20);
		TextField pwdTxt = new TextField(20);
		
		namePanel.add(nameLbl);
		namePanel.add(nameTxt);
		pwdPanel.add(pwdLbl);
		pwdPanel.add(pwdTxt);
		
		centerPanel.add(namePanel);
		centerPanel.add(pwdPanel);
		
		Panel btnPanel = new Panel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		Button logBtn = new Button("��¼");
		Button cancleBtn = new Button("ȡ��");
		btnPanel.add(logBtn);
		btnPanel.add(cancleBtn);
		centerPanel.add(btnPanel);
		
		add(centerPanel, BorderLayout.CENTER);
		
		setResizable(false); // ��ʾ�Ƿ�����޸Ĵ���Ĵ�С
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}

}

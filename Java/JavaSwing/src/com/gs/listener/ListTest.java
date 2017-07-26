package com.gs.listener;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListTest extends Frame {
	
	// List��Choice�����÷�����һ��
	public ListTest() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		List list = new List(5, true); // Ĭ�ϵ�ѡ�����Ҫ��ѡ��List(int rows, boolean multipleSelected) 
		list.add("item1");
		list.add("item2");
		list.add("item3");
		list.addItemListener(new ListListener());
		add(list);
		
		Button btn = new Button("������ѡ��");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String items = "";
				for (String s : list.getSelectedItems()) {
					items += s + " ";
				}
				Dialog dialog = new Dialog(ListTest.this, "��ѡ��");
				dialog.setSize(200, 100);
				dialog.setLocationRelativeTo(null); // ���������һ�����������λ�ã�null����Ļ������ʾ
				Label label = new Label(items);
				dialog.add(label);
				dialog.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						dialog.dispose(); // �ѵ�ǰdialogռ�õ���Ļ��Դ�ͷ�
					}
				});
				dialog.setVisible(true); // ʹ��Dialog���setVisible(true)��ʾ�Ի���
			}
		});
		add(btn);
		
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] a) {
		new ListTest();
	}

}

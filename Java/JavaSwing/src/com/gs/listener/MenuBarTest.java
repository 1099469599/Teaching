package com.gs.listener;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuBarTest extends Frame {
	
	public MenuBarTest() {
		setSize(600, 400);
		setLocation(200, 200);
		setLayout(new FlowLayout());
		
		MenuBar bar = new MenuBar(); // ʵ�����˵���
		Menu menu = new Menu("File"); // ʵ����һ���˵�
		MenuItemListener l = new MenuItemListener();
		MenuItem item1 = new MenuItem("New"); // ʵ�����˵���
		item1.addActionListener(l);
		MenuItem item2 = new MenuItem("Open");
		item2.addActionListener(l);
		menu.add(item1); // �Ѳ˵�����ӵ�ĳ���˵�
		menu.addSeparator(); // ��Ӳ˵����ķָ���
		menu.add(item2);
		bar.add(menu); // �Ѳ˵���ӵ��˵���
		Menu menu1 = new Menu("Edit");
		MenuItem item3 = new MenuItem("Undo");
		item3.addActionListener(l);
		MenuItem item4 = new MenuItem("Redo");
		item4.addActionListener(l);
		menu1.add(item3);
		menu1.addSeparator();
		menu1.add(item4);
		bar.add(menu1);

		setMenuBar(bar); // ����ǰ�������ò˵���
		
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private class MenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			if (e.getActionCommand().equals("New")) {
				System.out.println("�½��ļ�");
			}
		}
	}
	
	public static void main(String[] args) {
		new MenuBarTest();
	}
}

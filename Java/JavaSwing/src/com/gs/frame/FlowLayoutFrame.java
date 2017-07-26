package com.gs.frame;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowLayoutFrame extends Frame {
	
	public FlowLayoutFrame() {
		setTitle("��ʽ����");
		setSize(300, 300);
		setLocation(200, 200);
		
		// setLayout(new FlowLayout(FlowLayout.LEADING)); // ����
		// setLayout(new FlowLayout(FlowLayout.CENTER)); // ����
		// setLayout(new FlowLayout(FlowLayout.LEFT)); // ����
		// setLayout(new FlowLayout(FlowLayout.RIGHT)); // ����
		setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 30)); // ����, ˮƽ���20����ֱ���30
		
		for (int i = 0; i < 8; i++) {
			Button button = new Button("��ť" + (i + 1));
			button.setSize(100, 50);
			add(button);
		}
		
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new FlowLayoutFrame();
	}

}

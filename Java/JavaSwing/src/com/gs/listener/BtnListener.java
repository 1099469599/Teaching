package com.gs.listener;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener implements  ActionListener {

	/**
	 * ʹ��setName����setAcionComman�����ְ�ť
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String btnName = btn.getName();
		if (btnName.equals("btn1")) {
			System.out.println("ִ�а�ť1��Ӧ�Ĳ���");
		} else if (btnName.equals("btn2")) {
			System.out.println("ִ�а�ť2��Ӧ�Ĳ���");
		}
		System.out.println(e.getActionCommand()); // ��ȡButton�ϵ�Label
		System.out.println("action...");
	}

}

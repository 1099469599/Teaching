package com.gs.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckboxListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem()); // ��ȡѡ����е��ı�ֵ
		System.out.println(e.getStateChange()); // e.getStateChange()ѡ��Ϊ1��ȡ��ѡ��Ϊ2
	}

}

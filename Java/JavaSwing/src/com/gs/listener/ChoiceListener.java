package com.gs.listener;

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem()); // �����ı�ֵ
		Choice choice = (Choice) e.getSource();
		System.out.println(choice.getSelectedItem()); // e.getItem() choice getSelectedItem�����Ի�ȡ��choiceѡ�е���
	}

}

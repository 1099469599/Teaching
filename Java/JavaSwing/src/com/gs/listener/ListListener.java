package com.gs.listener;

import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem()); // ����Item��List�е���������0��ʼ
		List list = (List) e.getSource();
		String[] strs = list.getSelectedItems();
		for (int i = 0, len = strs.length; i < len; i++) {
			System.err.println(strs[i]);
		}
		for (String s : strs) { // for-eachѭ��
			System.out.println(s);
		}
		int[] a = new int[]{};
		for (int b : a){
			
		}
	}

}

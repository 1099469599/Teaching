package com.gs.bank1;

import javax.swing.SwingUtilities;

public class BankLanucher {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new BankLoginFrame(); // ������ʾ��¼����
			}
		});
	}

}

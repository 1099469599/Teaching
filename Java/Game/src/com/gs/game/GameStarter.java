package com.gs.game;

import javax.swing.SwingUtilities;

public class GameStarter {

	/**
	 * main����ʹ����SwigUtilities.invokeLater��������ϸ�����в�������
	 * 
	 * @param args
	 *            ��CMD������ʾ����ʹ��java����ִ��main����ʱ���Դ��ݽ����Ĳ���
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GameFrame();
			}
		});
	}

}

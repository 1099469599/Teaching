package com.gs.two;

/**
 * ��final���ε��಻�ܱ��̳�
 * 
 * String��final��
 *
 */
public final class PCMouse extends Mouse {
	
	public static final int COUNT = 100;
	
	public static void main(String[] args) {
		PCMouse m = new PCMouse();
		System.out.println("��깤����������Χ��ȣ�" + Constants.MAX_WIDTH);
		m.click();
	}

}

package com.gs.qq.ui.common;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CheckCodeGenerator {
	
	public static final int LENGTH = 5;
	public static final String CHECK_CODE_STR = "3456789abcdefghjkmnpqrstuvwxyABCDEFGHJKLMNPQRSTUVWXY";
	
	public static CheckCode getCheckCode() {
		BufferedImage bufImg = new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB); // ����һ���ڴ�����ͼƬ
		Graphics g = bufImg.getGraphics(); // ��ȡ��ͼƬ�Ļ��ʶ���
		String checkCode = "";
		for (int i = 0; i < LENGTH; i++) {
			int index = new Random().nextInt(CHECK_CODE_STR.length());
			checkCode += CHECK_CODE_STR.charAt(index);
		}
		g.drawString(checkCode, 10, 10); // �ɻ��ʶ������֤�뻭��
		CheckCode cc = new CheckCode();
		cc.setCheckCode(checkCode);
		cc.setBufImg(bufImg);
		return cc;
	}

}


package com.gs.frame;

public class MyFrameTest {
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		// getLocation()����Point��Ķ���Point�ǵ���󣬰���x, y, getX(), getY()
		System.out.println("location: " + mf.getX() + ", " + mf.getLocation().getY());
		// getSize()����Dimension���󣬱�ʾ��͸ߵ�һ���࣬getWidth(), getHeight()
		System.out.println("size: " + mf.getSize().getWidth() + ", " + mf.getHeight());
		System.out.println("background: " + mf.getBackground());
	}
}

package com.gs.graphics;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gs.listener.MyWindowListener;

public class FiveGame1 extends Frame implements MouseListener {

	public static int BLACK = 1; // ����
	public static int WHITE = 2; // ����
	private boolean isBlack = true; // ��ʾ�Ƿ�Ӧ���º��壬 false���ʾ�°���
	private int xDes; // ���ӵ�Ŀ�꽻���x����
	private int yDes; // ���ӵ�Ŀ�꽻���y����
	private int[][] hold = new int[17][17]; // ����ͳ��ÿ��������Ǻ��廹�ǰ���

	public FiveGame1() {
		setSize(435,465);
		setLocationRelativeTo(null);
		addMouseListener(this);
		setResizable(false);
		setVisible(true);
		addWindowListener(new MyWindowListener());
	}

	@Override
	public void paint(Graphics g) {
		try {
			BufferedImage bufImage = ImageIO.read(this.getClass().getResource("/images/Board.gif"));
			g.drawImage(bufImage, 0, 25, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Graphics g) {
		try {
			BufferedImage img;
			if (isBlack) { // �����һ���Ǻ��壬����ƺ���
				img = ImageIO.read(this.getClass().getResource("/images/Black.gif"));
			} else { // ������ư���
				img = ImageIO.read(this.getClass().getResource("/images/white.gif"));
			}
			g.drawImage(img, xDes - 12, yDes - 12, this); // ������λ������Ҫ��ȥ���ӵ�һ���С
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX(); // ��ȡ����������λ��
		int y = e.getY();
		System.out.println(y);
		int xIndex = (int) ((x - 18) / 25.0 + 0.5); // ת��Ϊ�����λ�ø����Ľ�������������Ӧ������
		int yIndex = (int) ((y - 18) / 25.0 + 0.5);

		if (hold[xIndex][yIndex] == 0) { // �ж�����������Ľ�����Ƿ��Ѿ��ڷŹ��ӣ�Ϊ0��ʾδ�ڷţ����������
			if (isBlack) { // ����º��ӣ����¼�ý����Ϊ����
				hold[xIndex][yIndex] = BLACK;
			} else { // ����°��ӣ����¼�ý����Ϊ����
				hold[xIndex][yIndex] = WHITE;
			}
			xDes = (xIndex * 25) + 18; // ��ȡ����������
			yDes = (yIndex * 25) + 18;
			repaint();
			if (isBlack) {
				isBlack = false; // ���ǰһ���Ǻ��壬����һ�����Ǻ���
			} else {
				isBlack = true; // ������һ���Ǻ���
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		new FiveGame1();
	}

}

package com.gs.graphics;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import com.gs.listener.MyWindowListener;

public class GraphicsTest2 extends Frame implements MouseMotionListener {
	
	private BufferedImage bufImage;
	private int x;
	private int y;
	
	public GraphicsTest2() {
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseMotionListener(this);
		addWindowListener(new MyWindowListener());
	}
	
	private void createBufferedImage() {
		bufImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_BGR);
		Graphics gg = bufImage.getGraphics();
		gg.setColor(Color.RED); // ����ǰ����������ɫ
		gg.drawLine(100, 100, 200, 100); // ��ֱ�� ����x,y�� �յ��x,y
		gg.drawLine(100, 100, 100, 200);
		gg.drawRect(100, 200, 100, 50); // ������ �����õ�x,y   ���εĿ�͸�
		gg.draw3DRect(100, 300, 100, 50, false); // ������
		gg.drawRect(100, 400, 100, 50);
		gg.drawLine(150, 425, 150, 425);
		gg.drawArc(100, 400, 100, 50, 0, 270); // ������
		gg.drawString("�����ַ���", 100, 500); // �����ַ����� String��Ҫ���Ƶ��ַ�����   �ַ�����ʼ�����Ͻǵ�x,y����
		gg.drawChars(new char[]{'a', 'b', 'c', 'd'},  1, 3, 100, 550); // ���ָ����ʼλ�õ�ָ�������ַ�
		gg.drawPolygon(new int[]{310, 340, 420, 450, 500, 510}, 
						new int[]{200, 220, 310, 330, 400, 420}, 6); // ��߿�
		gg.drawOval(300, 300, 100, 200); // Բ��
		gg.drawRoundRect(400, 500, 100, 200, 5, 30); // ��Բ�Ǿ���
	}
	
	@Override
	public void paint(Graphics g) {
		createBufferedImage();
		g.drawImage(bufImage, 0, 0, this);
	}
	
	@Override
	public void update(Graphics g) {
		createBufferedImage();
		Graphics gg = bufImage.getGraphics();
		try {
			BufferedImage img = ImageIO.read(this.getClass().getResource("/images/1.jpg"));
			gg.drawImage(img, x, y, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(bufImage, 0, 0, this);
		
	}
	
	public static void main(String[] args) {
		new GraphicsTest2();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint(); // ÿ���϶����ʱ������������ػ淽�����ػ淽�����Զ����������update����������������ͼ��
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint(); // ÿ���϶����ʱ������������ػ淽�����ػ淽�����Զ����������update����������������ͼ��
		
	}

}

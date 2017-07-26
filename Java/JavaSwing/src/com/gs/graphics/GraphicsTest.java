package com.gs.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

import com.gs.listener.MyWindowListener;

public class GraphicsTest extends Frame implements MouseMotionListener {
	
	private int x;
	private int y;
	
	public GraphicsTest() {
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		addMouseMotionListener(this);
		addWindowListener(new MyWindowListener());
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED); // ����ǰ����������ɫ
		g.drawLine(100, 100, 200, 100); // ��ֱ�� ����x,y�� �յ��x,y
		g.drawLine(100, 100, 100, 200);
		g.drawRect(100, 200, 100, 50); // ������ �����õ�x,y   ���εĿ�͸�
		g.draw3DRect(100, 300, 100, 50, false); // ������
		g.drawRect(100, 400, 100, 50);
		g.drawLine(150, 425, 150, 425);
		g.drawArc(100, 400, 100, 50, 0, 270); // ������
		g.setFont(new Font("����", Font.PLAIN, 20));
		g.drawString("�����ַ���", 100, 500); // �����ַ����� String��Ҫ���Ƶ��ַ�����   �ַ�����ʼ�����Ͻǵ�x,y����
		g.drawChars(new char[]{'a', 'b', 'c', 'd'},  1, 2, 100, 550); // ���ָ����ʼλ�õ�ָ�������ַ�
		try {
			BufferedImage img = ImageIO.read(this.getClass().getResource("/images/1.jpg"));
//			Toolkit kit = Toolkit.getDefaultToolkit();
//			Image img1 = kit.getImage("map.png");
//			g.drawImage(img1, 100, 600, null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.drawPolygon(new int[]{310, 340, 420, 450, 500, 510}, 
						new int[]{200, 220, 310, 330, 400, 420}, 6); // ��߿�
		g.drawOval(300, 300, 100, 200); // Բ��
		g.drawRoundRect(400, 500, 100, 200, 5, 30); // ��Բ�Ǿ���
		super.paint(g);
	}
	
	@Override
	public void update(Graphics g) {
		g.drawLine(x, y, x, y);
		try {
			BufferedImage img = ImageIO.read(this.getClass().getResource("/images/1.jpg"));
			g.drawImage(img, x, y, null); // ������껭ͼ�������и����⣬û�а�ԭ�ȵ�ͼƬ����
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new GraphicsTest();
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

package com.xk.qq.ui.listener;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class FrameDragListener extends MouseAdapter{
	private JFrame frame;
	private Point lastPoint; //�������һ������λ��     Point
	
	public FrameDragListener(JFrame frame){
		this.frame = frame;
	}

	//����
	@Override
	public void mousePressed(MouseEvent e) {
		lastPoint = e.getLocationOnScreen(); // ������ȥ��ʱ���λ�ã���û�ɿ�
	}
	//�϶�
	@Override
	public void mouseDragged(MouseEvent e) {
		
		// ��ȡ�϶�������λ��
		Point point = e.getLocationOnScreen();
		// ��ǰ���λ�ã���ȥ��һ�����λ��
		int x = point.x - lastPoint.x;
		int y = point.y - lastPoint.y;
		// ��ȡ��ǰ����λ��
		Rectangle bound = frame.getBounds();
		// �������λ�ø��������ƶ�λ�ý��мӼ�
		bound.x += x;
		bound.y += y;
		// ���µ�λ�������ڽ�����
		frame.setBounds(bound);
		//���ƶ�������λ�ø�����һ�ε����λ��
		lastPoint = point;
	}
	
}

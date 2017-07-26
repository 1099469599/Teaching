package com.gs.listener;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListenerTest extends Frame {
	
	public ListenerTest() {
		setSize(400, 400);
		setLocation(200, 200);
		
		setLayout(new FlowLayout());
		
		Button btn = new Button("��ť");
		btn.addActionListener(new ActionListener() {
			// �����ť
			@Override
			public void actionPerformed(ActionEvent e) { 
				Object obj = e.getSource(); // ͨ���¼������ȡ�¼�Դ
				if (obj instanceof Button) { // �ж��¼�Դ�Ƿ�ΪButton���ʵ��
					Button btn = (Button) obj; // �����Button���ʵ������ǿ��ת����Button��
					System.out.println(btn.getLabel()); // ͨ���¼�Դ��ȡ��Button����Ϣ
				}
			}
		});
		add(btn);
		
		//******************* �����¼� **************************
		TextField  field1 = new TextField("�����¼�");
		field1.addFocusListener(new FocusListener() {
			// ʧȥ����
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println(FocusEvent.FOCUS_FIRST); // 1004
				System.out.println(FocusEvent.FOCUS_LAST); // 1005
				System.out.println("�ı��� ʧȥ����");
			}
			// ��ý���
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("�ı��� ��ý���");
			}
		});
		//********************* �����¼� �������ť���ı��򰴻س���***************************
		TextField  field2 = new TextField("�����¼�");
		field2.addActionListener(new ActionListener() {
			// �ı����action�¼����ڰ��س���ʱ����
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�ı���Action");
			}
		});
		//******************** �ı��¼� ************************************
		TextField  field3 = new TextField("�ı��¼�");
		field3.addTextListener(new TextListener() {
			// �ı�����ڵ��ı����޸ĺ�ͻᴥ�����¼�
			@Override
			public void textValueChanged(TextEvent e) {
				TextField f = (TextField) e.getSource();
				System.out.println(f.getText());
			}
		});
		//******************* ���̰����¼� ***************************
		TextField  field4 = new TextField("���̰����¼�");
		field4.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("teyped key");
			}
			// ���ڼ����ϰ���ĳ��
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode()); // ���ذ��I����Ӧ��assci��
				System.out.println(e.getKeyChar()); // ���ذ�������Ӧ���ַ������簴a������a
				System.out.println(e.getKeyLocation()); // ͬһ�������Ͽ������ظ��ļ��������������Դ���ĸ�λ��
				System.out.println(e.getKeyCode() == KeyEvent.VK_RIGHT); // KeyEvent�����м����϶�Ӧ�ĳ���ֵ
				System.out.println("pressed key");
			}
			// ���ڼ������ɿ�����
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("released key");
			}
		});
		// ************************* ����¼� *********************
		TextField  field5 = new TextField("����¼�");
		field5.addMouseListener(new MouseListener() {
			// ��갴�º��ɿ�
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("mouse release");
			}
			// ����� 
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("x: " + e.getX() + ", y: " + e.getY());
				// e.getClickCount(); //���ذ����Ĵ���
				// e.getPoint(); // ���ض�x,y�����װ��Ķ���
				System.out.println("mouse press");
			}
			// ����뿪
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouse exited");
			}
			// ������
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouse enter");
			}
			// ����� 
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("mouse clicked");
			}
		});
		// ************************* ���״̬�¼����ƶ����϶��� *********************
		TextField  field6 = new TextField("���״̬�¼�");
		field6.addMouseMotionListener(new MouseMotionListener() {
			// ����������ƶ�
			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("mouse moved...");
			}
			// ��������϶�
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("mouse dragged...");
				
			}
		});
		// ************************* �������¼� *********************
		TextField  field7 = new TextField("�������¼�");
		field7.addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				System.out.println("mouse wheel moved...");
			}
		});
		add(field1);
		add(field2);
		add(field3);
		add(field4);
		add(field5);
		add(field6);
		add(field7);
		
		setVisible(true);
		// ********************** �����¼� ***************************
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println(e.getSource());
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new ListenerTest();
	}
	
}

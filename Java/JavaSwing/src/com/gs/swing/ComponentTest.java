package com.gs.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ComponentTest extends JFrame {
	
	public ComponentTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setSize(400, 400);
		setTitle("�������");
		setLocationRelativeTo(null);
		
		setLayout(new FlowLayout()); // setLayout()ֱ�Ӹ�����������ó�FlowLayout�� �����Ǹ� JFrame����
		System.out.println(getLayout().getClass().getName()); // ���㴰��Ĭ��ʹ�ñ߿򲼾�
		
		// ��ȡ����������������壬 ���еĵ�Swing������Ƿ��ڸ���������ϣ�ÿ��swing��JFrameĬ��������һ��JPanel�������
		// ���û�е��������������ķ������򶥲�����Ĭ���ṩ��һ��������壬�����������javax.swing.JPanel
		Container pane = getContentPane(); 
		Container rootPane = getRootPane();
//		 setContentPane(new ContentPane()); // �����Զ����������壬���������̳���JPanel��
		
		System.out.println(pane.getClass().getName());// javax.swing.JPanel
		
		JButton btn = new JButton("���ң�");
		btn.setSize(100, 100);
		// btn.setText("aaa");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ť���");
//				JDialog dialog = new JDialog(ComponentTest.this);
//				dialog.setSize(200, 200);
//				dialog.setLocationRelativeTo(null);
//				dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//				dialog.setVisible(true);
				//************************* �Ի����ʹ�� *****************************
				JOptionPane.showMessageDialog(ComponentTest.this, "���ǶԻ���"); // ��ʾ��Ϣ�Ի��򣬵�һ��������ָ���������ڶ�����������Ϣ�ַ���
				JOptionPane.showOptionDialog(ComponentTest.this, "����ѡ��Ի���", "����", 
						JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null); // ����������Ϣ�����⣬�Ի����еİ�ť����Ϣ������
				int result = JOptionPane.showConfirmDialog(ComponentTest.this, "ȷ����"); // ����ֵ Ϊ0��ʾ���ȷ����1��ʾ��2��ʾȡ��
				System.out.println("showConfirmDialog result: " + result);
				int result1 = JOptionPane.showConfirmDialog(ComponentTest.this, "ȷ����", "ȷ�ϲ���", JOptionPane.OK_CANCEL_OPTION);
				System.out.println("showConfirmDialog reuslt: " + result1);
			}
			
		});
		pane.add(btn);
		JTextField fld = new JTextField("Ĭ���ı�", 20);
		fld.setForeground(Color.RED);
		fld.setFont(new Font("����", Font.BOLD, 15));
		fld.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		add(fld);
		JPasswordField pf = new JPasswordField(10);
		add(pf);
		
		JCheckBox box1 = new JCheckBox("1", false);
		box1.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println("״̬�ı�"); // ����ƶ���ѡ����Ƴ���ѡ��ʱ����
			}
		});
		JCheckBox box2 = new JCheckBox("2", true);
		ButtonGroup group1 = new ButtonGroup();
		group1.add(box1);
		group1.add(box2); // һ��ʹ��ButtonGroup��JCheckBox��Ϊһ�飬�������ڵ�ѡ��ť�Ĺ���
		add(box1);
		add(box2);
		
		JRadioButton btn1 = new JRadioButton("1", false);
		JRadioButton btn2 = new JRadioButton("2", false);
		ButtonGroup group = new ButtonGroup(); // ButtonGroup�����������һ���߼�����
		group.add(btn1);
		group.add(btn2);
		add(btn1);
		add(btn2);
		
		JToggleButton tbtn = new JToggleButton("��", false);
		tbtn.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				JToggleButton btn = (JToggleButton) e.getSource();
				String text = btn.getText();
				System.out.println(text);
				if (text.equals("��")) { // �����״̬��ťԭ���ǿ���������Ϊ��
					btn.setText("��");
				} else {
					btn.setText("��");
				}
			}
 		});
		add(tbtn);
		
		JComboBox cb1 = new JComboBox(new String[]{"ABC", "BCD", "CDE"});
		cb1.addItem("DEF"); // �����
		cb1.removeItemAt(1); // ɾ��ָ����������
		JComboBox<String> cb2 = new JComboBox<String>(new String[]{"abc", "bcd", "cde"}); // �Ժ���˵
		add(cb1);
		add(cb2);
		
		JButton fileBtn = new JButton("ѡ���ļ�");
		fileBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser c = new JFileChooser();
				int result = c.showOpenDialog(ComponentTest.this);
				if (result == JFileChooser.APPROVE_OPTION) {
					File file = c.getSelectedFile(); // ��ȡ��ѡ����ļ�
					System.out.println(file.getPath() + ", " + file.getName());
					System.out.println("�ɹ����ļ�");
				} else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("ȡ���ļ�ѡ��");
				}
			}
		});
		add(fileBtn);
		
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("�ļ�");
		JMenuItem item1 = new JMenuItem("��");
		JMenuItem item2 = new JMenuItem("�½�");
		menu.add(item2);
		menu.addSeparator();
		menu.add(item1);
		item1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouse enter item1");
				JPopupMenu subItem1 = new JPopupMenu("AA");
				subItem1.setVisible(true);
			}
			
		});
		bar.add(menu);
		setJMenuBar(bar);
		
		// pack(); // preferred size
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // ����Ĭ�Ϲرղ����ķ�ʽ
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // ���ô������������
		setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		new ComponentTest();
	}

}

package com.gs.listener;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListenerTest2 extends Frame {
	
	public ListenerTest2() {
		setSize(400, 400);
		setLocation(200, 200);
		setLayout(new FlowLayout());
		
		Button button = new Button("���ң�");
		button.setName("btn1");
		button.setActionCommand("1");
		button.addActionListener(new BtnListener());
		add(button);
		
		Button button1 = new Button("���ң�");
		button1.setName("btn2");
		button1.setActionCommand("2");
		button1.addActionListener(new BtnListener());
		add(button1);
		
		TextField field = new TextField();
		field.addTextListener(new FieldListener());
		add(field);
		
		TextField field1 = new TextField("AAAA", 10);
		field1.setFont(new Font("΢���ź�", Font.BOLD, 10));
		field1.setForeground(Color.RED); // ����ǰ��ɫ
		field1.setEditable(false); // �����ı����Ƿ�ֻ��
		field1.addTextListener(new FieldListener());
		add(field1);
		
		TextArea txtArea = new TextArea("��ʼ�ı�", 4, 20);
		txtArea.setFont(new Font("΢���ź�", Font.BOLD, 20));
		txtArea.setForeground(Color.RED); // ����ǰ��ɫ
		add(txtArea);
		
		CheckboxGroup cbGroup = new CheckboxGroup();
		
		Checkbox cb1 = new Checkbox("Running", false);
		Checkbox cb2 = new Checkbox("Reading", true);
		Checkbox cb3 = new Checkbox("Sleeping", true);
		cb1.addItemListener(new CheckboxListener());
		cb2.addItemListener(new CheckboxListener());
		cb1.setCheckboxGroup(cbGroup); // ��ѡ����������ѡ����飬���ѡ����������棬�ͱ���˵�ѡ��ť��ֻ��ѡ��һ
		cb2.setCheckboxGroup(cbGroup);
		cb3.setCheckboxGroup(cbGroup);
		
		add(cb1);
		add(cb2);
		add(cb3);
		// add(cbGroup); // ���ǰ�CheckboxGroup��ӵ������У���Ϊ���������
		System.out.println("cb2�Ƿ�ѡ��: " + cb2.getState());
		
		Choice choice = new Choice();
		choice.add("item1");
		choice.add("item2");
		choice.add("item3");
		choice.addItem("item4"); // add(String) addItem(String)���������ѡ��ֵ
		choice.addItemListener(new ChoiceListener());
		choice.select(2); // ѡ��ָ��������item
		System.out.println(choice.getItemCount()); // ��ȡ��������
		System.out.println(choice.getItem(3)); // ��ȡָ��������item��������0��ʼ
		add(choice);
		
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new ListenerTest2();
	}

}

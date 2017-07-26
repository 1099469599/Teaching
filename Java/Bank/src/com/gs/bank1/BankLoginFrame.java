package com.gs.bank1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class BankLoginFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 7389301369456276658L;
	private JTextField numberTxt;
	private JPasswordField pwdTxt;
	
	private MyBank myBank;
	
	public BankLoginFrame() {
		setTitle("��¼");
		myBank = new MyBank();
		setSize(400 ,400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(6,2));
		JLabel numberLbl = new JLabel("�˺�");
		numberTxt = new JTextField(10);
		JLabel pwdLbl = new JLabel("����");
		pwdTxt = new JPasswordField(10);
		JButton btn = new JButton("��¼");
		btn.setActionCommand("login");
		btn.addActionListener(this);
		add(numberLbl);
		add(numberTxt);
		add(pwdLbl);
		add(pwdTxt);
		add(new JLabel());
		add(btn);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * �������¼��ť��ʱ����Ҫ���ı��ļ��ж�ȡ���е��У�ÿһ�ж�Ӧһ��Account��������Account����ӵ�List�б��У�
	 * ���ұ�����ǰ�Ѿ���¼���˺ŵ�MyBank�У���������ÿһ�������� �ǻ��ڸñ�����˺�
	 * �ٴӸ��б��в����Ƿ���Ҫ��¼���˺ţ�����У���ѵ�ǰ�������أ���ʾ��������
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("login")) {
			String number = numberTxt.getText();
			String pwd = String.valueOf(pwdTxt.getPassword());
			Account account = myBank.query(number, pwd);
			if (account != null) {
				dispose();
				new BankMenuFrame(account);
			} else {
				JOptionPane.showMessageDialog(this.getParent(), "��������ȷ���˺ź����룬���û���˺ţ��뿪��", "�˺���Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}

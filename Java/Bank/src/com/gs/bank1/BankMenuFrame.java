package com.gs.bank1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class BankMenuFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 95449655659233103L;
	
	public static final String[] btnNames = {"����", "���", "��ѯ", "ȡ��", "ת��", "�˳�"};
	public static final String[] btnActions = {"openPanel", "savePanel", "query", "getPanel", "transferPanel", "exit"};
	
	private MyBank myBank;
	
	private BankOpenPanel openPanel;
	private BankSavePanel savePanel;

	public BankMenuFrame(Account currentAcount) {
		myBank = new MyBank();
		myBank.setCurrentAccount(currentAcount);
		setTitle("����");
		setSize(400, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		initWidgets();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void initWidgets() {
		JPanel panel = new JPanel(new GridLayout(btnNames.length, 1));
		for (int i = 0, len = btnNames.length; i < len; i++) {
			JButton btn = new JButton(btnNames[i]);
			btn.setActionCommand(btnActions[i]);
			btn.addActionListener(this);
			panel.add(btn);
		}
		add(panel, BorderLayout.WEST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		// ����û�����˿�����������ѿ��������ʾ���в��������ȷ�Ϻ�����Ҫ�Ӹ� ����л�ȡ�û���������ݣ�ֱ�ӰѸ�������װ��Account����
		// �ٵ���BankFile.save(Account account)׷�ӵ������ļ���
		if (action.equals("openPanel")) {
			openPanel = new BankOpenPanel(myBank);
			if (savePanel != null) {
				remove(savePanel);
				savePanel = null;
			}
			add(openPanel, BorderLayout.CENTER);
			// ****** �ر�ע�⣺����Ѿ���ĳ�������ӵ���ʾ�������У�������ڴ������ϵ��� validate������ʾ�µ������
			// �����Ӷ���������ô����������������֮��ͨ��ֻ����һ�� validate �����Ч�ʡ� 
			validate(); 
			// �����������������Ҫ��ʾ��� ��壬������󣬵������ʱ��Ҫ�ѵ�ǰ�˺ŵ�����������Ҵ�����List�б��аѴ��˺ŵ���Ϣ���£�
			// ������Ϻ������List�б�����д�뵽 �ļ� �У����ǣ�
		} else if (action.equals("savePanel")) {
			savePanel = new BankSavePanel(myBank);
			if (openPanel != null) {
				remove(openPanel);
				openPanel = null;
			}
			add(savePanel);
			validate();
			// ֱ�ӷ��ص�ǰ�Ѿ���¼���˻�����Ϣ
		} else if (action.equals("query")) {
			JOptionPane.showMessageDialog(this.getParent(), myBank.getCurrentAccount(), "�˺���Ϣ", JOptionPane.INFORMATION_MESSAGE);
		} else if (action.equals("getPanel")) {

		} else if (action.equals("transferPanel")) {

		} else if (action.equals("exit")) {
			System.exit(0);
		}
	}
	
	
}

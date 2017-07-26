package com.gs.qq.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.gs.bean.Account;
import com.gs.dao.AccountDAO;
import com.gs.dao.AccountDAOImpl;
import com.gs.qq.ui.common.CheckCode;
import com.gs.qq.ui.common.CheckCodeGenerator;
import com.gs.qq.ui.common.UIUtil;
import com.gs.qq.ui.listener.QQWindowListener;

public class RegisterFrame extends JFrame {
	
	private static final long serialVersionUID = -1846540928211488274L;
	
	private JTextField nicknameTxt;
	private JPasswordField pwdTxt;
	private JPasswordField conpwdTxt;
	private JTextField checkTxt;
	
	private String checkCodeStr;
	
	public RegisterFrame() {
		setSize(400,600);
		setTitle("ע��QQ�˺�");
		setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(14, 2));
		initWidget();
		addWindowListener(new QQWindowListener());
		UIUtil.setLookAndFeel();
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setVisible(true);
	}
	
	private void initWidget() {
		JLabel nicknameLbl = new JLabel("�ǳ�");
		nicknameTxt = new JTextField(30);
		JLabel pwdLbl = new JLabel("����");
		pwdTxt = new JPasswordField(30);
		JLabel conpwdLbl = new JLabel("ȷ������");
		conpwdTxt = new JPasswordField(30);
		JLabel checkLbl = new JLabel("��֤��");
		checkTxt = new JTextField(30);
		CheckCode checkCode = CheckCodeGenerator.getCheckCode();
		JLabel checkCodeLbl = new JLabel(new ImageIcon(checkCode.getBufImg()));
		checkCodeStr = checkCode.getCheckCode();
		JButton okBtn = new JButton("ע��");
		BtnListener listener = new BtnListener();
		okBtn.setActionCommand("reg");
		okBtn.addActionListener(listener);
		JButton cancelBtn = new JButton("ȡ��");
		cancelBtn.setActionCommand("cancel");
		cancelBtn.addActionListener(listener);
		add(nicknameLbl);
		add(nicknameTxt);
		add(pwdLbl);
		add(pwdTxt);
		add(conpwdLbl);
		add(conpwdTxt);
		add(checkLbl);
		add(checkTxt);
		add(checkCodeLbl);
		add(okBtn);
		add(cancelBtn);
	}
	
	class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String action = e.getActionCommand();
			if (action.equals("cancel")) {
				RegisterFrame.this.dispose();
			} else if (action.equals("reg")) {
				String nickname = nicknameTxt.getText();
				String pwd = new String(pwdTxt.getPassword());
				String conpwd = new String(conpwdTxt.getPassword());
				// TODO �ж����ݵĿ��ԣ����OK����ʵ����DAO���󣬱��浽���ݿ�
				if (nickname != null && !nickname.equals("")) {
					String number = String.valueOf(new Random().nextInt(999999999)); // ��Ҫ�ж����ݿ����Ƿ��Ѿ��и�number������У�����������һ��number
					Account account = new Account();
					account.setNumber(number);
					account.setNickname(nickname);
					account.setPwd(pwd);
					account.setGender("��");
					account.setHeadIcon("head");
					AccountDAO accountDAO = new AccountDAOImpl();
					Account a = accountDAO.add(account);
					if (a != null) {
						JOptionPane.showMessageDialog(RegisterFrame.this, "�ɹ�ע�ᣬ�˺�Ϊ��" + number);
					}
				}
			}
		}
		
	}

}

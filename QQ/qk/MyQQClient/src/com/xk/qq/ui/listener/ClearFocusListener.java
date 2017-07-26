package com.xk.qq.ui.listener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

import com.xk.bean.Account;

public class ClearFocusListener extends FocusAdapter {

	private JTextField txt;
	private Account account;
	
	public ClearFocusListener(JTextField txt) {
		this.txt = txt;
	}
	public ClearFocusListener(JTextField txt ,Account account){
		this.txt = txt;
		this.account = account;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		txt.setText("");
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object obj  = e.getSource();
		if(obj instanceof JTextField){
			JTextField txtName = (JTextField)obj;
			String name = txtName.getName();
			if(name.equals("ctn_Txt")){
				txt.setText("������QQ����/�ֻ�����/�ǳ�");
			}else if(name.equals("search_Txt")){
				txt.setText("��������ϵ�ˡ��������졢Ⱥ");
			}else if(name.equals("autograph_Txt")){
				txt.setText(account.getAutograph());
			}
		}
		
		
		
	}

	

	

}

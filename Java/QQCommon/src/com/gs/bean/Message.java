package com.gs.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * QQ��Ϣ�࣬�����з����ˣ������ˣ�����ʱ��ͷ��͵���Ϣ
 *
 */
public class Message implements Serializable{
	
	private static final long serialVersionUID = -2432452429819362347L;
	
	public static final int NORMAL_MSG = 1; // ��ͨ��Ϣ
	public static final int REQUEST_MSG = 2; // ������Ϣ
	public static final int REQUEST_REV_MSG = 3; // ����������Ϣ
	public static final int LOGOUT_MSG = 4; // �˳���Ϣ
	public static final int STATUS_CHANGE_MSG = 5;
	
	private int type; // ��Ϣ����
	private Account fromAccount;
	private Account toAccount;
	private Date sendTime;
	private String message;
	
	public Message() {
		
	}
	
	/**
	 * ʹ�ù��췽������һ����Ҫ���͵���Ϣ
	 * @param type
	 * @param fromAccount
	 * @param toAccount
	 * @param sendTime
	 * @param message
	 */
	public Message(int type, Account fromAccount, Account toAccount, Date sendTime, String message) {
		this.type = type;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.sendTime = sendTime;
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

package com.xk.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * QQ��Ϣ�࣬�����з����ˣ������ˣ�����ʱ��ͷ��͵���Ϣ
 *
 */
public class Message implements Serializable{

	@Override
	public String toString() {
		return "Message [type=" + type + ", sendTime=" + sendTime + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", message=" + message + "]";
	}
	private static final long serialVersionUID = -4996033880257787456L;
	
	public static final int NORMAL_MSG = 1; // ����������Ϣ
	public static final int REQUEST_MSG = 2; // ����������Ϣ
	public static final int REQUEST_REV_MSG = 3; // ���պ���������Ϣ
	public static final int LOGOUT_MSG = 4; // �˳�
	public static final int STATES_CHANGE = 5; // ״̬��Ϣ 
	public static final int DELETE_MSG = 6; 	//ɾ����Ϣ
	public static final int BLACKLIST_MSG = 7; // �������������Ϣ
	public static final int SHAKE_MSG = 8; // ���ڶ�����Ϣ
	
	private int type;				// ��Ϣ����
	private Date sendTime; 			// ������Ϣ��ʱ��
	private Account fromAccount;	// ������
	private Account toAccount;		// ������
	private String message; 		// ���յ���Ϣ
	
	public Message() {
		
	}
	
	public Message(int type,Date sendTime, Account fromAccount, Account toAccount, String message) {
		this.type = type;
		this.sendTime = sendTime;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.message = message;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

package com.gs.dao;

import java.util.List;

import com.gs.bean.Account;

public interface AccountDAO {
	
	public Account add(Account account);
	public Account query(Account account);
	/**
	 * �����û��˺������룬�������ݿ����Ƿ��и��˺ţ�����У��򷵻ش��˺�(������������������Ϣ)�����û�У��򷵻�null
	 * @param number
	 * @param pwd
	 * @return
	 */
	public Account query(String number, String pwd);
	/**
	 * ��ѯ���е��û�
	 * @return
	 */
	public List<Account> queryAll();
	
	/**
	 * ֱ��ͨ���˺Ų�����Ϣ
	 * @param number
	 * @return
	 */
	public Account query(String number);
	/**
	 * ��Ӻ��ѣ�ÿһ���������Լ����˺ţ��ڶ��������Ǻ��ѵ��˺�
	 */
	public void addFriend(String selfNumber, String number);
	
	/**
	 * �����Լ����˺�ȥ���Ҹ��˺ŵ����к���
	 * @param number
	 * @return
	 */
	public List<Account> queryFriends(String number);
	
	/**
	 * �������з����ߵĺ���
	 * @param number
	 * @return
	 */
	public List<Account> queryNotLeaveFriends(String number);
	
	/**
	 * �����û��˺��޸�״̬
	 * @param status
	 */
	public void updateStatus(String number, String status);

}

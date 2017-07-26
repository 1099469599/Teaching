package com.xk.dao;

import java.util.List;

import com.xk.bean.Account;

public interface AccountDAO {
	
	/**
	 *   // �����Ϣ�����ݿ⣬ע��ʱ�õ�
	 * @param status
	 */
	public Account add(Account account); // �����Ϣ�����ݿ⣬ע��ʱ�õ�
	
	/**
	 *   ��ѯ�Ƿ�������˺����� �� ��½ʱ�õ�
	 * @param status
	 */
	public Account query(String number,String pwd);  // ��ѯ�Ƿ�������˺����� �� ��½ʱ�õ�
	/**
	 *  ��ѯ�Ƿ�������˺ţ�����������һ���˺ţ�ע�������˺����õ�
	 * @param status
	 */
	
	public boolean query(String number);	// ��ѯ�Ƿ�������˺ţ�����������һ���˺ţ�ע�������˺����õ�
	/**
	 * �����û�������Ϣ
	 * @param status
	 */
	
	public void update(Account account);	// ������Ϣ��
	
	/**
	 * ��ѯ�����˺Ų��ŵ�list�б���
	 * @param status
	 */
	
	public List<Account> queryAll(String number);		// ��ѯ�����˺Ų�����list�б���
	/**
	 * �������˺��ǳ��������ݿ���û�������
	 * @param status
	 */
	
	public List<Account> queryAll(String number, String nickName); // �����˺��ǳ��������ݿ�������˺�
	/**
	 * �����˺Ų�ѯ�����
	 * @param status
	 */
	
	public Account queryFriend(String number);  // �����˺Ų�ѯ�����
	/**
	 * ��Ӻ���
	 * @param status
	 */
	
	public void addFriend(String selfNumber, String number); // ��Ӻ���
	/**
	 * ��ѯ�����б�
	 * @param status
	 */
	
	public List<Account> queryFroemds(String number); // ��ѯ�����б�
	
	/**
	 * �����ظ���Ӻ���
	 * @param status
	 */
	
	
	public boolean queryFriend(String number,String toNumber);
	
	/**
	 * ɾ������
	 * @param status
	 */
	
	public void deleteFriend(String number,String toNumber);
	
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
	
	public void updateStatus(String number,String status);
	
	/**
	 * �����������
	 * @param status
	 */
	
	public void addBlack(String selfNumber,String number);
	
	/**
	 * ��ѯ��������
	 * @param status
	 */
	public List<Account> BlackList(String number);
	
	
	/**
	 * �Ӻ���������ӻ�����ɺ���
	 * @param status
	 */
	
	public void deleteBalck(String number,String toNumber);
} 

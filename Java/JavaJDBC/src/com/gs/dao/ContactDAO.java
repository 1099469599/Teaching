package com.gs.dao;

import java.util.List;

import com.gs.bean.Contact;

public interface ContactDAO {
	
	/**
	 * ����id����ָ������ϵ��
	 * @param id
	 * @return
	 */
	public Contact queryById(int id);
	
	/**
	 * ����������ϵ��
	 * @return
	 */
	public List<Contact> queryAll();
	
	/**
	 * �����ϵ�ˣ������ӳɹ����򷵻ش���ϵ�ˣ����򷵻ؿ�
	 * @param contact
	 * @return
	 */
	public Contact add(Contact contact);
	
	/**
	 * ����idɾ����ϵ��
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * ������ϵ��
	 * @return
	 */
	public void update(Contact contact);
	
}

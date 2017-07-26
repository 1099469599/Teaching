package com.gs.test;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.gs.bean.Contact;
import com.gs.dao.ContactDAO;
import com.gs.dao.ContactDAOImpl;

public class ContactDAOTest {
	
	// JUnit ��Ԫ���Թ��ߣ�����д�õķ����Ƿ������ȷִ��
	// ����JDK��@Test�����һ������ �ǲ��Է���������û��main�������˷���Ҳ���� ������
	@Test
	public void testAdd() {
		ContactDAO contactDAO = new ContactDAOImpl();
		Contact contact = new Contact();
		contact.setName("bbb");
		contact.setPhone("13888888888");
		contact.setAddress("jx");
		contact.setCompany("bbb");
		contact.setCreateTime(new Date(Calendar.getInstance().getTimeInMillis()));
		contactDAO.add(contact);
	}
	
	@Test
	public void testQueryById() {
		ContactDAO contactDAO = new ContactDAOImpl();
		Contact contact = contactDAO.queryById(2);
		System.out.println(contact);
	}
	
	@Test
	public void testQueryAll() {
		ContactDAO contactDAO = new ContactDAOImpl();
		List<Contact> contacts = contactDAO.queryAll();
		for (Contact c : contacts) {
			System.out.println(c);
		}
	}
	
	@Test
	public void testUpdate() {
		ContactDAO contactDAO = new ContactDAOImpl();
		Contact contact = new Contact();
		contact.setId(1);
		contact.setName("AAA");
		contact.setPhone("15888888888");
		contact.setAddress("GZ");
		contact.setCompany("AAA");
		contact.setCreateTime(new Date(Calendar.getInstance().getTimeInMillis()));
		contactDAO.update(contact);
	}
	
	@Test
	public void testDelete() {
		ContactDAO contactDAO = new ContactDAOImpl();
		contactDAO.delete(2);
	}

}

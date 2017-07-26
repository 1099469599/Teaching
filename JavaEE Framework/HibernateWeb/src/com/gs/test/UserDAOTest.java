package com.gs.test;

import org.junit.Test;

import com.gs.bean.User;
import com.gs.bean.UserDetail;
import com.gs.dao.UserDAO;
import com.gs.dao.UserDAOImpl;
import com.gs.dao.UserDetailDAO;
import com.gs.dao.UserDetailDAOImpl;

import junit.framework.TestCase;

public class UserDAOTest extends TestCase {
	
	private UserDAO userDAO;
	private UserDetailDAO udDAO;
	
	@Override
	protected void setUp() throws Exception {
		userDAO = new UserDAOImpl();
		udDAO = new UserDetailDAOImpl();
	}
	
	@Test
	public void testQuery() {
		System.out.println(userDAO.queryById(1));
		System.out.println(udDAO.queryById(1));
	}
	
	/**
	 * ��������
	 */
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("test");
		user.setPwd("123456");
		UserDetail ud = new UserDetail();
		ud.setAddress("address");
		ud.setPhone("188");
		user.setUserDetail(ud);
		ud.setUser(user);
		userDAO.add(user);
	}
	
	@Test
	public void testDelete() {
		User user = new User();
		user.setId(13);
		/*UserDetail ud = new UserDetail();
		ud.setUser(user);
		user.setUserDetail(ud);*/
		userDAO.delete(user);
	}
	
	@Test
	public void testUpdate() {
//		User user = new User();
//		user.setId(14);
//		user.setName("14");
//		UserDetail ud = new UserDetail();
//		ud.setUser(user); // ���ö��������
//		ud.setAddress("14");
//		ud.setPhone("166");
//		user.setUserDetail(ud);
//		userDAO.update(user);
		// ���ϲ���userDetail��û��ʹ��update������insert�����Գ��ִ���user_detail�ظ�������
		User user = new User();
		user.setId(14);
		user.setName("14");
		user.setPwd("654321");
		UserDetail ud = new UserDetail();
		ud.setId(user.getId()); // ֻ����id������Ҫ���ö��������
		ud.setAddress("14");
		ud.setPhone("166");
		user.setUserDetail(ud);
		userDAO.update(user);
	}

}

package com.gs.service;

import com.gs.bean.User;
import com.gs.dao.UserDAO;
import com.gs.dao.UserDAOImpl;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public User queryByNamePwd(String name, String pwd) {
		return userDAO.queryByNamePwd(name, pwd); // �����ȡ���û��󣬻���Ҫ���û����ݽ��мӹ���������ڴ�service���������
	}

}

package com.gs.four;

/**
 * ������ģʽ�����Ӹó����࣬���ĳ����Ҫʵ�ֽӿ���Ĳ��ַ������������
 *
 */
public class UserServiceAdapter implements UserService {

	@Override
	public boolean login(User user) {
		return false;
	}

	@Override
	public boolean logout(User user) {
		return false;
	}

	@Override
	public User update(User user) {
		return null;
	}

	@Override
	public boolean inactive(User user) {
		return false;
	}
	
	@Override
	public boolean active(User user) {
		return false;
	}

	@Override
	public User register(User user) {
		return null;
	}

}

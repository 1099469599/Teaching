package com.gs.four;

public interface UserService {
	
	/**
	 * �û���¼�����������¼�ɹ�����true�����򷵻�false
	 * @param user
	 * @return
	 */
	public boolean login(User user);
	
	public boolean logout(User user);
	
	/**
	 * ���ݴ��ݽ������û���������û������ԣ������ظ��º��user����
	 * @param user
	 * @return
	 */
	public User update(User user);
	
	/**
	 * �Ѵ��ݽ�����user����Ϊ�Ƿ�״̬
	 * @param user
	 * @return
	 */
	public boolean inactive(User user);
	
	public boolean active(User user);
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public User register(User user);

}

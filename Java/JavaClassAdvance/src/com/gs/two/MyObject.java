package com.gs.two;

public class MyObject {
	
	private String id;
	
	public MyObject() {
		
	}
	
	public MyObject(String id) {
		this.id = id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	/**
	public String toString() {
		// getClass()��ȡһ��Class����
		// Class���getName()�������Ի�ȡ��ָ������������ȫ�޶���
		// hashCode()�������ش˶������ڴ��еĵ�ַ����ϣ�룩
		Class clazz = getClass();
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}
	*/
	
	/**
	 * ��дObject�����toString����
	 */
	public String toString() {
		return "MyObject id: " + id;
	}
	
	/**
	 * ��дequals��������Ҫ�����ж϶�������������Ƿ�һ�£����һ�£��򷵻�true�����򷵻�false
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; // ����������ͬ��Ҫ�ȽϵĶ���ָ��ͬһ�����ã�����ͬһ������
		}
		if (obj instanceof MyObject) { // �����Ҫ�ȽϵĶ������ڱ��࣬��ô�Զ��������е����Խ�������жϣ�����������ж�Ϊ�棬���ʾ��ͬһ������
			if (((MyObject) obj).getId().equals(this.getId())) {
				return true;
			}
		} else { // �����Ҫ�ȽϵĶ������ڱ��ֱ࣬�ӷ���false
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		MyObject obj = new MyObject("aa");
		MyObject obj1 = new MyObject("aa");
		MyObject obj2 = obj; // obj2��objָ��ͬһ������
		System.out.println(obj);
		System.out.println("obj == obj1: " + (obj == obj1)); // false
		System.out.println("obj == obj2: " + (obj == obj2)); // true
		String a = new String("aa");
		String b = new String("aa");
		String c = a;
		System.out.println("a == b: " + (a == b)); // false
		System.out.println("a == c: " + (a == c)); // true
		
		// δ��дequals����ֱ��ʹ�� == �ж�
		System.out.println("obj equals obj1: " + obj.equals(obj1)); // false==��true
		System.out.println("obj equals obj2: " + obj.equals(obj2)); // true
		
		// String����д�˼̳й�����equals������ ���ַ����е�ÿһ���ַ������ж�
		System.out.println("a equals b: " + a.equals(b)); // true
		System.out.println("a equals c: " + a.equals(c)); // true
	}

}

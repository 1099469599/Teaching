package com.gs.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.gs.bean.User;

public class SetTest {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("234"); // ʹ��add������ӵ�������
		set.add("123");
		set.add("345"); 
		set.add("123"); // Set����������ظ����ݣ�����ж���ظ����ݣ���ֻ�����һ��
		String[] strr = new String[]{"124","124","12"};
		for(int i = 0 ,len = strr.length; i< len; i++){
			set.add(strr[i]);
		}
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			String st = iter.next();
			System.out.println(st);
		}
		System.out.println("---------------");
		if (!set.isEmpty()) { // �жϼ����ڲ��Ƿ���Ԫ��
			Object[] strObj = set.toArray();
			for (int i = 0, size = set.size(); i < size; i++) { //��size��ȡԪ�ظ���
				System.out.println(strObj[i]);
			}
		}
		System.out.println("*********************************");
		// set.clear(); // ��ռ����ڵ�����Ԫ��
		set.remove("456"); // �Ӽ������Ƴ�ָ����Ԫ��
		if (set.contains("123")) { // �ж��Ƿ����ĳ��Ԫ��
			System.out.println("�����С�123��");
		}
		if (!set.isEmpty()) {
			Object[] strObj = set.toArray();
			for (int i = 0, size = set.size(); i < size; i++) { //��size��ȡԪ�ظ���
				System.out.println(strObj[i]);
			}
		}
		
		// ���������շ���
		System.out.println("***********************************");
		Iterator<String> ite = set.iterator(); // ��ȡ���������˵��������Զ�set�ڲ���Ԫ�ؽ���ѭ������
		while(ite.hasNext()) { // �жϵ��������Ƿ�����һ��Ԫ��
			String str = ite.next(); // ��ȡ�����������һ��Ԫ��
			System.out.println(str);
		}
		
		System.out.println("******************TreeSet******************");
		TreeSet<String> set1 = new TreeSet<String>();
		set1.add("234"); // ʹ��add������ӵ�������
		set1.add("123");
		set1.add("345"); 
		set1.add("123"); // Set����������ظ����ݣ�����ж���ظ����ݣ���ֻ�����һ��
		set1.last(); // ��ȡTreeSet�е���� 
		Iterator<String> ite1 = set1.iterator();
		while(ite1.hasNext()) {
			String str = ite1.next();
			System.out.println(str);
		}
		
		Set<User> set2 = new HashSet<User>();
		set2.add(new User("1003", "1003"));
		set2.add(new User("1001", "1001"));
		// Set<User> set3 = new TreeSet<User>();
		// set3.add(new User("1003", "1003")); // �������ָ��User������������������ӵ�TreeSet��
		// set3.add(new User("1001", "1001"));
		Iterator<User> set2Ite = set2.iterator();
		// Iterator<User> set3Ite = set3.iterator();
		while(set2Ite.hasNext()) {
			User user = set2Ite.next();
			System.out.println(user);
		}
//		while(set3Ite.hasNext()) {
//			User user = set3Ite.next();
//			System.out.println(user);
//		}
		
	}

}

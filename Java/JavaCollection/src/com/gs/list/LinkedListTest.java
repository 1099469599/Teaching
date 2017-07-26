package com.gs.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
	
	public static void main(String[] args) {
		List<Integer> numbers = new LinkedList<Integer>();
		numbers.add(1001);
		numbers.add(1002);
		numbers.add(1001);
		numbers.add(1003);
		for (int i = 0, size = numbers.size(); i < size; i++) {
			Integer num = numbers.get(i); // get(int index)��ȡָ�������ϵ�Ԫ��
			System.out.println(num);
		}
		System.out.println("set 1001***********");
		numbers.set(2, new Integer(10001));
		for (int i = 0, size = numbers.size(); i < size; i++) {
			Integer num = numbers.get(i); // get(int index)��ȡָ�������ϵ�Ԫ��
			System.out.println(num);
		}
		System.out.println("remove **************");
		if (numbers.contains(new Integer(1003))) {
			numbers.remove(new Integer(1003)); // �Ƴ�ָ���Ķ���
		}
		numbers.remove(1); // ���������Ƴ�Ԫ��
		for (int i = 0, size = numbers.size(); i < size; i++) {
			Integer num = numbers.get(i); // get(int index)��ȡָ�������ϵ�Ԫ��
			System.out.println(num);
		}

		System.out.println("1001��λ��*****");
		System.out.println(numbers.indexOf(new Integer(1001)));// �������򷵻�-1�������򷵻ظ�Ԫ�ض�Ӧ������
		
		numbers.clear();
		System.out.println("clear *********");
		if (!numbers.isEmpty()) {
			Iterator<Integer> ite = numbers.iterator();
			while (ite.hasNext()) {
				Integer num = ite.next();
				System.out.println(num);
			}
		}
	}

}

package com.gs.stack;

import java.util.Iterator;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("item1");
		stack.push("item2");
		stack.push("item3");
		
		String item = stack.pop(); // ����ջ���˵������Ƴ���
		System.out.println(item);
		int index = stack.search("item1"); // contains�����Ƿ������Ԫ�أ���search���ظ�Ԫ�ص�����
		System.out.println(index);
		System.out.println("************************");
		stack.add(0, "item0"); // ��0��ʼ����ջ�׵�ջ��
		
		if (!stack.isEmpty()) {
			System.out.println(stack.peek()); // ѡ��ջ����Ԫ�أ������������Ƴ���
			Iterator<String> ite = stack.iterator();
			while (ite.hasNext()) {
				System.out.println(ite.next());
			}
		}
		
	}
}

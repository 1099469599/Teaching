package com.gs.datastructure;

public class MyStack<E> {
	
	private int size;
	private int currPos = -1; // ��¼��ǰ�������ĸ�����
	private Object[] elements;
	
	public MyStack() {
		elements = new Object[10];
	}
	
	public void push(E e) {
		// TODO ��������
		elements[++currPos] = e;
		size++;
	}
	
	public E pop() {
		E e = (E) elements[currPos];
		currPos--;
		size--;
		return e;
	}
	
	public E peek() {
		return (E) elements[currPos];
	}
	
	public int size() {
		return size;
	}

}

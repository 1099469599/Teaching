package com.gs.datastructure;

public class MyQueue<E> {
	
	private int size;
	private int currPos = -1; // �����洢��β������
	private Object[] elements;
	
	public MyQueue() {
		elements = new Object[10];
	}
	
	public void enque(E e) {
		elements[++currPos] = e;
		size++;
	}
	
	public E deque() {
		E e = null;
		if (currPos > -1) {
			e = (E) elements[0];
			// �����Ԫ��һ��һ����ǰ��
			for (int i = 0; i < size - 1; i++) {
				elements[i] = elements[i+1];
			}
			size--;
		} else {
			// �׳��쳣
		}
		return e;
	}
	
	public int size() {
		return size;
	}

}

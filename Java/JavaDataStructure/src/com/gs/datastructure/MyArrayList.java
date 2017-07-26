package com.gs.datastructure;

import java.util.Arrays;

public class MyArrayList<E> {
	
	private static final int growth = 10;
	
	private int initSize = 10; //��ʼ��С 
	
	private int actualSize = initSize; // ʵ�ʴ�С
	
	private int size; // ����˶��ٸ�Ԫ��
	
	private Object[] elements;
	
	public MyArrayList() {
		elements = new Object[initSize];
	}
	
	public void add(E e) {
		if (size == actualSize) {
			// TODO ���������������´���һ������������elements����ʱ����Ҫ��ԭ������copy���µ�������
			actualSize = actualSize + growth;
			elements = Arrays.copyOf(elements, actualSize);
		}
		elements[size] = e;
		size++;
		
	}
	
	public E get(int index) throws ArrayIndexOutOfBoundsException {
		if (index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("ֻ��" + size + "��Ԫ�أ��������ֻ��Ϊ" + (size - 1));
		}
		return  (E) elements[index];
	}
	
	public E remove(int index) {
		if (index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("ֻ��" + size + "��Ԫ�أ��������ֻ��Ϊ" + (size - 1));
		}
		E e = (E) elements[index];
		// ɾ��Ԫ�أ��ƶ�Ԫ�ص����⣩
		if (index < size - 1) {
			// ������Ҫ�ƶ�Ԫ�ص�λ�ã���ɾ��Ԫ�غ��������Ԫ��˳����ǰ��һ��λ��
			for (int i = index; i < size - 1; i++) {
				elements[i] = elements[i + 1];
			}
		}
		size--;
		return  e;
	}
	
	public int size() {
		return size;
	}

}

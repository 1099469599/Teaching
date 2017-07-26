package com.gs.datastructure;

public class MyLinkedList<E> {
	
	private int size; // ����˶��ٸ�Ԫ��
	
	private Element head; 	// ��һ������
	
	class Element {
		
		private E self; 	// ��һ��
		private Element previous; 	// ��һ��
		private Element next;		// ��һ��
		public E getSelf() {
			return self;
		}
		public void setSelf(E self) {
			this.self = self;
		}
		public Element getPrevious() {
			return previous;
		}
		public void setPrevious(Element previous) {
			this.previous = previous;
		}
		public Element getNext() {
			return next;
		}
		public void setNext(Element next) {
			this.next = next;
		}
		
	}
	
	public void add(E e) {
		if (head == null) {
			head = new Element();
			head.setSelf(e);
			size++;
		} else {
			Element currentElement = head; // ͷ�ڵ�
			for (int i = 0; i < size - 1; i++) {
				currentElement = currentElement.getNext(); // ͷ�ڵ���һ��λ�ø�ֵ��ͷ�ڵ�
			}
			Element ele = new Element();
			ele.setSelf(e);
			currentElement.setNext(ele);
			ele.setPrevious(currentElement);
			size++;
		}
		
	}
	
	public E remove(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException("Խ��");
		}
		Element currentEle = head;
		if (index == 0) {
			head = head.getNext();
		} else {
			for (int i = 0; i < index; i++) {
				Element previousEle = null;
				if (i == index - 1) {
					previousEle = currentEle;
				}
				currentEle = currentEle.getNext(); // 
				Element nextEle = currentEle.getNext();// ��һ������һ��
				if (previousEle != null) {
					previousEle.setNext(nextEle);
				}
			}
		}
		size--;
		return currentEle.getSelf();
	}
	
	public void removeAll() {
		size = 0;
	}
	
	public E get(int index) throws ArrayIndexOutOfBoundsException {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException("Խ��");
		}
		Element currentEle = head;
		for (int i = 0; i < index; i++) {
			currentEle = currentEle.getNext();
		}
		return currentEle.getSelf();
	}
	
	public int size() {
		return size;
	}

}

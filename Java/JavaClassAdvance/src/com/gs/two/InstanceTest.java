package com.gs.two;

public class InstanceTest {
	
	public static void test(InstanceOne instance) {
		instance.one();
	}
	
	public static void main(String[] args) {
		InstanceOne one = new InstanceOne();
		one.one(); // ���ø����one����
		InstanceTwo two = new InstanceTwo();
		two.one(); // ������������д��one����
		// �������one����InstanceOne�Ķ����򷵻�true�����򷵻�false
		if (one instanceof InstanceOne) {
			System.out.println("one��InstanceOne���ʵ��");
		}
		if (two instanceof InstanceTwo) {
			System.out.println("two��InstanceTwo���ʵ��");
		}
		// InstanceOne�Ǹ��࣬�൱�ڸ���Χ���������ͣ�
		// InstanceTwo�����࣬���൱��С��Χ���������ͣ����಻��ֱ��ת�����������
		// ���������ʹ��ǿ������ת��������׶β��ᱨ������ʱ����Exception in thread "main" java.lang.ClassCastException
		// java.lang.ClassCastException ����ת���쳣
		//InstanceTwo three = (InstanceTwo) new InstanceOne(); 
		// three.one();
		InstanceOne four = new InstanceTwo(); // �൱��С��Χת��Ϊ��Χ����
		// �ø�������������Ķ����ó���������������Ķ��� �ýӿ���������ʵ������� ���õķ�����������ķ�������ʵ������ķ���
		four.one(); // ������������д��one����
		
		// four.two(); // ���ʲ������������ԭ����Ϊfour�������ɸ��������ģ�four����ֻ��ȥʹ�ø����Ѿ������ķ�����������ʹ�����Լ��������ķ���
		((InstanceTwo) four).two(); // ��һ�еĽ��������ǿ�ưѸ����������������ת��Ϊ����
		
		if (four instanceof InstanceOne) {
			System.out.println("��InstanceOne��������InstanceTwoʵ������four����������InstanceOne���͵�");
		}
		if (four instanceof InstanceTwo) {
			System.out.println("��InstanceOne��������InstanceTwoʵ������four����������InstanceTwo���͵�");
		}
		
		/**
		 * ����Ը�����Ϊ��ʽ����������ø÷���ʱ���ݵ�ʵ�ο���Ϊ������������
		 * 
		 * ͨ��һ����������ʽ�������ø��࣬������࣬��ӿڡ�����ʵ��ʱ�����ø��౾������࣬ �������ʵ���࣬�ӿڵ�ʵ����
		 */
		test(one);
		test(four);
	}

}

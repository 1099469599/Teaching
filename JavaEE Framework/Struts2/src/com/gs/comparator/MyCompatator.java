package com.gs.comparator;

import java.util.Comparator;

public class MyCompatator implements Comparator<Integer> {

	/**
	 * ��ʾ��ָ�����͵����ݽ�������Ƚ�
	 * �����Integer���ͣ���ֱ�ӱȽϴ�С����һ������ - �ڶ���������ֵ�����==0��������������ȣ����>0�����һ���������ڵڶ������������<0�����һ������С�ڵڶ�������
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2; // == 0 ��ȣ� >   o1 > o2  < o1 < o2
	}

}

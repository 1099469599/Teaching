package com.gs.test;

import com.gs.PackageTest;
// import com.gs.test1.PackageTest; // �г�ͻ

/**
 * ��������˲�ͬ����ͬ�����࣬������������
 * 1�����һ������Դ������һ������һ������Դ�ڱ��������İ�����ôʵ������Դ���ⲿ������
 * 2)��������඼��Դ������������ͬ�İ��������׶α���˵����ͬ�����������������г�ͻ��
 * 		���Բ����������룬���ȷʵҪ�õ�ͬ����һ���࣬Ӧ����ʵ����ʱʹ��ȫ�޶���
 */
public class PackageTest2 {

	public static void main(String[] args) {
		PackageTest pt = new PackageTest(); // com.gs.PackageTest
		PackageTest pt1 = new PackageTest(); // com.gs.PackageTest
		com.gs.test1.PackageTest pt2 = new com.gs.test1.PackageTest();
	}
}

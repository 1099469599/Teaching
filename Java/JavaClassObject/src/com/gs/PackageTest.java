package com.gs;

import com.gs.test.PackageTest2; // PackageTest2��Դ��������������Ҫ���е���������������*��ʾ�˰��ڵ�������

/**
 * package com.gsָ���������İ�
 * com.gs.PackageTest   ���ȫ�޶���  ��������.������ 
 * 
 * java.lang���ڵ�������Ĭ�ϵ�����
 * java.lang�¾��� �õ����ࣺObject, String, Math, Byte, Double, Boolean
 *
 *	��*�ű�ʾĳ�����ڵ������࣬���� ������δʹ�õ����࣬�����ʱ�����������Ӱ����������
 *	Ϊʲô�أ�Java������ػ��ƣ���ʵ����ĳ�����ʱ�򣬲Ż�Ѹ�����ص��ڴ�
 */
public class PackageTest {
	
	public PackageTest() {
		System.out.println("com.gs.PackageTest");
	}
	
	public static void main(String[] args) {
		PackageTest1 p = new PackageTest1();
		PackageTest2 p1 = new PackageTest2(); // Ҳ����ʹ��ȫ�޶���
	}

}

package com.gs.reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class BasicTest {
	
	@Test
	public void testBasic() {
		Basic basic = new Basic();
		basic.test();
	}
	
	@Test
	public void testBasic1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = Class.forName("com.gs.reflect.Basic"); // �Ѵ����������������ص�JVM�������
		Basic b = (Basic) clazz.newInstance(); // ͨ��Class���������ʵ��
		b.test();
	}
	
	@Test
	public void testFields() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Basic b = new Basic("001", "001", 10);
		Class clazz = b.getClass();
		Field field = clazz.getField("age"); // getFieldͨ�����������������ȡ�����Զ�Ӧ��Field�࣬�˷���ֻ�ܻ�ȡpublic������
		System.out.println(field.getName());
		
		Field field1 = clazz.getDeclaredField("id"); // getDeclaredField���Ի�ȡ�κ����ε�����
		System.out.println(field1.getName());
		
		// ��ͨ��������������ȡ
		Field[] fields = clazz.getFields(); // ֻ�ܻ�ȡpublic���ε�����
		for (Field f : fields) {
			System.out.println(f.getName());
			System.out.println(f.get(b)); // get(Object obj)��ʾȥ��ȡָ�������ϵ�����ֵ
		}
		
		Field[] fields1 = clazz.getDeclaredFields(); // ���Ի�ȡ�������η�������
		for (Field f : fields1) {
			f.setAccessible(true); // ���������Ƿ���Ա����ʣ�����˽��������˵��Ĭ��Ϊfalse
			if (f.getName().equals("id")) {
				f.set(b, "002"); // �����id�������ֵ �ĳ�002
			}
			System.out.println(f.getName());
			System.out.println(f.get(b));
		}
	}
	
	@Test
	public void testMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Basic b = new Basic("001", "001", 20);
		Class clazz = Basic.class;
		Method method = clazz.getMethod("method", String.class, int.class); // ָ��method�����Ĳ��������ͣ� û�в�����null
		System.out.println(method.getName());
		System.out.println(method.getModifiers()); // �������η���Ӧ��int����ֵ ,public 1, private, 2 protected 4 final 16, static 8, abstract 1024, infterface 512
		System.out.println(method.getReturnType()); // ��ȡ����ֵ������
		System.out.println(method.getParameterCount()); // ��ȡ��������
		Class[] clazzs = method.getParameterTypes();	// ��ȡ����
		for (Class c : clazzs) {
			System.out.println(c.getName());
		}
		
		Method method1 = clazz.getDeclaredMethod("method1", null); // ��ȡ�������η��ķ���
		
		method.invoke(b, "1001", 20); // ʹ��method���invoke���������Զ�̬�ص�������������ⷽ������Ҫָ�����ĸ������ϵ��ã�����ֵҲ��Ҫָ��
		method1.setAccessible(true); // ��ʾ���÷���Ȩ�ޣ����Է���˽�з���
		method1.invoke(b, null);
		
		Constructor[]  cc = clazz.getConstructors(); //   ����һ�� Constructor ��������ӳ�� Class ��������ʾ�����ָ���������췽����
		for (Constructor c : cc) {
			System.out.println(c.getName());
			System.out.println(c.getParameterCount()); // ��ȡ��������
			// c.newInstance(null) // ʹ��newInstance����ʵ��������
		}
		
	}
	
	@Test
	public void testArray() {
		int[] a = new int[]{10, 11, 12};
		System.out.println(Array.get(a, 2));
		String[] str = (String[]) Array.newInstance(String.class, 10); // ��̬�ش������飬��һ�������Ǵ������������������ͣ��ڶ�������������ĳ���
		str[0] = "aaaa";
		System.out.println(str[0]);
	}

}

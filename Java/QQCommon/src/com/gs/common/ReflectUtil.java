package com.gs.common;

import java.lang.reflect.Field;

public class ReflectUtil {
	
	/**
	 * ��ָ����Ķ�����ȥ��ȡָ�����Ƶ����Ե�ֵ
	 * @param clazz
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Object getFieldValue(Class<?> clazz, Object obj, String fieldName) {
		try {
			Field field = clazz.getDeclaredField(fieldName); // ��ȡ�������������ԣ�����private
			field.setAccessible(true); // �������Կɷ��� 
			return field.get(obj); // ��ָ�������ϻ�ȡ�����Ե�ֵ 
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

}

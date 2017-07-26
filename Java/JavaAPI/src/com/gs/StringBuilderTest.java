package com.gs;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abc");
		StringBuilder sb1 = sb.append("abc");
		System.out.println(sb1);
		
		System.out.println("String��StringBuilder�����ܱȽ�");
		long startTime = System.currentTimeMillis(); // ������ȡ��ǰ��ʱ��ĺ���ֵ�������1970��1��1��0��0�ֵ�ʱ���
		String a = "";
		for (int i = 0; i < 10000; i++) {
			a = a + "abc"; // 0ms
		}
		long endTime = System.currentTimeMillis();
		System.out.println("'a' + 'b' + 'c' time: " + (endTime - startTime));
		String b = "";
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			String c = "abc";
			b = b + c;
		}
		// a = b + c + d; // ���ַ��������String a = "abc" + "bcd" + "cdf";����
		long endTime1 = System.currentTimeMillis();
		System.out.println("a + b + c time: " + (endTime1 - startTime1));
		StringBuilder f = new StringBuilder("abc");
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			f.append("abc");
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("stringbuilder time: " + (endTime2 - startTime2));
		StringBuffer h = new StringBuffer("abc");
		long startTime3 = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			h.append("abc");
		}
		long endTime3 = System.currentTimeMillis();
		System.out.println("stringbuffer time: " + (endTime3 - startTime3));
	}

}

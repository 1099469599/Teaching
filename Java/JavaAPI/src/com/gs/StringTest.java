package com.gs;

public class StringTest {
	
	public static void main(String[] args) {
		String a = "abc";
		String b = new String("abc");
		String c = new String("abc");
		System.out.println("a == b: " + a == b); // false
		System.out.println("b == c: " + b == c); // false
		// ʹ��equals�����ж��ַ����Ƿ���� 
		System.out.println("a equals b: " + a.equals(b)); // true
		System.out.println("b equals c: " + b.equals(c)); // true
		// �����ִ�Сд������ж�
		String aa = "Abc";
		String bb = "abc";
		System.out.println("aa equals ignore case bb: " + aa.equalsIgnoreCase(bb));
		// �ַ��������ӣ�ʹ��+, ʹ��concat()����Ҳ���Խ������Ӳ���
		String d = a + b;
		System.out.println("a + b: " + d);
		System.out.println("a.concat(b): " + a.concat(b));
		// �ַ����Ľ�ȡ abcdefg��ֻ��Ҫǰ3���ַ�
		String e = "abcdefg";
		System.out.println(e.substring(0)); // abcdefg substring(int beginIndex)��ʾ��beginIndexָ����������ʼ��ȡ�ַ���һֱ���ַ����Ľ�β
		System.out.println(e.substring(4)); // efg
		System.out.println(e.substring(0, 3)); // substring(int beginIdex, int endIndx)��ʾ��beginIndex��ʼ��ȡ������beginIndex��,��endIndex������������endIndex��
		// ��Сдת��
		String f = "AbcD";
		String ff = f.toLowerCase(); // ת����Сд
		String fff = f.toUpperCase(); // ת���ɴ�д
		System.out.println("lower case: " + ff + ", upper case: " + fff);
		// ��ȡָ���������ַ�
		String g = "abcdefg";
		char gg = g.charAt(2);
		System.out.println("char at 2: " + gg);
		// ��ȡ�ַ����ĳ��ȣ�length()
		String h = "abc";
		System.out.println("length of abc: " + h.length());
		// �ж��Ƿ���ĳ���ַ�������startsWith, �ж��Ƿ���ĳ���ַ�����β endsWith�� ����true��false
		String i = "Hello, ���";
		if (i.startsWith("Hello")) {
			System.out.println("�ַ���i��Hello��ͷ�� " + i);
		}
		// �����ַ������Ƿ����ĳ���ַ��������ظ��ַ����ַ����е�������
		String j = "abcdefg";
		int index = j.indexOf("cde"); // ���ĳ���ַ����ڣ��򷵻ظ��ַ�����������������ڣ��򷵻�-1
		System.out.println("b �� abcdefg�е������� " + index);
		// ����ĳ���ַ���������ָ���ַ����е����һ�ε�λ��,�������򷵻�-1
		String k = "abcdbc";
		int lastIndex = k.lastIndexOf("b");
		System.out.println("last b in abcdbc: " + lastIndex);
		// �ж��ַ����Ƿ�Ϊ�� isEmpty()
		String L = ""; // ���ַ�����ʾû���κε��ַ����ո��ǿմ�
		System.out.println("L is empty: " + L.isEmpty());
		// �ַ����ķָ�
		String m = "ab,bc,cd,de";
		String[] mm = m.split(",");
		for (int ii = 0, len = mm.length; ii < len; ii++) {
			System.out.println(mm[ii]);
		}
		// �ַ������滻
		String n = "ABcdefgg  ";
		String nn =n.replaceAll("gg  ", "a");
		System.out.println(nn);
		// ȡ���ո������ȡ���ַ�����ǰ��ո��м���ֵĿո񲻶�
		String o = " a  aa ";
		String oo = o.trim();
		System.err.println(oo);
		
	}

}

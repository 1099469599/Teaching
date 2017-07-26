package com.gs;

public class ThrowExceptionTest {
	
	public static void test() throws MyException {
		ThrowException te = new ThrowException();
		// te.test();
	}
	
	public static void test1() {
		ThrowException te = new ThrowException();
		try {	
			te.test1();
		} catch(MyException e) {
			System.out.println(e.getMessage());
			System.out.println("��catch���������쳣");
		}
	}
	
	public static void test2() {
		ThrowException te = new ThrowException();
		try {
			te.add(-1, 1);
		} catch (MathException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
			e.getStackTrace();
		} finally {
			System.out.println("finally"); // һ���ᱻִ�е��Ĵ��� 
		}
	}
	
	public static void main(String[] args) throws MyException {
		test();
		test1();
		test2();
	}

}

package com.gs;

public class ThrowException {
	
	// throws�׳��쳣������
	public void test() throws MyException {
		// throwΪ�׳��쳣
		throw new MyException("MyException�쳣����");
	}
	
	public void test1() throws MyException {
		throw new MyException("MyException�쳣����");
	}
	
	/**
	 * �����׳�����쳣
	 * @param a
	 * @param b
	 * @return
	 * @throws MathException
	 * @throws MyException
	 */
	public int add(int a, int b) throws MathException, MyException {
		if (a <= 0 || b <= 0) {
			throw new MathException("����������������������"); // һ�����쳣�׳�������Ĵ���Ͳ���ִ��
		}
		if (a == -1) {
			throw new MyException();
		}
		return a + b;
		// throw new MathException(); // return�󷽷�ִ����ϣ��������׳��쳣
	}

}

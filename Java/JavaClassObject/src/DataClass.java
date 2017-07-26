/**
 * �����������ͣ��жϿ���==�����Ƕ���
 * ��Ӧÿһ�������������ͣ�Java�ṩ�����Ӧ���࣬����������������Ӧ�İ�װ��
 * 
 * ���������������װ�඼����ֱ�Ӹ�ֵ����ֵ���
 * 
 * ���������������װ���Ϳ���ֱ���� == �����ж�
 * 
 * ��װ���ṩ�˺ܶ෽�������ȡ������������ֵ�ķ����������ô�������ķ�ʽʵ��������
 * 
 * Integer.valueOf()
 * Integer.parseInt()���԰��ַ���ת��Ϊ���֣����Ǹ��ַ�������ֻ�������֣�����������ַ���
 * ���׳�Exception in thread "main" java.lang.NumberFormatException�����ָ�ʽ���쳣��
 *
 * byte Byte byteValue()
 * int Integer intValue()
 * short Short shortValue()
 * long Long longValue()
 * float Float floatValue()
 * double Double doubleValue()
 * char Character charValue()
 * boolean Boolean booleanValue()
 *
 */
public class DataClass {

	public static void main(String[] args) {
		byte a = 10;
		int b = 10;
		short c = 10;
		long d = 10;
		float e = 10.f;
		double f = 10.0;
		char g = 'A';
		boolean h = true;
		
		Byte aa = 10;
		Byte aaa = new Byte((byte)10);
		Integer bb = 10;
		Integer bbb = new Integer(10);
		Short cc = 10;
		Long dd = 10L;
		Float ee = 10.f;
		Double ff = 10.0;
		Character gg = 'A';
		Character ggg = new Character('A');
		Boolean hh = true;
		Boolean hhh = new Boolean(false);
		
		System.out.println("byte a = " + a);
		System.out.println("Byte aa = " + aa);
		System.out.println("int b = " + b);
		System.out.println("Integer bb = " + bb);
		
		System.out.println("byte a == Byte aa: " + (a == aa));
		System.out.println("long d == Long dd�� " + (d == dd));
		System.out.println("char g == Character gg�� " + (g == gg));
		
		System.out.println(aa.byteValue());
		System.out.println(ff.doubleValue());
		System.out.println(gg.charValue());
		
		String str = "123";
		int strInt = Integer.valueOf(str);
		int strInt1 = Integer.parseInt(str);
		System.out.println("strInt = " + strInt + " strInt1 = " + strInt1);
	}

}

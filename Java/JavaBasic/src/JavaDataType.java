public class JavaDataType {
		/**
			��ʽ����ת����С��Χת��Χ
			byte: 1byte 8bit
			short: 2byte 16bit
			int: 4byte 32bit
			long: 8byte 64bit
			float: 4byte 32bit
			double: 8byte 64bit
			char: 2byte 16bit
			boolean: 1byte 8bit true false
			
			��ʽ����ת����ǿ������ת��������Χ����ת��ΪС��Χ���ͣ����ܶ�ʧ����
			
			��������ʱ������������ж���
			byte,short,char�͵�ֵ������int��
			����һ��������Ϊlong�ͣ����Ϊlong��
			����һ��������Ϊfloat�ͣ����Ϊfloat��
			����һ��������Ϊdouble�ͣ����Ϊdouble��

		*/
		public static void main(String[] args) {
				int a = 100;
				int b = 100;
				float c = 1.0f; // ֱ��һ��С��λ����Ĭ��Ϊdouble���͵ģ������ֵ��float���ͣ��ں����f
				double d = 2.0;
				char e = 'A';
				boolean f = true;
				boolean g = false;
				long h = 10000;
				byte i = 127; 
				// ��׼������System.out.println������+������ص��ַ�������������
				System.out.println("a = " + a + " b = " + b + " c = " + c + "\n"
														+ "d = " + d + " e = " + e + " f = " + f + "\n"
														+ "g = " + g + " h = " + h + " i = " + i); 
														
				// int j = 1000000000000000; // �����������int���ʹ洢����,����long���ʹ洢��long�������ݺ�����üӸ�L
				long k = 1000000000000000L;
				
				byte L = 127; // byte => short => int => long => double��float
				int m = L;
				long n = m;
				double O = n;
				float p = n;
				
				double q = k;
				float r = k; // int longת����float���ͻᶪʧ����
				System.out.println("L = " + L + " m = " + m + " n = " + n + " O = " + O 
														+ " p = " + p + " q = " + q + " r = " + r);
														
				int s = 127;
				byte t = (byte) s;
				System.out.println("s = " + s + " t = " + t);// byte�洢�ķ�Χ��-128~127�������128����byte���ͣ����������󣬱����-128
				
				byte  bb = 50;
				char  cc = 'a';
				short ss = 1024;
				int   ii = 50000;
				float ff = 5.67f;
				double dd = .1234; // 0.1234 => .1234
				System.out.println("result = " + ((ff * bb) + ( ii / cc )-(dd * ss)));
				
				System.out.println("" + 'a' + 1); // ""���ַ�����"" + 'a' => �ַ���"a"���� "a" + 1 => �ַ���"a1"
				
				String str = "ˢ�ҵο�";
				System.out.println("Hello " + "��ã�"); // + ���ַ�����������
				System.out.println(str);
				System.out.println("̩���" + str);
				// a+=a-a*2 =>    a = a + (a - a * 2)
				int xx = 10;
				xx += xx - xx * 2;
				System.out.println(xx);
				
				// instanceof �����ж�ĳ�������Ƿ�Ϊĳ�����ʵ��
				Person person = new Person();
				Car car = new Car();
				if (person instanceof Person) {
					System.out.println("person����ΪPerson���ʵ��");
				} else {
					System.out.println("person������Person���ʵ��");
				}
				if (car instanceof Car) {
					System.out.println("car����ΪCar���ʵ��");
				} else {
					System.out.println("car������Car���ʵ��");
				}
				
				boolean isBook = true;
				boolean isBook1 = false;
				// ���������ж�
				if (isBook & isBook1) {
				}
				// ���ǰ�����isBookΪ�٣�����������Ϊ�٣����治���ж�
				// ���ǰ��Ϊ�棬�����жϺ����isBook1
				if (isBook && isBook1) {
				}
				// ���������ж�
				if (isBook | isBook1) {
				}
				// ���ǰ���isBookΪ�棬����������Ϊ�棬���治���ж�
				// ���ǰ���Ϊ�٣������жϺ����isBook1
				if (isBook || isBook1) {
				}
				
				System.out.println(10 > 20 ? "10 > 20" : "10 < 20");
		}
}

class Person {
	
}

class Car {
	
}
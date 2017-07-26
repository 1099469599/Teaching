/**
 * ��Ա���������ﶨ��ı���
 * 	ʵ������
 * 		ͨ������ȥ���õı�������ʵ��������ֻ��ͨ��������ʣ�����ͨ���������� 
 * 	���������̬������
 * 		��������ǰ�� static �ؼ��֣�ͨ���������ʡ� ��Ҫͨ������������
 * 		static:��ʾ��̬��������ͨ������������
 * 		��̬���������ж������
 * 
 * �ֲ��������ڷ����ڲ�����ı�������Ҫ��ʼ��
 * 
 * �������壺final, ����ֻ�ܱ�ʹ�ã��������޸ģ��ô�д�����������ʣ���_����
 * 	��������static���η�����ʾ��̬������ֱ�����������ʣ�����ʹ�ö�����ʣ�ͨ�����ã�
 */
public class Variable {
	
	String name;
	int age;
	int height;
	int weight;
	
	static char gender;
	
	final int DEFAULT_AGE = 20;
	static int DEFAULT_HEIGHT = 180;
	
	public static void main(String... args) {
		Variable v = new Variable();
		v.name = "С��";
		v.age = 20;
		// v.gender = 'A'; ��Ҫ�ö������ static���εľ�̬����
		Variable.gender = 'B';
		Variable v1 = new Variable();
		v1.name = "С��";
		v1.age = 19;
		System.out.println(Variable.gender);
		System.out.println(v.gender + " " + v1.gender);
		v.gender = 'A';
		System.out.println(v.gender + " " + v1.gender);
		System.out.println("default age: " + v.DEFAULT_AGE);
		System.out.println("static default height: " + v.DEFAULT_HEIGHT);
		System.out.println("static default height: " + Variable.DEFAULT_HEIGHT);
	}

}


/**
 * 
 * 1�����췽��������ʵ��������
 * 	public ������() {
 * 
 * 	}
 * 
 * 	public ������(��ʽ����) {
 * 
 * 	}
 * 
 * 	ͨ����������(��ʽ����)���ж��Ƿ�Ϊͬһ����������������ֵ���ͣ�����в�ͬ�����ʾ��ͬ�ķ��� : ��������
 * 
 * 	�޲ι��췽����new ������(); ���û��ָ���޲ι��췽������JavaĬ�ϴ���һ���޲ι��췽��
 * 	�вι��췽����new ������(ʵ���б�);
 * 
 * 	����Զ������вεĹ�����������Ҫ�ֶ�д���޲ι�������JVM��ʱ�޷��Զ������޲ι�����
 * 
 * 	this�ؼ��ֱ�ʾ�౾��thisȥ����ĳ��ʵ����������ʾֱ��ʹ�ñ�������ĳ��ʵ����������ò�Ҫ��this���ʾ�̬����
 *
 *	2����ͨ��������������õķ�������Ա������������ָ������ֵ����
 *		ʵ��������ֻ��ͨ�����������ʣ�����static�ؼ�������
 *
 *		�෽������static�ؼ������Σ����ڷ�������ǰ��ͨ���������ʣ�����Ҳ���Է��ʣ���Ҫ��ô�ã�
 */
public class JavaMethod {
	
	String name;
	char gender;
	int age;
	int height;
	int weight;
	static int height1;
	
	/**
	 * �޲ι��췽��
	 */
	public JavaMethod() { // ���췽����������������һ��
		
	}
	
	public JavaMethod(String name) {
		this.name = name; // �������ʵ������name��ʵ����ʱ���и�ֵ����
	}
	
	public JavaMethod(String name, int age) {
		// this.name = name;
		this(name); // ��ʾ�ڹ��췽���ڲ�ȥ��������һ�����췽����this(name)ƥ��JavaMethod(String name)�������
		this.age = age;
	}
	
	public JavaMethod(String name, char gender, int age, int height, int weight) {
		this(name, age);
		// this.name = name;
		this.gender = gender;
		// this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	/**
	 * �вι��췽�� 
	 * @param a
	 */
	public JavaMethod(int a) {
		System.out.println("JavaMethod a: " + a);
	}
	
	public JavaMethod(float b) {
		System.out.println("JavaMethod b: " + b);
	}
	
	public void eat() {
		System.out.println("�Է�");
	}
	
	public String getName(String firstName, String lastName) {
		return firstName + lastName;
	}
	
	public String getName(String firstName, String middleName, String lastName) {
		return firstName + "��"+ middleName + "��" + lastName;
	}
	
	/**
	 * ���������뷵��ֵ�����޹أ�ֻ�뷽�����ƺͲ�����������˳���й�
	 * @return
	 */
	public int getName() {
		return 0;
	}
	
	public static void sleep() {
		System.out.println("��̬����sleep");
	}
	
	/**
	 * ʵ�������ڲ����Ե���������ʵ���������෽�� 
	 * ʵ�������ڲ����Է���ʵ��������̬�������������
	 */
	public void methodInvoke() {
		name = "aa";
		height1 = 180;
		eat();
		sleep();
	}
	
	/**
	 *	�෽������̬�������ڲ�ֻ�ܵ����෽�� �������ܵ���ʵ������
	 *	�෽���ڲ�ֻ�ܷ�������������ܷ���ʵ������
	 */
	public static void methodInvoke1() {
		// name  = "aa"; name������ʵ�����������ܱ���̬��������
		height1 = 180;
		// eat(); eat()Ϊʵ�������������ھ�̬�����ڲ�����
		sleep();
	}
	
	/**
	 * public String toString()��Object�ඨ��ķ�������������ʵ��������������������ص�����ֵ
	 * ��������Ҫ���������ʱ���ø÷���
	 * 
	 * System.out.println(jm.toString());
	 * System.out.println(jm);
	 * ��һ���ģ�jmʵ����Ĭ�ϵ���toString()����
	 * 
	 * ���û�����Լ� ����������ʵ��toString()��������toString()���������+@hashcode��������Ҫ�Լ�����ʵ��toString
	 */
	public String toString() {
		return "name: " + name + // ����ǻ�ȡ����ֵ������ʡ��this.��Ĭ�Ͼ��ǵ�ǰ����������
				"gender: " + gender +
				"age: " + age +
				"height: " + this.height +
				"weight: " + this.weight;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWeight() {
		return weight;
	}

	public static void main(String[] args) {
		JavaMethod jm = new JavaMethod();
		JavaMethod jm1 = new JavaMethod(100);
		JavaMethod jm2 = new JavaMethod(100.f);
		JavaMethod jm3 = new JavaMethod("С��");
		JavaMethod jm4 = new JavaMethod("С��", 20);
		
		JavaMethod jm5 = new JavaMethod("С��", 'Ů', 20, 190, 150);
		JavaMethod jm6 = new JavaMethod("С��", 'Ů', 26, 170, 90);
		System.out.println(jm5);
		System.out.println(jm6.toString());
		
		jm.eat();
		System.out.println("getName(String, String) : " + jm.getName("��", "��С"));
		System.out.println("getName(String, String, String) : " + jm.getName("A", "B", "C"));
		jm.sleep();
		JavaMethod.sleep(); // ʹ������þ�̬�������෽����
		
	}
}

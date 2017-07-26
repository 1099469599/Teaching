/**
 * public:
 * 
 * �������Ϊ��Person
 * 
 * �ڴ�������⣺
 * ��ͬ�Ķ�����䲻ͬ�Ĵ洢�ռ�
 * ÿһ��������ջ�ڴ��з���һ����ַ���ɴ˶���ָ��ĳ����ڴ�ռ䣬���ڴ�洢�ö���ĳ�Ա��������Ա���������ͷ�������������
 * 
 * ���һ������ֱ�Ӹ�ֵ��ͬһ�����͵���һ��������������������ͬһ������ݿռ�
 * 
 * ͬһ��������ж����ö��ڴ��е�ͬһ��������
 *
 *	����Java�඼ �̳���java.lang.Object�࣬Object����������ĸ��࣬
 *	���ǲ���Ҫ��ʽ��ָ����̳���Object��Ĭ�Ͼ��Ǽ̳���Object
 *
 */
public class Person {
	
	/**
	 * һ������������Է���ǰ��
	 * ������Կ��Խ�����Ա��������Ա�����ɲ�����ʼ������Ĭ��ֵ 
	 * ����һ�ֽ����ֲ��������ֲ�����һ��Ҫ��ʼ��
	 */
	String name = "С��"; // Ĭ��Ϊnull�������ڴ˸���ʼֵ
	char gender; // Ĭ��Ϊ���ַ�
	int age; // Ĭ��Ϊ0
	int height;
	int weight;
	
	/**
	 * �������ں���
	 */
	void eat() {
		int count = 3;
		System.out.println(name + "���ڳԷ�������" + count + "��");
	}
	
	void sayHello(String n) {
		System.out.println(name + "˵����ã� " + n);
	}

	public static void main(String[] args) {
		// ʹ��new�ؼ�������������ΪPerson��ʵ��
		// ������ ʵ������ = new ������();
		Person person = new Person();
		person.eat(); // ʹ�ó�Ա�����.���ö���ķ���
		person.sayHello("С��");
		person.name = "person"; 
		person.gender = '��';
		person.age = 20;
		person.height = 170;
		person.weight = 120;
		System.out.println("����person���������£�name " 
				+ person.name + " age " + person.age
				+ " gender " + person.gender 
				+ " height " + person.height
				+ " weight " + person.weight);
		Person person1 = new Person();
		person1.eat();
		person1.sayHello("С��");
		person1.name = "person1";
		person1.age = 30;
		person1.gender = 'Ů';
		person1.height = 190;
		person1.weight = 100;
		System.out.println("����person1���������£�name " 
				+ person1.name + " age " + person1.age
				+ " gender " + person1.gender 
				+ " height " + person1.height
				+ " weight " + person1.weight);
		
		Person person2 = person1; // person1��person2����ͬһ�����ڴ�ռ䣬����person1������Ӧ�ĸı䣬person2Ҳ��ı�
		System.out.println("person1 name: " + person1.name + ", person2 name: " + person2.name);
		person2.name = "new name";
		System.out.println("person1 name: " + person1.name + ", person2 name: " + person2.name);
		Person person3 = null;
		// ���һ������Ϊ�� null����ô�˶���û�б������ڴ�ռ䣬����ȥʹ�øö���
		// ���ʹ��һ��Ϊnull�Ķ�������׳�java.lang.NullPointerException�쳣
		// Exception in thread "main" java.lang.NullPointerException at Person.main(Person.java:79)
		// person3.eat(); 
		
		Person person4 = new Person();
		if (person4 != null) { // �ж�һ�������Ƿ�Ϊnull�������Ϊnull�������ʹ�øö���
			person4.eat();
		}
		
		System.out.println("�ж�person1 == person2: " + (person1 == person2)); // true
		System.out.println("�ж�person1 == person4: " + (person1 == person4)); // false
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = str1;
		System.out.println("str1 == str2: " + (str1 == str2)); // false
		System.out.println("str1 == str3: " + (str1 == str3)); // true
		
		/**
			 ʹ��equals�������ж϶����Ƿ�Ϊͬһ������
			equals����������java.lang.Object�࣬����ʵ����ֱ�Ӷ������������==�жϣ�==�ж϶�ĳЩ�಻���ã����Զ����͵�����ж�Ӧ����equals���� 
			== �� equals������:
			== ʵ���Ƕ�������������ڴ��ַ�����жϣ�ͬһ�����õ�ʱ�򷵻���
			equals ʵ���Ƕ��������������е����ݽ����жϣ�ֻ��������ȵ�����²ŷ�����
			
			���ڻ����������ͣ������࣬����ֱ����==�ж�
		*/
		System.out.println("ʹ��equals�ж�person1 == person2: " + (person1.equals(person2))); // true
		System.out.println("ʹ��equals�ж�person1 == person4: " + (person1.equals(person4))); // false
		System.out.println("ʹ��equals�ж�str1 == str2: " + str1.equals(str2)); // true
		System.out.println("ʹ��equals�ж�str1 == str3: " + str1.equals(str3)); // true
	}
	
}

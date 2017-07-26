package com.gs.one;

public class OuterClass {
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * ֱ�����ⲿ��ķ��� ��ʵ�����ڲ����ʵ�� 
	 */
	public void instanceInnerClass() {
		InnerClassOne one = new InnerClassOne();
		InnerClassFour four = new InnerClassFour();
		InnerClassFive five = new InnerClassFive();
	}
	
	public void innerClass() {
		
		// InnerClass ic = new InnerClass(); // �����ڷ����ﶨ��ֲ��ڲ���֮ǰʵ�����ֲ��ڲ���Ķ���
		
		final int a = 10; // ʹ��final���Σ������ھֲ��ڲ������޸ģ� ��֤���ݰ�ȫ��
		
		class InnerClass {
			
			public void modify() {
				System.out.println(a);
				int b = a + 10;
				// a = 20; // �ֲ��ڲ��಻��ȥ�޸İ����˾ֲ��ڲ��෽����ľֲ�����
			}
			
		}
		
		InnerClass ic = new InnerClass();
		ic.modify();
		
		System.out.println(a);
	}
	
	public class InnerClassOne {
		
		private String name;
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void sayHello() {
			System.out.println("hello " + name);
			System.out.println("hello " + getName()); // ����InnerClassOne�ڲ����getName������ ������ڲ�����û��getName���� ����ֱ��ȥʹ���ⲿ���getName����
			System.out.println("hello " + this.getName());
			System.out.println("hello " + InnerClassOne.this.getName()); // InnerClass.this��ʾ�ڲ��������
			System.out.println("hello " + OuterClass.this.getName()); // OuterClass.this��ʾ�ⲿ�������
		}
		
	}
	
	protected class InnerClassTwo {
		public void sayHello() {
			System.out.println("hello " + name);
		}
	}
	
	class InnerClassThree {
		public void sayHello() {
			System.out.println("hello " + name);
		}
	}
	
	private class InnerClassFour {
		public void sayHello() {
			System.out.println("hello " + name);
		}
	}
	
	/**
	 * ��̬�ڲ���
	 *
	 */
	public static class InnerClassFive {
		public static int a;
		public void test() {
			
		}
	}
	
	public static void main(String[] args) {
		 // InnerClassOne one = new InnerClassOne();
		OuterClass outClass = new OuterClass();
		OuterClass.InnerClassOne one = outClass.new InnerClassOne();
		OuterClass.InnerClassTwo two = outClass.new InnerClassTwo();
		OuterClass.InnerClassThree three = outClass.new InnerClassThree();
		OuterClass.InnerClassFour four = outClass.new InnerClassFour();
		// OuterClass.InnerClassFive five = outClass.new InnerClassFive(); // ��ͨ���ⲿ��Ķ�����ʵ����һ����̬�ڲ���
		OuterClass.InnerClassFive five = new OuterClass.InnerClassFive(); // new �ⲿ������.�ڲ�������();�������ⲿ���ж���ľ�̬�ڲ���
		OuterClass.InnerClassFive five1 = new InnerClassFive();
	}

}

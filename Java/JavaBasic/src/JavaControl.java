public class JavaControl {
	
	public static void eat() {
		System.out.println("���ڳԷ���");
	}
	
	public static int add(int a, int b) {
		return a + b;
	} 
	
	public static void main(String[] args) {
		int a = 100;
		boolean b = false;
		if (a > 100) {
			System.out.println("a > 100");
		} else {
			System.out.println("a <= 100");
		}
		
		if (b == true) {
			System.out.println("b is true");
		} else {
			System.out.println("b is false");
		}
		
		if (b) { // ���ĳ��������ֵΪtrue��false����ñ�����if�ж�ʱ��ֱ��ʹ�øñ�����������Ҫд==true��==false
			System.out.println("b is true");
		} else {
			System.out.println("b is false");
		}
		
		// switch�жϵ�Ҳ�ǳ���,���Զ�int��char���ͽ����ж�
		// JDK1.7�����ϣ������Զ��ַ��������ж�
		switch(a) { 
			case 10: 
				//
			break;
			case 100:
				
			break;
			case 200:
				
			break;
		}
		String str = "hello";
		switch(str) {
			case "hello":
				System.out.println("OK!");
			break;
		}
		
		int i;
		for (i = 0; i < 10; i++) {
			//
		}
		
		for (int j = 0; j < 10; j++) {
			System.out.print(j + " ");
		}
		
		for (int k = 0, m =10; k < m; k++, m--) {
			System.out.print(k + " ");
		}
		
		System.out.println();
		eat();
		System.out.println(add(10, 10));
	}

}
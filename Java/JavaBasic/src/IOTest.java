import java.util.Scanner; // import������

public class IOTest {
	public static void main(String[] args) {
		System.out.println("������һ��������");
		// ʹ��new�ؼ���ʵ����һ������ �봴��һ��Scanner���ʵ�������󣩣�ʵ������������Ϊscanner
		// new Scanner(System.in) ��ʾ�ӡ���׼���롱������ص�����
		Scanner scanner = new Scanner(System.in); 
		int a = scanner.nextInt(); // nextInt()��ʾ��������
		String s = scanner.next(); // next()��ʾ�����ַ���
		scanner.close();// �ر�������
		System.out.println("a = " + a);
		System.out.println("s: " + s);
	}
}
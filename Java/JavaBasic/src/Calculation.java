import java.util.Scanner;

public class Calculation {

	public static void main(String[] args) {
		System.out.println("����������������");
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println("��˳������𰸣��ͣ��������(�����С����ֱ��ȡ��������)������");
		if (a + b == scanner.nextInt()) {
			count++;
		}
		if (a * b == scanner.nextInt()) {
			count++;
		}
		if (a - b == scanner.nextInt()) {
			count++;
		}
		if (a / b == scanner.nextInt()) {
			count++;
		}
		if (a % b == scanner.nextInt()) {
			count++;
		}
		scanner.close();
		System.out.println("��ȷ�ĸ����� " + count);
	}

}

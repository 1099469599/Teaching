import java.util.Scanner;

public class NumberReverse {

	public static void main(String[] args) {
		System.out.println("����һ����������");
		Scanner scanner = new Scanner(System.in);
		String str = String.valueOf(scanner.nextInt()); //String.valueOf(int args) ��int���͵�argsת����String�ַ���
		scanner.close();
		char[] charArray = str.toCharArray();
		for (int i = charArray.length - 1; i >= 0; i--) {
			System.out.print(charArray[i]);
		}
	}
}

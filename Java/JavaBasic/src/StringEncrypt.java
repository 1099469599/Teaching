import java.util.Scanner;

public class StringEncrypt {

	/**
	 * a b c d e f g 
	 * d e f g h i j
	 * 
	 * u v w x y z
	 * x y z a b c
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("����Ҫ���ܵ��ַ���");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		scanner.close();
		char[] charArray = str.toCharArray(); // ��ȡһ���ַ�����Ӧ���ַ�����
		// int length = str.length(); // ���Ի�ȡ��һ���ַ����ĳ��ȣ��ַ����������ַ���
		// for (int i = 0; i < str.length(); i++) {
		for (int i = 0, length = str.length(); i < length; i++) { // for��ʼ�����ʽ�����ж�����ã����������ҿ���Ϊ��ʼ�������÷����ķ���ֵ��ֵ
			char c = charArray[i];
			switch(c) {
				case 'x': charArray[i] = 'a'; break;
				case 'y': charArray[i] = 'b'; break;
				case 'z': charArray[i] = 'c'; break;
				case 'X': charArray[i] = 'A'; break;
				case 'Y': charArray[i] = 'B'; break;
				case 'Z': charArray[i] = 'C'; break;
				default: charArray[i] = (char) (c + 3); break;
			}
		}
		System.out.print(charArray);
	}

}

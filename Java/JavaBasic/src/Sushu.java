/**
 * java.lang.Math����ר�����ڴ�����ѧ������� 
 * sqrt���� 
 * abs����ֵ 
 * max 
 * min 
 * PI 
 * E
 */
public class Sushu {
	public static void main(String[] args) {
		int count = 0;
		for (int i = 100; i <= 200; i++) {
			boolean isSushu = true;
			for (int j = 2, sqrt = (int) Math.sqrt(i); j <= sqrt; j++) {
				if (i % j == 0) {
					isSushu = false;
					break;
				}
			}
			if (isSushu) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("��" + count + "��");
	}
}
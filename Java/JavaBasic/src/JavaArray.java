public class JavaArray {
	public static void main(String... args) {
		int a[] = {1, 2, 3}; // int a[] = {},��Ҫ��Ϊ�ظ���a����ĳ���
		for (int i = 0; i < 3; i++) {
			System.out.println(a[i]);
		}
		int[] b = {1, 3, 3}; // java������[]�������ͺ���
		for (int i = 0; i < 3; i++) {
			System.out.println(b[i]);
		}
		/**
			int, short,long, byte: 0
			char: ''
			float, double: 0.0
			boolean: false
			String: null
		*/
		int[] c = new int[3]; // �����Ҫָ������ĳ��ȣ���Ҫʹ��new ����[����];
		for (int i = 0; i < 3; i++) {
			System.out.println(c[i]);
		}
		int[] cc = new int[3]; // �����Ҫָ������ĳ��ȣ���Ҫʹ��new ����[����];
		for (int i = 0; i < cc.length; i++) { // ����ĳ��ȿ�����length���Ի�ȡ
			System.out.println(cc[i]);
		}
		
		byte[] e = new byte[3];
		for (int i = 0; i < 3; i++) {
			System.out.println(e[i]);
		}
		char[] d = new char[3];
		for (int i = 0; i < 3; i++) {
			System.out.println(d[i]);
		}
		boolean[] f = new boolean[3];
		for (int i = 0; i < 3; i++) {
			System.out.println(f[i]);
		}
		String[] s = new String[3];
		for (int i = 0; i < 3; i++) {
			System.out.println(s[i]);
		}
		
		int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8}}; // ÿһ���е����������Բ���ͬ
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.print(" " + x[i][j]); //���ֱ����j < 3; ����� ��java.lang.ArrayIndexOutOfBoundsException ��������Խ���쳣
			}
		}
		int[][] xx;
		int[][] xxx = new int[2][3];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				xxx[i][j] = i * j;
				System.out.println(xxx[i][j]);
			}
		}
		for (int i = 0; i < xxx.length; i++) {
			for (int j = 0; j < xxx[i].length; j++) {
				System.out.println(xxx[i][j]);
			}
		}
		
		System.out.println("array xxx row length��" + xxx.length); // �Զ�ά���飬.length���Ի�ȡ��������
		System.out.println("array xxx column length: " + xxx[0].length);
	}
}
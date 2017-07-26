package com.gs.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void main(String[] args) {
		
		System.out.println("��ϵͳ�µ�·���ķָ���Ϊ��" + File.separator);
		
		File file = new File("d:" + File.separator + "javaio" + File.separator + "javaio.txt"); // java �е�Fileָ���ļ�·����ʱ��ֱ��ʹ��/��������windowsϵͳ�е�\
		if (file.exists()) {// �ж��ļ��Ƿ����
			System.out.println("�ļ��ľ���·���� " + file.getAbsolutePath()); // ��ȡ�ļ��ľ���·��
			System.out.println("�ļ������ƣ� " + file.getName());
			System.out.println("�ļ��������ܴ�С�� "  + file.getTotalSpace()); //�洢��ǰ�ļ����̷������������� ��С��  ���صĵ�λ���ֽ�
			System.out.println("�ļ������Ŀ��ô�С�� "  + file.getUsableSpace());
			System.out.println("�ļ���С�� " + file.length() + "�ֽ�"); // ��λΪ�ֽ�
			
			file.delete(); // ɾ���ļ�������Ż���վ
		}
		System.out.println("***********************************");
		File file1 = new File("d:/javaio/a");
		if (file1.exists()) {
			if (file1.isFile()) { // �ж��Ƿ�Ϊ��ͨ�ļ�
				System.out.println(file1.length());
			} else if (file1.isDirectory()) { // �ж��Ƿ�ΪĿ¼
				System.out.println(file1.length()); // Ŀ¼��û�д�С��
				System.out.println("����Ŀ¼");
			}
		}
		System.out.println("*********�����Ǵ���Ŀ¼**********");
		File file2 = new File("d:/javaio/b");
		if (!file2.exists()) {
			file2.mkdir(); // ����Ŀ¼��ֻ֧��һ���㼶
		}
		File file3 = new File("d:/javaio/c/c1");
		if (!file3.exists()) {
			file3.mkdirs(); // ����Ŀ¼��֧�ֶ���㼶
		}
		
		System.out.println("*********�����Ǵ����ļ�**********");
		File file4 = new File("d:/javaio/java�������ļ�.txt");
		if (!file4.exists()) {
			try {
				file4.createNewFile(); // �������ļ� 
				
			} catch (IOException e) { // java.io.IOException��ʾ��������쳣������ʱ�쳣
				e.printStackTrace();
			}
		}
		file4.renameTo(new File("d:/javaio/java�������ļ�1.txt"));
		
		System.out.println("**********��ȡjavaio������Ŀ¼************");
		File file5 = new File("d:" + File.separator + "javaio");
		if (file5.exists()) {
			String[] fileList = file5.list(); // ��ȡĳ��Ŀ¼�µ�����Ŀ¼���ļ������ƣ�����������������ɵ��ַ�������
			File[] files = file5.listFiles(); // ��ȡĳ��Ŀ¼�µ�����Ŀ¼���ļ���File���󣬷�������File������ɵ�����
			for (String str : fileList) {
				System.out.println(str);
			}
			for (File f : files) {
				if (f.isFile()) {
					System.out.println("�ļ����ƣ� " + f.getName() + ", ��С �� " + f.length());
				} else if (f.isDirectory()) {
					System.out.println("Ŀ¼���� ��" + f.getName());
				}
			}
		}
		
	}

}

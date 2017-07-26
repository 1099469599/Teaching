package com.gs.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	
	public static void main(String[] args) {
		File file = new File("d:/javaio/abc.txt");
		if (file.exists()) {
			try {
				RandomAccessFile raf = new RandomAccessFile(file, "r");
//				int a = raf.read(); // �����ļ��е�һ���ַ������ش��ַ�����Ӧ��ascii
//				System.out.println(a);
				byte[] bytes = new byte[(int) file.length()];
				raf.read(bytes); // ���ļ��ж����ֽڷŵ��Զ�����ֽ�������
				for (byte b : bytes) {
					System.out.println(b);
				}
			
//				String s = raf.readUTF(); // java.io.EOFException �ļ���β�쳣 end of file
//				System.out.println(s);
				String s = new String(bytes, "unicode"); // ��bytes����ת����һ���ַ������ڶ���������ʾʹ��ʲô������ת��
				System.out.println(s);
				
				System.out.println("*********************");
				byte[] bytes1 = new byte[10];
				raf.seek(10); // �ڶ�ȡǰ�ȶ�λ����Ҫ��λ��
				raf.read(bytes1, 5, 5); // ��һ��������Ŀ��byte���飬�ڶ�������ָ��Ŀ������ĵڼ���λ�ÿ�ʼ�洢�������������Ǵ洢�ĳ���
				String s1 = new String(bytes1, "unicode");
				System.out.println(s1);
				raf.close();
				
				System.out.println("**************���******************");
				File f = new File("d:/javaio/rafoutput.txt");
				if (!f.exists()) {
					f.createNewFile();
				}
				RandomAccessFile rafOut = new RandomAccessFile(f, "rw");
				// rafOut.writeChars("ajflkdjfldskjfkdlfjdskl"); // ÿ���ַ����Զ����˿ո�
				String str = "ajflkdjfldskjfkdlfjdskl����\r\nafdsfdsfds"; // \r\n�����ļ��Ļ��в���
				rafOut.write(str.getBytes("unicode")); // str.getBytes("unicode")��ʾ���ַ���ͨ��ָ���ı����ʽת�����ֽ�����
				rafOut.writeInt(100); // 100��asscii�룬��Ӧ�ַ�d
				rafOut.writeDouble(100.0);
				rafOut.close();
			} catch (FileNotFoundException e) { // �ļ�δ�ҵ��쳣������ʱ�쳣
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

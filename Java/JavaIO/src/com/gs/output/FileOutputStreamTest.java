package com.gs.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("d:/javaio/fileoutput.txt")); // ����FileOutputStream������ĸ��ļ�������ļ������� �����Զ��������ļ�  
			fos.write("abcedfdfdsjflskjf".getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		};
	}

}

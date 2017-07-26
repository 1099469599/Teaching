package com.gs.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {
	
	public static void main(String[] args) {
		try {
			File file = new File("d:/javaio/abc.txt");
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "unicode");
			char[] chars = new char[((int) file.length())];
			int i = -1;
			int k = 0;
			while ((i = isr.read()) != -1) { // ÿ�ζ���һ���ַ���һֱ������������β����������������꣬�򷵻�-1
				chars[k] = (char) i;
				k++;
			}
			for (int j = 0; j < k; j++) {
				System.out.println(chars[j]);
			}
			isr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

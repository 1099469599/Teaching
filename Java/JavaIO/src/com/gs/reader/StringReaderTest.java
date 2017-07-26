package com.gs.reader;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderTest {
	
	public static void main(String[] args) {
		StringReader sr = new StringReader("dfdjlfjldskf");
		char[] chars = new char[20];
		try {
			sr.read(chars); // ���ַ������뵽ָ�����ַ�������
			for (char c : chars) {
				System.out.println(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

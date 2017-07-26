package com.gs.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/javaio/abc.txt")), "unicode"));
			// String str = br.readLine();// ֻ����һ��
			String str = null;
			String allStr = "";
			while ((str = br.readLine()) !=null) { // ÿ�ζ�����һֱ����û����
				allStr += str + "\r\n";
			}
			System.out.println(allStr.substring(0, allStr.length() - 2));
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

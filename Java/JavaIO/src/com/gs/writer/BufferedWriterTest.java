package com.gs.writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class BufferedWriterTest {
	
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("d:/javaio/bw.txt")), "utf-8"));
			bw.write("�����ַ���\r\n��һ��\r\n������һ��");
			bw.close();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d:/javaio/bw.txt")), "utf-8"));
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			br.close();
		} catch (UnsupportedEncodingException e) { // ��֧�ֵı����ʽ�쳣������ʱ�쳣
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

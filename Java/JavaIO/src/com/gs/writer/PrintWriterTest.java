package com.gs.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWriterTest {
	
	public static void main(String[] args) {
		try {
			PrintWriter pw = new PrintWriter(new File("d:/javaio/pw.txt")); // ָ����������ļ�
			pw.print("aaaaa");
			pw.println("bbbbb");
			pw.println("ccccc"); // �����л���
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

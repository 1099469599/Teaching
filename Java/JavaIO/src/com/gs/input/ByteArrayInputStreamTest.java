package com.gs.input;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) {
		try {
			File file = new File("d:/javaio/abc.txt");
			FileInputStream fis = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fis.read(bytes);
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes); // ����ֽ�������ԭʼ������

			byte[] bytes1 = new byte[bytes.length];
			bais.read(bytes1); // ��ԭʼ���ֽ�������뵽��byte������
			fis.close();
			System.out.println(new String(bytes, "unicode"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

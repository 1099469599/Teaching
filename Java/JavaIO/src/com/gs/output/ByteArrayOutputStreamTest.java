package com.gs.output;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
	
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			baos.write("afdsfdsf".getBytes()); // ���ֽ��������ݷ��뵽ByteArrayOutputStream������У�����������Խ�һ��������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

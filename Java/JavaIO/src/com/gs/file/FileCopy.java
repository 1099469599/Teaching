package com.gs.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCopy {
	
	/**
	 * ��ָ��·����Դ�ļ�copy��ָ��·����Ŀ���ļ�
	 * Ŀ���ļ���Ҫ�ж��Ƿ���ڣ���������ڣ��򴴽��µ��ļ�
	 * 
	 * @param originalPath Դ�ļ���·��
	 * @param desPath Ŀ���ļ���·��
	 */
	public static void copy(String originalPath, String desPath) {
		copy(new File(originalPath), new File(desPath));
	}
	
	public static void copy(File originalFile, File desFile) {
		try {
			RandomAccessFile oRaf = new RandomAccessFile(originalFile, "r");
			RandomAccessFile desRaf = new RandomAccessFile(desFile, "rw");
			// ��ʼ��ȡԴ�ļ�����
			byte[] oBytes = new byte[(int) originalFile.length()];
			oRaf.readFully(oBytes);
			desRaf.write(oBytes);
			oRaf.close();
			desRaf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileCopy.copy("d:/javaio/abc.txt", "d:/javaio/abc-copy.txt");
	}

}

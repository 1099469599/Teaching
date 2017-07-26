package com.gs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	
	public static void main(String[] args) {
		Date date = new Date(); // ��ȡ��ǰʱ�����
		long time = date.getTime(); // System.currentTimeMillis()
		int year = date.getYear(); // 2016 - 1900 = 116��
		int month = date.getMonth(); // month ��0��ʼ��
		int day = date.getDate();
		int day1 = date.getDay();
		int hour = date.getHours();
		int minute = date.getMinutes();
		int seconds = date.getSeconds();
		System.out.println("year:" + year + ", month: " + (month + 1) +
				",date: " + day + ", day: " + day1 +
				", hour: " + hour + ", minute: " + minute + ", seconds: " + seconds);
		DateFormat df = new SimpleDateFormat(); // ����Ĭ�ϵĸ�ʽ������ں�ʱ�� y-M-d ����/����H:m
		String dateStr = df.format(date);
		System.out.println(dateStr);
		DateFormat df1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(df1.format(date));
		DateFormat df2 = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
		System.out.println(df2.format(date));
	}

}

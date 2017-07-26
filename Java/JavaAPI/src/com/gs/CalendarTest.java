package com.gs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // ��ȡCalender���ʵ��
		int year = cal.get(Calendar.YEAR); // Calendar.YEAR��ʾ��ĳ���
		int month = cal.get(Calendar.MONTH); // MONTHΪ��
		int day = cal.get(Calendar.DATE); // ��
		int day1 = cal.get(Calendar.DAY_OF_MONTH); // ����µĵڼ���
		int weekday = cal.get(Calendar.DAY_OF_WEEK); // �����ݵڼ���
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println(year + ", " + (month + 1) + ", " + day + ", " + day1 + ", " + weekday + ", " + hour + ", " + minute + ", " + second);
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(df.format(cal.getTime()));
		
		// ��ʱ����޸�
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2015, 0, 1, 13, 30, 0);
		System.out.println(df.format(cal1.getTime()));
		cal1.set(Calendar.YEAR, 2018);
		cal1.set(Calendar.HOUR_OF_DAY, 18); // Calendar.HOUR��12Сʱ�� Calendar.HOUR_OF_DAY��24Сʱ��
		cal1.set(Calendar.MINUTE, 0);
		System.out.println(df.format(cal1.getTime()));
		// cal1.add(field, amount); // ��ʾ��ĳ���ֶ��Ͻ��мӻ��
	}
	
}

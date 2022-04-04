package com.lec.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormat {
    public static void main(String[] args) {
		Date now1 = new Date();
		Calendar now2 = Calendar.getInstance();
		GregorianCalendar now3 = new GregorianCalendar ();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a hh�� mm�� ss��");
		// yyyy ���� 4�ڸ� yy���� 2�ڸ� M 3 MM 03 d 9 dd 09
		// E ���� a �������� H 24�� m �� s ��
		// w (�̹��⵵�� ���° ������) D ���� ���° ������
		System.out.println(sdf.format(now1));
		System.out.println(sdf.format(now2.getTime()));
		System.out.println(sdf.format(now3.getTime()));
	}
}

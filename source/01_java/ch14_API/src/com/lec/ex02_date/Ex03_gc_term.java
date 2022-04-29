package com.lec.ex02_date;

import java.util.GregorianCalendar;

public class Ex03_gc_term {
	public static void main(String[] args) {
		GregorianCalendar gcNow = new GregorianCalendar(); // ���� ������ ��¥ �� �ð�
		GregorianCalendar gcThat= new GregorianCalendar(2022, 3, 11, 9, 30); // ���� ������ ��¥ �� �ð�
	    long start = gcThat.getTimeInMillis();
	    long end = gcNow.getTimeInMillis();
	    int day = (int)(end-start)/(1000*60*60*24);
	    System.out.println("�����Ϻ��� ���ñ��� "+day+ "���� �������ϴ�.");
	}

}

package com.lec.ex02_date;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Ex02_gregoriCalendar {
	public static void main(String[] args) {
		GregorianCalendar cal = new GregorianCalendar(); //�̱���Ŭ����
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR); //�⵵
		int month = cal.get(Calendar.MONTH)+1;// �� 0,1,2,3,....11��
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY); //24�ð� ����
		int ampm = cal.get(Calendar.AM_PM);// 0 ���� 1 ����
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisec = cal.get(Calendar.MILLISECOND);
		System.out.printf("%d�� %d�� %d��\n" , year,month,day);
		switch(week) {
		case 1 : System.out.print("�Ͽ���"); break;
		case 2 : System.out.print("������"); break;
		case 3 : System.out.print("ȭ����"); break;
		case 4 : System.out.print("������"); break;
		case 5 : System.out.print("�����"); break;
		case 6 : System.out.print("�ݿ���"); break;
		case 7 : System.out.print("�����"); break;
		};
		System.out.print(ampm == 0 ? "����" : "����");
		System.out.printf("%d�� %d�� %d�� %d\n", hour, minute,second,millisec);
		System.out.printf("%d�� %d�� %d�� %d\n", hour24, minute,second,millisec);
		//%d ���� %f �Ǽ� %s ���ڿ� %c ���� �ϳ�
        //%tY �� %tm ��  %td ��	%ta ����	%tH(24�ð�) %tp(����/����) %tl 12�ð� %tM �� %tS(��)
		System.out.printf("%tY��  %tm ��  %td �� %ta ���� %tp %tl�� %tM�� %tS��\n", cal, cal, cal, cal, cal, cal, cal, cal, cal);
		
	}

}

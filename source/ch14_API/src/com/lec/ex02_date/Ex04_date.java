package com.lec.ex02_date;
import java.util.Calendar;
import java.util.Date;
public class Ex04_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear(); //�⵵
		int month = date.getMonth();// �� 0,1,2,3,....11��
		int day = date.getDate();
		System.out.printf("%d�� %d�� %d��\n" , year,month,day);
		//%d ���� %f �Ǽ� %s ���ڿ� %c ���� �ϳ�
        //%tY �� %tm ��  %td ��	%ta ����	%tH(24�ð�) %tp(����/����) %tl 12�ð� %tM �� %tS(��)
		System.out.printf("%tY��  %tm ��  %td �� %ta ���� %tp %tl�� %tM�� %tS��\n", date, date, date, date, date, date, date, date, date);
	
		
	}

}

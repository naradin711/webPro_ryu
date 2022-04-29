package com.lec.ex02_date;
import java.util.Calendar;
import java.util.Date;
public class Ex04_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		int year = date.getYear(); //년도
		int month = date.getMonth();// 월 0,1,2,3,....11월
		int day = date.getDate();
		System.out.printf("%d년 %d월 %d일\n" , year,month,day);
		//%d 정수 %f 실수 %s 문자열 %c 문자 하나
        //%tY 년 %tm 월  %td 일	%ta 요일	%tH(24시간) %tp(오전/오후) %tl 12시간 %tM 분 %tS(초)
		System.out.printf("%tY년  %tm 월  %td 일 %ta 요일 %tp %tl시 %tM분 %tS초\n", date, date, date, date, date, date, date, date, date);
	
		
	}

}

package com.lec.ex05_Lib;

import java.util.Date;

public class Lib_TestMain {
	public static void main(String[] args) { //메인에서는 throw함수 쓰지 않는다!
		BookLib bk1 = new BookLib("89a-21", "java", "자바칩");
		BookLib bk2 = new BookLib("90a-73", "DBMS", "민단비");
	   
	    System.out.println(bk1);
	    try {
			bk1.checkOut("김빌림");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    // 대출일 조작
	    bk1.setcDate(new Date(122,2,11));
	    System.out.println(bk1);
	    try {
			bk1.checkIn();
		} catch (Exception e) {
		    System.out.println("예외 메시지 :" +e.getMessage());
		}
	    System.out.println(bk1);
	}

}

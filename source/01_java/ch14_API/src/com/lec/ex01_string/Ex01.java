package com.lec.ex01_string;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
	   int i = 10;
	   String str1 = "Java";
	   String str2 = "Java";
	   // String은 new로 생성하지 않고 "" 를 사용한 문자열 상수를 사용. 자동으로 힙영역에 String 객체가 이미 존재하는지 확인하고 
	   // 만약에 해당 객체가 존재하면 해당 문자열 객체를 공유. 존재하지 않으면 String 객체 생성
	   String str3 = new String("Java");
       if (str1==str2) { // 같은 주소 값을 가지고 있습니다.
    	   System.out.println("str1과 str2는 같은 주소값이 있습니다.");
       }else {
    	   System.out.println("str1과 str2는 다른 주소값이 있습니다.");
       }
       if (str1.equals(str2)) {
    	   System.out.println("str1과 str2는 같은 문자열.");
       }else {
    	   System.out.println("str1과 str2는 다른 문자열.");
       }
       System.out.println(str1==str3? "str1과 str3은 같은 주소" :"str1과 str3은 다른 주소" );
       System.out.println(str1.equals(str3)? "str1과 str3은 같은 문자열" :"str1과 str3은 다른 문자열" );
       
	}//main

}

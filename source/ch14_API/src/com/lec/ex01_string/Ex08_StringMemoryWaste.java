package com.lec.ex01_string;
// 스트링 변수의 값을 바꿀때마다 객체가 새롭게 생성됩니다.
public class Ex08_StringMemoryWaste {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hello";
		System.out.println(str1 == str2 ? "같은 주소" : "다른 주소");
		System.out.println("str1의 해쉬코드 : " +str1.hashCode() );
		System.out.println("str2의 해쉬코드 : " +str2.hashCode() );
	    str1 = "hello!";
	    System.out.println("str1의 해쉬코드 : " +str1.hashCode() );
	    str2 = "hello~~~";
	    System.out.println("str2의 해쉬코드 : " +str2.hashCode() ); 
	}

}

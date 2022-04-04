package com.lec.ex01_string;

import java.util.StringTokenizer;

public class Ex12_stringTokenizer {
	public static void main(String[] args) {
		String str1 = "박보검 설현 수지 고소영 장동건";
		String str2 = "03/28/2022";
		StringTokenizer tkn1 = new StringTokenizer(str1);// space 기준으로 문자열을 구분한다.
		System.out.println("tkn1의 토큰 갯수 : "+ tkn1.countTokens()); //토큰 세기
		while(tkn1.hasMoreTokens()) {
			  System.out.println(tkn1.nextToken()); //토큰을 꺼내쓰고 다음 토큰 계속 출력
		}//while구문
		StringTokenizer tkn2 = new StringTokenizer(str2, "/");
		System.out.println("tkn2의 토큰 갯수 : "+ tkn2.countTokens());
		while(tkn2.hasMoreTokens()) {
			  System.out.println(tkn2.nextToken()); //토큰을 꺼내쓰고 다음 토큰 계속 출력
		}
	}

}

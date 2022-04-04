package com.lec.ex01_string;

public class Ex10_StringBuffer {
	public static void main(String[] args) {
		StringBuilder stBuilder = new StringBuilder("abc");
		System.out.println("해쉬코드 결과 : "+stBuilder.hashCode());
		// 이 단계에서 주소가 세팅이 완료.
		System.out.println("stBuilder : " + stBuilder);
		stBuilder.append("def"); //기존의 abc에 def를 추가.
		System.out.println("stBuilder : " + stBuilder);
		stBuilder.insert(3, "AAA"); //3번째에 AAA추가
		System.out.println("stBuilder : " + stBuilder);
		System.out.println("해쉬코드 결과 : "+stBuilder.hashCode());
		stBuilder.deleteCharAt(3); //3 번째 문자만 삭제
		System.out.println("stBuilder : " + stBuilder);
		System.out.println("해쉬코드 결과 : "+stBuilder.hashCode());

	}

}

package com.lec.ex06_wrapper;

import java.util.Scanner;

public class Ex04 {
// 사용자로부터 정수 문자열 "100" 을 받아 정수로 수정해서 출력하는 프로그램
	public static void main(String[] args) {
       Scanner sc = new Scanner (System.in);
       System.out.print("정수를 입력하세요 : ");
       String nStr = sc.nextLine();
       System.out.println("입력하신 문자열은 "+nStr);
       nStr = nStr.trim();//좌우 공백 제거
       nStr = nStr.replaceAll("[a-zA-Zㄱ-힣]", "");
       int num = Integer.parseInt(nStr);
       System.out.println("변형된 정수는 "+num);
       
	}

}

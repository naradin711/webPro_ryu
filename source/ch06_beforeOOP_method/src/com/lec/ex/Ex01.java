package com.lec.ex;
// 1~10까지 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력하기
public class Ex01 {
   public static void main(String[] args) {
	  int tot = 0;
	  for (int i=1 ; i<=10 ; i++) {
		  tot += i; // tot = tot + i
	  }
	 System.out.println("1~10까지 정수의 합은"+tot+"입니다.");
	 if(tot%2 == 0) {
		 System.out.println("짝수입니다.");
	 }
	 else {
		 System.out.println("홀수입니다.");
	 }
}
}

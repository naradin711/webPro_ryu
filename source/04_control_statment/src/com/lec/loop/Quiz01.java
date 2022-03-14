package com.lec.loop;
// 1~10까지의 곱을 구해보자. (누적 곱의 변수에 1로 초기화)
public class Quiz01 {
	public static void main(String[] args) {
	   int tot = 1;
	   for(int i=1; i<=10; i++) {
		    tot *= i; //tot = tot + i;   
	   }
	   System.out.println("1~10까지 누적 곱은 " + tot);
		   
	   }
}
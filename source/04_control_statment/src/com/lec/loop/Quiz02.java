package com.lec.loop;
//1~10까지 숫자 중 짝수 또는 홀수의 합을 구해보자.
public class Quiz02 {
	public static void main(String[] args) {
		   int tot = 0; // 누적할 변수
//		   for(int i =1 ; i <11; i++) {
//			   if(i%2 != 0) {
//				   
//			   }
//		   }
		   for (int i=1 ; i<=10 ; i++) {
			    if(i%2==0) continue;
			    tot += i; //tot = tot + i;   
		   }
		   System.out.println("1~10까지 홀수의 합은 " + tot);
	}
}
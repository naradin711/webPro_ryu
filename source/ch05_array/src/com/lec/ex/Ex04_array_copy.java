package com.lec.ex;
// for문을 이용한 배열 복사
public class Ex04_array_copy {
	public static void main (String [] args) {
		   int i = 10; // 변수선언, 초기화
		   int j = 20;
		   j=99;
		   System.out.printf("i = %d, j = %d\n" , i, j);
		   int[] score = {100,10,20,30,40};
		   int[] s = new int [score.length];
		   for(int idx=0 ; idx<score.length; idx++) {// for문을 이용한 배열복사!
			   s[idx] = score[idx];
		   }
		   s[0]=999;
		   for(int idx = 0 ; idx<score.length; idx++) {
		   System.out.printf("score[%d]=%d  s[%d]=%d\n" , idx, score[idx], idx, s[idx]);
		   }
    }
}
package com.lec.ex;

public class Ex03 {
	public static void main (String [] args) {
	   int i = 10; // 변수선언, 초기화
	   int j = 20;
	   j=99;
	   System.out.printf("i = %d, j = %d\n" , i, j);
	   int[] score = {100,10,20,30,40};
	   int[] s = score;
	   s[0] = 99;
	   for(int idx = 0 ; idx<score.length; idx++)
	   System.out.printf("score[%d]=%d  s[%d]=%d\n" , idx, score[idx], idx, s[idx]);
	}
}
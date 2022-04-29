package com.lec.control;

public class Quiz_02 {
   public static void main (String[]args) {
	  int num1 = 27 ;
	  int num2 = 32 ;
	  int max;
	  if (num1>num2) {
               max = num1 ; }
	  // {} 안의 max 변수는 {}이 닫히면  int max는 사라진다.
	  // 변수를 밖으로 빼서 {}안의 변수가 다른 항에도 적용되도록 한다.
	  else { max = num2 ; }
	System.out.println(max);
	  }
}
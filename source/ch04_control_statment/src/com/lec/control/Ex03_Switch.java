package com.lec.control;
// switch 문 : 가독정이 좋은 
public class Ex03_Switch {
   public static void main (String[]args) {
	  int num1 = 7;
	  switch (num1) {
// 정수형 또는 문자형, 문자열 변수만 가능 double 함수 실행 불가.
	  case 1 : System.out.println("1입니다."); break;
	  case 2 : System.out.println("2입니다."); break;
	  case 3 : System.out.println("3입니다."); break;
	  default : System.out.println("그 외의 수입니다.");
	  }
//	  if (num1 ==1) {
//		  System.out.println("1입니다.");
//	  }
//	  else if (num1 ==2) {
//		  System.out.println("2입니다.");
//	  }
//	  else if (num1 ==3) {
//		  System.out.println("3입니다.");
//	  }
}
}
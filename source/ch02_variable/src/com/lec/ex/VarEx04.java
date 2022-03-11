package com.lec.ex;
// 변수 선언 방법들
public class VarEx04 {
      public static void main(String[] args) {
      //1. 자료형 변수명; - 변수선언과 할당을 분리
      int num1; // 변수 선언
      num1 = 10; // 변수에 수치를 할당
      System.out.println("num1="+num1);
      // 2. 자료형 변수명 = 초기값 ; - 변수선언과 할당을 동시에 (초기화)
      int num2 = 20;
      // 3. 자료형 변수명 1, 변수명 2, ... 변수명 n; - 동일 자료형 변수 다수 선언
      int num3, num4;
      num3 = 30;  num4=40;
      System.out.printf("num3=%d, num4=%d\n", num3, num4);
      // 4. 자료형 변수명=값1, 변수명2=값2 ... 변수명n=값n; 동일자료형 변수를 다수 선언과 초기화
      int num5=50, num6=60, num7=70;
      System.out.println("num1="+num1+"\t num2="+num2);
	  System.out.println("num3="+num3+"\t num4="+num4);
	  System.out.println("num5="+num5+"\t num6="+num6);

      }
}
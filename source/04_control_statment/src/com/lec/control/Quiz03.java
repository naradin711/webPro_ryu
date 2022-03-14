package com.lec.control;
// 국어,영어,수학 점수를 입력받아서 각 과목별 점수가 평균 이상인지 이하인지 출력하세요.
import java.util.Scanner;
public class Quiz03 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("국어 점수를 입력하세요. : ");
	      int num1 = sc.nextInt();
	      System.out.print("영어 점수를 입력하세요. : ");
	      int num2 = sc.nextInt();
	      System.out.print("수학 점수를 입력하세요. : ");
	      int num3 = sc.nextInt();
	      int avg = (num1 + num2 + num3)/3 ;
	      if (num1>avg) 
	      { System.out.println("국어점수는 평균 이상입니다.");
	      }
	      else {System.out.println("국어점수는 평균 이하입니다.");}
	      if (num2>avg) 
	      { System.out.println("영어점수는 평균 이상입니다.");
	      }
	      else {System.out.println("영어점수는 평균 이하입니다.");}
	      if (num3>avg) 
	      { System.out.println("수학점수는 평균 이상입니다.");
	      }
	      else {System.out.println("수학점수는 평균 이하입니다.");}
}
}
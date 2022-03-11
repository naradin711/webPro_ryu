package com.lec.quiz;
//국,영,수 점수를 사용자에게 할당받고 각 점수를 출력하고 총점, 평균 소수점 2자리까지 출력하시오.
import java.util.Scanner;

public class Quiz5 {
	public static void main (String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.print("국어 : ");
  int a = scanner.nextInt(); // 사용자로부터 정수 입력 대기 
  System.out.print("영어 : ");
  int b = scanner.nextInt(); // 사용자로부터 정수 입력 대기 
  System.out.print("수학 : ");
  int c = scanner.nextInt(); // 사용자로부터 정수 입력 대기 
  System.out.printf("\n국어 %d 영어 %d 수학%d\n\n", a,b,c);
  int d = a + b + c;
  double e = d/3.00;
  System.out.printf("총점 %d 평균 %.2f", d,e);
  scanner.close();
	}
}
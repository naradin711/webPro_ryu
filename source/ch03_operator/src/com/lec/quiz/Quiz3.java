package com.lec.quiz;
//퀴즈 두 숫자를 입력받아서 두 수가 같은지 결과를 O나 X로 출력
//     첫번째 숫자가 더 큰지 결과를 O나 X로 출력한다.
import java.util.Scanner;

public class Quiz3 {
	public static void main (String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.print("첫번째 숫자를 입력하세요 : ");
  int i = scanner.nextInt(); // 사용자로부터 정수 입력 대기
  System.out.print("두번째 숫자를 입력하세요 : ");
  int k = scanner.nextInt(); // 사용자로부터 정수 입력 대기
  String result = ((i==k) ? "O" : "X"); 
  System.out.println(result);
  String result2 = ((i>k) ? "O" : "X"); 
  System.out.println(result2);
  scanner.close();
	}
}
package com.lec.quiz;
//나이를 입력받아 입력받은 나이가 65세 이상일 때, 경로우대 아니면 일반
import java.util.Scanner;

public class Quiz4 {
	public static void main (String[] args) {
  Scanner scanner = new Scanner(System.in);
  System.out.print("귀하의 나이를 입력하세요 : ");
  int i = scanner.nextInt(); // 사용자로부터 정수 입력 대기 
  String result = i>=65 ? "경로우대" : "일반";
  System.out.println(result);
  scanner.close();
	}
}
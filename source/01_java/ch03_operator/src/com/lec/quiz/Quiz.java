package com.lec.quiz;
//퀴즈 사용자로부터 입력받은 수가 3의 배수인지 여부 출력
import java.util.Scanner;

public class Quiz {
	public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("숫자를 입력하세요 : ");
    int su = scanner.nextInt(); // 사용자로부터 정수 입력 대기 
    String result = su%3 == 0 ? "입력하신 숫자는 3의 배수입니다." : "입력하신 숫자는 3의 배수가 아닙니다.";
    System.out.println(result);
    scanner.close();
	}
}
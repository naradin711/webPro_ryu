package com.lec.quiz;
//입력한 수가 짝수인지 홀수인지 출력
import java.util.Scanner;

public class Quiz2 {
	public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("숫자를 입력하세요 : ");
    int i = scanner.nextInt(); // 사용자로부터 정수 입력 대기 
    String result = i%2 == 0 ? "짝수" : "홀수";
    System.out.println(result);
    scanner.close();
	}
}
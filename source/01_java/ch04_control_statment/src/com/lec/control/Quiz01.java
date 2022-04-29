package com.lec.control;
import java.util.Scanner;
// 수를 입력 받아 절대값을 출력하는 프로그램
public class Quiz01 {
	public static void main (String[] args) {
	      int i = 10;
	      Scanner sc = new Scanner(System.in);
	      System.out.print("숫자를 입력하세요. : ");
	      int num1 = sc.nextInt();
	      System.out.println("입력하신 숫자의 절대값은 " + num1 +" 입니다.");
	}      
}
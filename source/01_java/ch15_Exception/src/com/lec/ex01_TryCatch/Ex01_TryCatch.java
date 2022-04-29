package com.lec.ex01_TryCatch;
import java.util.Scanner;
public class Ex01_TryCatch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사칙연산할 첫번째 수는?");
		int i = scanner.nextInt();
		System.out.print("사칙연산할 두번째 수는 ?");
		int j = scanner.nextInt();
		System.out.println("i = " + i + ", j = " + j);
		System.out.println("i * j = " + (i*j));
		System.out.println("i / j = " + (i/j)); // 예외가 발생할 수 있는 부분
		System.out.println("i + j = " + (i+j));
		System.out.println("i - j = " + (i-j));
		System.out.println("DONE");
		scanner.close();
	}
}

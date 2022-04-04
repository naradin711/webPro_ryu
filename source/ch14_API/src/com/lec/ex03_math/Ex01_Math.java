package com.lec.ex03_math;

import java.util.Scanner;

public class Ex01_Math {
	public static void main(String[] args) {
		int a = 2, b = 10;
		System.out.println("2의 10승은? "+ Math.pow(a, b));
		                                //pow a b a의 b승
		Scanner sc = new Scanner(System.in);
		System.out.println("입력한 수의 절대값은? " + Math.abs(-9.9));
		System.out.println("4의 제곱근은? " + Math.sqrt(4));
		System.out.println("a와 b 중 최소값은?"+ Math.min(a, b));
		System.out.println("a와 b 중 최대값은?"+ Math.max(a, b));
		//Math의 변수 (static final 변수)
		System.out.println("PI의 값은? " + Math.PI);
	}

}

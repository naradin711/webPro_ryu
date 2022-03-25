package com.lec.ex01_string;
import java.util.Scanner;
public class Ex05_Tel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tel;
		do {
			System.out.print("1 전화번호 | 2  짝수번째 문자열 | 3 문자를 거꾸로 | 4 전화번호 맨 앞자리 | 5 전화번호  맨 뒤자리 | X 종료");
			tel = sc.next();
			switch(tell) {
			
			}	
		}while(!tel.equalsIgnoreCase("x")); // do while 구문
		System.out.println("DONE");
	}

}

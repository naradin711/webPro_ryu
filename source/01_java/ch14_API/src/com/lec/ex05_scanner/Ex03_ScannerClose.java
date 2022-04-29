package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex03_ScannerClose {

	public static void main(String[] args) {
		// BookLib 객체 만들어서 사용자에게 대출 or 반납.
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름 ? ");
		String name = scMain.nextLine();
		System.out.println("입력하신 이름은 "+name);
		nickName();
		System.out.print("나이 ? ");
		int age = scMain.nextInt();
		System.out.println("입력하신 나이는 "+age+"살");
		scMain.close();

	}//main

	private static void nickName() {
		Scanner scNick = new Scanner(System.in);
	    System.out.print("별명은 ? ");
	    System.out.println("입력하신 별명은 "+scNick.nextLine());
	   // scNick.close();// 버퍼는 메인 함수 제일 끝에서만 닫아야 한다.
	}// method

}//class

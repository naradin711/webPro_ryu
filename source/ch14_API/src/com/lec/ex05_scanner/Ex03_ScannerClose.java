package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex03_ScannerClose {

	public static void main(String[] args) {
		// BookLib ��ü ���� ����ڿ��� ���� or �ݳ�.
		Scanner scMain = new Scanner(System.in);
		System.out.print("�̸� ? ");
		String name = scMain.nextLine();
		System.out.println("�Է��Ͻ� �̸��� "+name);
		nickName();
		System.out.print("���� ? ");
		int age = scMain.nextInt();
		System.out.println("�Է��Ͻ� ���̴� "+age+"��");
		scMain.close();

	}//main

	private static void nickName() {
		Scanner scNick = new Scanner(System.in);
	    System.out.print("������ ? ");
	    System.out.println("�Է��Ͻ� ������ "+scNick.nextLine());
	   // scNick.close();// ���۴� ���� �Լ� ���� �������� �ݾƾ� �Ѵ�.
	}// method

}//class

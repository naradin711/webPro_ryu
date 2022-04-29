package com.lec.ex05_scanner;

import java.util.Scanner;

public class Ex01_NextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		   System.out.print("나이를 입력하세요 : ");
		   int age = sc.nextInt();//\n 앞의 정수를 가져온다.
		   System.out.println("입력하신 나이는 "+age);
		   
		   System.out.print("이름을 입력하세요 : ");
		   String name = sc.next();//whitespace앞까지만 리턴
		   System.out.println("입력하신 이름은 "+name);
		   
		   System.out.print("주소를 입력하세요 : ");
		   sc.nextLine(); // 버프에 남아있는 \n 을 지우는 목적
		   String address = sc.nextLine(); // \n 엔터 앞에 있는 값을 리턴하고 
		   System.out.println("입력하신 주소는 "+address);
		   sc.close();
	}
   
}

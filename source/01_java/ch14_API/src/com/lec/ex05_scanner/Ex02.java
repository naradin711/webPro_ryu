package com.lec.ex05_scanner;
import java.util.Scanner;
public class Ex02 {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   System.out.print("주소를 입력하세요 : ");
	   String address = sc.nextLine(); // \n 엔터 앞에 있는 값을 리턴하고 
	   System.out.println("입력하신 주소는 "+address);
   }
}

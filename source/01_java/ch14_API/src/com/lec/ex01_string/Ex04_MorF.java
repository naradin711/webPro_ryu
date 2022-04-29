package com.lec.ex01_string;

import java.util.Scanner;

public class Ex04_MorF {
   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  String sn;
	  System.out.print("귀하의 주민등록번호를 입력하세요. : ");
	  sn = sc.next();
	  System.out.println((sn.indexOf('2',7))==7 ? "고객님은 여성입니다. " :"고객님은 남성입니다. " );
	  System.out.println((sn.indexOf('4',7))==7 ? "고객님은 여성입니다. " :"고객님은 남성입니다. " );
  }
}

package com.lec.test;
import java.util.Scanner;
//구구단 수 입력받아 해당 구구단 출력되는 화면
public class Test_week1 {
	public static void main (String []args) {
		  Scanner sc = new Scanner(System.in);
		  System.out.print(" 원하시는 구구단의 단수를 입력하세요 :  ");
		  int dansu = sc.nextInt();
		  for(int i=1 ; i<10; i++) {
			  int j = dansu*i;
			  System.out.print(dansu +"*"+i+"="+j+"\t");
		  }
		  sc.close();
}
}
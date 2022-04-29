package com.lec.control;
// 가위바위보 내고 낸 것을 출력해보기
import java.util.Scanner;

public class Quiz04 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("가위! 바위! 보! : ");
	      int num1 = sc.nextInt();
	      if (num1 ==0) {
	    	  System.out.print("\n가위");
	      }
	      else if (num1 ==1) {
	    	  System.out.print("\n바위");
	      }
	      else if (num1 ==2) {
	    	  System.out.print("\n보");
	      }
	      else 
	    	  System.out.print("\n장난하지 마세요!");
	      
	      sc.close();
}
}
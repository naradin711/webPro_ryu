package com.lec.ex01_string;

import java.util.Scanner;

public class Ex03_equal {
   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  String fn;
	  do {
		  System.out.print("I : input | U : update | X : exit  ");
		  fn = sc.next(); // Xx Ii Uu etc
		  switch(fn) {
		  case "i" :
		  case "I" :  
			  System.out.println("input ������ ���� ��.");
			  break;
		  case "u" :
		  case "U" :  
			  System.out.println("update ������ ���� ��.");
			  break;
		  }
	  }while(!fn.equalsIgnoreCase("x")); //��ҹ��� ������� x�� �������� �ʴ´ٸ�!
	   System.out.println("DONE");
  }
}

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
			  System.out.println("input 로직이 있을 곳.");
			  break;
		  case "u" :
		  case "U" :  
			  System.out.println("update 로직이 있을 곳.");
			  break;
		  }
	  }while(!fn.equalsIgnoreCase("x")); //대소문자 상관없이 x를 무시하지 않는다면!
	   System.out.println("DONE");
  }
}

package com.lec.control;
import java.util.Scanner;
// 키보드로부터 점수를 입력 받아 학점을 출력하는 프로그램을 작성 (if, switch)
public class Ex01_Switch {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("점수를 입력하세요 : ");
	    int score = sc.nextInt();
	    if (90<=score && score<=100) {
	        System.out.println("A학점");
	        System.out.println("Excellent!");
	    }
	    else if (80<=score && score<=90) {
		    System.out.println("B학점");
		    System.out.println("Good job!");
		    }
	    else if (70<=score && score<=80) {
		    System.out.println("C학점");
		    System.out.println("Not bad.");
		    }
	    else if (60<=score && score<=70) {
		    System.out.println("D학점");
		    System.out.println("That's no-no.");
		    }
	    else if (0<=score && score<=60) {
		    System.out.println("F학점");
		    System.out.println("Get out!");
		    }
	    else {
	    	System.out.println("Not available.");
	    }
	    sc.close();
}
}
package com.lec.control;
import java.util.Scanner;
// Ű����κ��� ������ �Է� �޾� ������ ����ϴ� ���α׷��� �ۼ� (if, switch)
public class Ex01_Switch {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("������ �Է��ϼ��� : ");
	    int score = sc.nextInt();
	    if (90<=score && score<=100) {
	        System.out.println("A����");
	        System.out.println("Excellent!");
	    }
	    else if (80<=score && score<=90) {
		    System.out.println("B����");
		    System.out.println("Good job!");
		    }
	    else if (70<=score && score<=80) {
		    System.out.println("C����");
		    System.out.println("Not bad.");
		    }
	    else if (60<=score && score<=70) {
		    System.out.println("D����");
		    System.out.println("That's no-no.");
		    }
	    else if (0<=score && score<=60) {
		    System.out.println("F����");
		    System.out.println("Get out!");
		    }
	    else {
	    	System.out.println("Not available.");
	    }
	    sc.close();
}
}
package com.lec.control;

import java.util.Scanner;

public class Practice01 {
   public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int you, computer = ((int)(Math.random()*3));
	  System.out.print("가위, 바위, 보 중 하나를 입력하시오. : ");
	  you = sc.nextInt();
	  if (you==0) {
		  System.out.print("당신은 가위 \t\t");
	  }
	  else if (you==1) {
		  System.out.print("당신은 바위 \t\t");
	  }
	  else if (you==2) {
		  System.out.print("당신은 보 \t\t");
	  }
	  else {
		  System.out.print("잘못 입력하셨습니다.");
		  you =3;
	  }
	  if (you!=3) {
		  String msg = (computer==0) ? " 컴퓨터는 가위 " : (computer==1) ? " 컴퓨터는 바위 " : "컴퓨터는 보";
		  System.out.print(msg);
		  if ((you+1)%3 == computer) {
			  System.out.print(" 당신이 졌어요.");
		  }
		  else if (you == computer) {
			  System.out.print(" 비겼네요.");
		  }
		  else {
			  System.out.print(" 당신이 이겼어요.");
		  }
	  }
   }
}
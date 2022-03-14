package com.lec.loop;

import java.util.Scanner;

//컴퓨터와 가위바위보 게임을 내가 이길 때까지 무한반복하는 게임을 작성하시오.(단, 가위대신 0, 바위대신 1, 보대신 2)
public class Quiz05_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  int you, computer;
		  do {
			  computer = ((int)(Math.random()*3));
			  System.out.print("당신은 가위 바위 보 중 하나를 내세요.: ");
			  you = sc.nextInt(); // 정수를 입력받음.
			  if (you ==0) {
				  System.out.print("당신은 가위\t") ;
			  }
			  else if (you ==1) {
				  System.out.print("당신은 바위\t") ;
			  }
			  else if (you ==2) {
				  System.out.print("당신은 보\t") ;
			  }else {
				  System.out.println("당신은 잘못냈어요. 잘가!") ;
			      you = 3; // 끝내기 위한 조건
			  }
			  if (you!=3) { // 컴퓨터가 낸 것과 승패 출력
		          String msg = (computer==0) ? " 컴퓨터는 가위" : (computer == 1) ? "컴퓨터는 바위" : "컴퓨터는 보";
		          System.out.print(msg);
		          // 경우의 수는 3가지 : 졌다, 이겼다, 비겼다.
		          if ((you+1)%3 == computer) {
		        	  System.out.println(" 당신이 졌어요.");
		        	  break;
		          } else if (you==computer) {
		        	  System.out.println(" 비겼네요.");
		          } else {
		        	   System.out.println(" 당신이 이겼어요.");
		          }
			  }
		  }while(true); 
		  System.out.println("안녕히 가세요.");
	   }
	}
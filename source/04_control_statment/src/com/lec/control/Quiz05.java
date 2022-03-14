package com.lec.control;
// 컴퓨터에서 난수 만들기
import java.util.Scanner;
// 0 <=Math.random() <1
// 0 <=Math.random()*3 < 3
// 0 <=((int)(Math.random()*3)) 난수를 정수로 제한하기
public class Quiz05 {
   public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int you, computer = ((int)(Math.random()*3));
	  System.out.print("가위(0), 바위(1), 보(2) 중 하나 입력 : ");
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
          if (you ==0) {
        	  if (computer==0) {
        		  System.out.println(" 비겼다.");
        	  }
        	  else if (computer==1) {
        		  System.out.println(" 컴퓨터가 이겼다.");}
        	  else if (computer==2) {
            		  System.out.println(" 내가 이겼다.");
        	  }
          }else if (you ==2) {
            	  if (computer==0) {
            		  System.out.println(" 컴퓨터가 이겼다..");
            	  } else if (computer==1) {
            		  System.out.println(" 내가 이겼다.");
            	}else if (computer==2) {
                		  System.out.println(" 비겼다.");
            	  }
          }else if (you ==1) {
              if (computer==0) {
            		  System.out.println(" 내가 이겼다.");
            	  }
              else if (computer==1) {
            		  System.out.println(" 비겼다.");}
              else if (computer==2) {
                		  System.out.println(" 컴퓨터가 이겼다.");
            	  }
           }
         }//if you!=3
      
   }//main
}//class
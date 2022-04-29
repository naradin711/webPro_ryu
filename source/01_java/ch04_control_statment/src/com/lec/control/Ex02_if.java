package com.lec.control;
import java.util.Scanner;
// 사용자로부터 두 수를 입력 받아 첫번째 수가 더 큰지 두번째 수가 더 큰지 출력.
public class Ex02_if {
   public static void main (String[] args) {
      int i = 10;
      Scanner sc = new Scanner(System.in);
      System.out.print("첫번째 수를 입력하세요. : ");
      int num1 = sc.nextInt();
      System.out.print("두번째 수를 입력하세요. : ");
      int num2 = sc.nextInt();
      if(num1>num2) {
    	  System.out.println("첫번째 수가 " + (num1-num2)+"만큼 더 큽니다.");
    	  System.out.println("최대값 = "+num1 );
      }
      else if(num1<num2) {
    	  System.out.printf("두번째 수가 %d만큼 더 큽니다.\n" , (num2-num1));
    	  System.out.println("최대값 = "+num2 );
      }
      else {
    	  System.out.println("두 값이 같습니다.");
      }
      sc.close();
}
}
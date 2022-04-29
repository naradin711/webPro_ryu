package com.lec.loop;
import java.util.Scanner;
// do-while 문 : 우선 수행한 후 조건이 만족되면 수행 아니면 수행하지 않는다.
public class Ex08_Do_while {
	public static void main(String[] args) {
		   int num;
		   Scanner sc = new Scanner(System.in);
		   do {
			   System.out.print("반드시 짝수를 입력하시오. : ");
			   num = sc.nextInt();
		   }while(num%2!=0);
		   System.out.printf("입력하신 수는 %d이고 짝수입니다.", num);
		   sc.close();
	}
}
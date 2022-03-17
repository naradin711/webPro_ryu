package com.lec.homework;
import java.util.Scanner;
/*사용자로부터 수를 입력받아 절대값을 출력하는 로직을 구현하시오 
 * (단, 매개변수를 받아 절대값을 리턴하는 함수=메소드를 이용합니다)*/
public class TodayII {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int su = sc.nextInt();
		int result = abs(su);
		System.out.print("절대값은 "+result);
		sc.close();
	}
	public static int abs(int value) {
		return value>=0 ? value : -value;
	}
}

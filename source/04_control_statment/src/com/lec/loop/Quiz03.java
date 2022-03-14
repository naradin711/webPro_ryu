package com.lec.loop;
//5단 구구단을 출력해 보자.
public class Quiz03 {
	public static void main(String[] args) {
		
		for(int i=1 ; i<=9 ; i++) {
			int j = i*5;
			System.out.println("5*"+i+"="+j);
		// System.out.printf("5* %d = %d\n", i, i*5)
		}
}
}
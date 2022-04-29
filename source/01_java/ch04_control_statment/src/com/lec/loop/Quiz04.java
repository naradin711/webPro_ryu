package com.lec.loop;
//다음과 같은 출력 형식의 구구단을 출력하는 프로그램을 구현해보자.
public class Quiz04 {
	public static void main(String[] args) {
//     for(int i=1 ; i<10 ; i++) {
//		for(int j=2 ; j<10 ; i++) {
//		   System.out.printf("%d * %d = %d\t", j,i,j*i);
//}
//		System.out.println();
//}
		for(int i=2 ; i<=9 ; i++) {
			int j = i*1;
			System.out.print(i+"*1"+"="+j+"\t");	
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*2;
			System.out.print(i+"*2"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*3;
			System.out.print(i+"*3"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*4;
			System.out.print(i+"*4"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*5;
			System.out.print(i+"*5"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*6;
			System.out.print(i+"*6"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*7;
			System.out.print(i+"*7"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*8;
			System.out.print(i+"*8"+"="+j+"\t");
		}
		System.out.println();
		for(int i=2 ; i<=9 ; i++) {
			int j = i*9;
			System.out.print(i+"*9"+"="+j+"\t");
		}
}
}
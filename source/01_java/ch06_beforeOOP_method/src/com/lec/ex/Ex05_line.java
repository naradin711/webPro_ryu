package com.lec.ex;
/* ■■■■■■■■■■■■■■■■■
 *  Hello, World!
 *  ------------- printLine()
 *  Hello, Java!
 *  ~~~~~~~~~~~~~ printLine('~')
 *  Hello, Hong!
 * ■■■■■■■■■■■■■■■■■  
 */
public class Ex05_line {
	public static void main(String[] args) {
		printLine('■',50);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Hong!");
		printLine('■',40);
	}
	private static void printLine(char c, int cnt) {
		for(int i=0 ; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println(); // 얇은 '-' cnt개 출력하고 개행
	}
	private static void printLine(int cnt) {
		for(int i=0 ; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 얇은 '-' cnt개 출력하고 개행
	}
	private static void printLine(char c) { // 함수 오버로딩(같은 이름의 함수를 매개변수로 구분)
		for(int i=0 ; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println(); // 매개변수로 받은 c문자 30개 출력하고 개행
	}
	private static void printLine() { // 리턴타입이 없고 매개변수 없는 메소드(함수)
		for(int i=0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 얇은 '-' 30개 출력하고 개행
	}
}
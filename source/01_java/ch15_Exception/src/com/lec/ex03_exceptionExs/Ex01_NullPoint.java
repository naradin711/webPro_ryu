package com.lec.ex03_exceptionExs;

public class Ex01_NullPoint {
	public static void main(String[] args) {
		String greeting = "Hello";
		System.out.println(greeting.toUpperCase());
		greeting = null;
		System.out.println(greeting.toUpperCase());
	}
}
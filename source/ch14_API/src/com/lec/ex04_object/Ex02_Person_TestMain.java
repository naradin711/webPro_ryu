package com.lec.ex04_object;

public class Ex02_Person_TestMain {
	public static void main(String[] args) {
		Person p1 = new Person (950222256589L);
		Person p2 = new Person (950222256589L);
		Person p3 = null;
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		if(p1.equals(p2)) {
			System.out.println("p1과 p2는 같은 사람");
		}else {
			System.out.println("p1과 p2는 다른 사람");
		}
		if(p1==p2) {
			System.out.println("p1과 p2는 같은 주소");
		}else {
			System.out.println("p1과 p2는 다른 주소");
		}
	}

}

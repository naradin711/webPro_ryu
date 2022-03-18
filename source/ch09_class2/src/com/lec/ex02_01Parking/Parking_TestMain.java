package com.lec.ex02_01Parking;

public class Parking_TestMain {
   public static void main(String[] args) {
	System.out.println("*********************");
	Parking p = new Parking ("12러 1114", 9);
	Parking p1 = new Parking ("34가 1674", 16);
	p.out(); // 사용자에게 outtime 받기
	p1.out(20); // outtime 15로 받기
}

}

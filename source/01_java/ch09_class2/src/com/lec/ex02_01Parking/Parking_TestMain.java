package com.lec.ex02_01Parking;

public class Parking_TestMain {
   public static void main(String[] args) {
	System.out.println("*********************");
	Parking p = new Parking ("12�� 1114", 9);
	Parking p1 = new Parking ("34�� 1674", 16);
	p.out(); // ����ڿ��� outtime �ޱ�
	p1.out(20); // outtime 15�� �ޱ�
}

}

package com.lec.ex;
// 할당(대입연산자) : = += -= *= /= %=
public class OpeEx06 {
	public static void main (String[] args) {
	System.out.println("====할당(대입)연산자====");
	int n1 = 10;
	n1 += 10; // n1 = n1+10;
	System.out.println("n1 = "+n1);
	// n1 += 1; n1++; ++n1;
	n1 -= 10; // n1 = n1-10;
	n1 *= 10; // n1 = n1*10;
	int n2 = n1 = 10;
	System.out.println("n1="+n1+ "\t n2=" +10);
	
}
}
package com.lec.ex;
// �������� : ++ --
public class OpeEx02 {
	public static void main(String[] args) {
    int n1 = 10;
    int n2 = n1--; // n1���� �ϳ� �����Ѵ�.
   System.out.println("n1="+n1+"\t n2="+n2);
   // System.out.printf("1. n1 = %d, n2 = %d\n", n1, n2);
   n2 = ++n1; // n1���� �ϳ� ����
   System.out.println("n1="+n1+"\t n2="+n2);
	}
}
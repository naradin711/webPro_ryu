package com.lec.ex01_string;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
	   int i = 10;
	   String str1 = "Java";
	   String str2 = "Java";
	   // String�� new�� �������� �ʰ� "" �� ����� ���ڿ� ����� ���. �ڵ����� �������� String ��ü�� �̹� �����ϴ��� Ȯ���ϰ� 
	   // ���࿡ �ش� ��ü�� �����ϸ� �ش� ���ڿ� ��ü�� ����. �������� ������ String ��ü ����
	   String str3 = new String("Java");
       if (str1==str2) { // ���� �ּ� ���� ������ �ֽ��ϴ�.
    	   System.out.println("str1�� str2�� ���� �ּҰ��� �ֽ��ϴ�.");
       }else {
    	   System.out.println("str1�� str2�� �ٸ� �ּҰ��� �ֽ��ϴ�.");
       }
       if (str1.equals(str2)) {
    	   System.out.println("str1�� str2�� ���� ���ڿ�.");
       }else {
    	   System.out.println("str1�� str2�� �ٸ� ���ڿ�.");
       }
       System.out.println(str1==str3? "str1�� str3�� ���� �ּ�" :"str1�� str3�� �ٸ� �ּ�" );
       System.out.println(str1.equals(str3)? "str1�� str3�� ���� ���ڿ�" :"str1�� str3�� �ٸ� ���ڿ�" );
       
	}//main

}

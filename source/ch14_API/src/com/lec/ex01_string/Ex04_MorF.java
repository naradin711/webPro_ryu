package com.lec.ex01_string;

import java.util.Scanner;

public class Ex04_MorF {
   public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  String sn;
	  System.out.print("������ �ֹε�Ϲ�ȣ�� �Է��ϼ���. : ");
	  sn = sc.next();
	  System.out.println((sn.indexOf('2',7))==7 ? "������ �����Դϴ�. " :"������ �����Դϴ�. " );
	  System.out.println((sn.indexOf('4',7))==7 ? "������ �����Դϴ�. " :"������ �����Դϴ�. " );
  }
}

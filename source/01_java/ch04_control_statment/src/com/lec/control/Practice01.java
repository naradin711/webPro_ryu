package com.lec.control;

import java.util.Scanner;

public class Practice01 {
   public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int you, computer = ((int)(Math.random()*3));
	  System.out.print("����, ����, �� �� �ϳ��� �Է��Ͻÿ�. : ");
	  you = sc.nextInt();
	  if (you==0) {
		  System.out.print("����� ���� \t\t");
	  }
	  else if (you==1) {
		  System.out.print("����� ���� \t\t");
	  }
	  else if (you==2) {
		  System.out.print("����� �� \t\t");
	  }
	  else {
		  System.out.print("�߸� �Է��ϼ̽��ϴ�.");
		  you =3;
	  }
	  if (you!=3) {
		  String msg = (computer==0) ? " ��ǻ�ʹ� ���� " : (computer==1) ? " ��ǻ�ʹ� ���� " : "��ǻ�ʹ� ��";
		  System.out.print(msg);
		  if ((you+1)%3 == computer) {
			  System.out.print(" ����� �����.");
		  }
		  else if (you == computer) {
			  System.out.print(" ���׿�.");
		  }
		  else {
			  System.out.print(" ����� �̰���.");
		  }
	  }
   }
}
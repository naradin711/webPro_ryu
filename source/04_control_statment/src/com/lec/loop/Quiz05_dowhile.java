package com.lec.loop;

import java.util.Scanner;

//��ǻ�Ϳ� ���������� ������ ���� �̱� ������ ���ѹݺ��ϴ� ������ �ۼ��Ͻÿ�.(��, ������� 0, ������� 1, ����� 2)
public class Quiz05_dowhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		  int you, computer;
		  do {
			  computer = ((int)(Math.random()*3));
			  System.out.print("����� ���� ���� �� �� �ϳ��� ������.: ");
			  you = sc.nextInt(); // ������ �Է¹���.
			  if (you ==0) {
				  System.out.print("����� ����\t") ;
			  }
			  else if (you ==1) {
				  System.out.print("����� ����\t") ;
			  }
			  else if (you ==2) {
				  System.out.print("����� ��\t") ;
			  }else {
				  System.out.println("����� �߸��¾��. �߰�!") ;
			      you = 3; // ������ ���� ����
			  }
			  if (you!=3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
		          String msg = (computer==0) ? " ��ǻ�ʹ� ����" : (computer == 1) ? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ��";
		          System.out.print(msg);
		          // ����� ���� 3���� : ����, �̰��, ����.
		          if ((you+1)%3 == computer) {
		        	  System.out.println(" ����� �����.");
		        	  break;
		          } else if (you==computer) {
		        	  System.out.println(" ���׿�.");
		          } else {
		        	   System.out.println(" ����� �̰���.");
		          }
			  }
		  }while(true); 
		  System.out.println("�ȳ��� ������.");
	   }
	}
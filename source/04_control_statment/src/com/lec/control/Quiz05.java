package com.lec.control;
// ��ǻ�Ϳ��� ���� �����
import java.util.Scanner;
// 0 <=Math.random() <1
// 0 <=Math.random()*3 < 3
// 0 <=((int)(Math.random()*3)) ������ ������ �����ϱ�
public class Quiz05 {
   public static void main (String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int you, computer = ((int)(Math.random()*3));
	  System.out.print("����(0), ����(1), ��(2) �� �ϳ� �Է� : ");
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
          if (you ==0) {
        	  if (computer==0) {
        		  System.out.println(" ����.");
        	  }
        	  else if (computer==1) {
        		  System.out.println(" ��ǻ�Ͱ� �̰��.");}
        	  else if (computer==2) {
            		  System.out.println(" ���� �̰��.");
        	  }
          }else if (you ==2) {
            	  if (computer==0) {
            		  System.out.println(" ��ǻ�Ͱ� �̰��..");
            	  } else if (computer==1) {
            		  System.out.println(" ���� �̰��.");
            	}else if (computer==2) {
                		  System.out.println(" ����.");
            	  }
          }else if (you ==1) {
              if (computer==0) {
            		  System.out.println(" ���� �̰��.");
            	  }
              else if (computer==1) {
            		  System.out.println(" ����.");}
              else if (computer==2) {
                		  System.out.println(" ��ǻ�Ͱ� �̰��.");
            	  }
           }
         }//if you!=3
      
   }//main
}//class
package com.lec.control;
import java.util.Scanner;
// ����ڷκ��� �� ���� �Է� �޾� ù��° ���� �� ū�� �ι�° ���� �� ū�� ���.
public class Ex02_if {
   public static void main (String[] args) {
      int i = 10;
      Scanner sc = new Scanner(System.in);
      System.out.print("ù��° ���� �Է��ϼ���. : ");
      int num1 = sc.nextInt();
      System.out.print("�ι�° ���� �Է��ϼ���. : ");
      int num2 = sc.nextInt();
      if(num1>num2) {
    	  System.out.println("ù��° ���� " + (num1-num2)+"��ŭ �� Ů�ϴ�.");
    	  System.out.println("�ִ밪 = "+num1 );
      }
      else if(num1<num2) {
    	  System.out.printf("�ι�° ���� %d��ŭ �� Ů�ϴ�.\n" , (num2-num1));
    	  System.out.println("�ִ밪 = "+num2 );
      }
      else {
    	  System.out.println("�� ���� �����ϴ�.");
      }
      sc.close();
}
}
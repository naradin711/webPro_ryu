package com.lec.method;
// Arithmetic.sum / evenOdd (static �޼ҵ�) vs. abs (�Ϲ� �޼ҵ�)
public class Ex03 {
   public static void main(String[] args) {
	   Arithmetic ar = new Arithmetic();
	   // ���� ��Ű������ static ���� �Լ��� �����ϱ� ���ؼ� ������ �������� ����.
	   int tot = ar.sum(7);	
      // ���� ��Ű���϶� �ٸ� �ٷ��̿��� �޼ҵ� �����Ű��
      // public�� ���� ���� ��� �ƹ��͵� ������ ���� ��Ű������ ���� ����.
      System.out.println("1~7���� ���� " + tot );
      System.out.println(tot +"��"+ ar.evenOdd(tot) );
      System.out.println(ar.abs(-7));
   }
}

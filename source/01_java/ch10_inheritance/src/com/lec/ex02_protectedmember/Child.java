package com.lec.ex02_protectedmember;

public class Child extends SuperIJ {
   private int total;
   public Child( ) {
	   System.out.println("�Ű����� ���� Child ������");
   }
   // Child c = new Child(10, 20);
   public Child(int i, int j) {
	   setI(i); //this.i=i;
	   setJ(j);
	   System.out.println("�Ű����� �ִ� Child ������");
   }
   public void sum( ) {
	  total = getI() + getJ(); //total = I + J
	  System.out.printf("�� ��ü�� i=%d, j=%d.",getI(),getJ());
	  System.out.printf("�� ��ü�� total=%d", total);
   }
   
}

package com.lec.ex08_superdot;
//super.  = �� �θ� Ŭ������
//super() = �� �θ� Ŭ������ ������ �Լ�.
public class ParentClass {
   private int i = 20;
   public ParentClass( ) {
	   System.out.println("ParentClass ������");
   }
   public void method () {
	   System.out.println("ParentClass�� method super���� i�� "+i);
   }
   public int getI() {
	   return i;
   }
   public void setI(int i) {
	   this.i = i;
   }
}

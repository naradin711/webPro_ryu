package com.lec.ex02_protectedmember;
// ������ ������ �޼ҵ� - �������̵� �޼ҵ�! getter setter �ݵ�� �� ������� Ŭ������ ������ ��!
public class SuperIJ {
   private int i;
   private int j;
   // ��ӹ��� Ŭ�������� Super Ŭ���� �θ�� ������ �Լ��� ���� ȣ��. 
   public SuperIJ ( ) {
	   System.out.println("�Ű� ���� ���� Super IJ ������ �Լ�.");
   }
   public SuperIJ (int i, int j ) {
	   System.out.println("�Ű� ���� �ִ� Super IJ ������ �Լ��� i, j�� �ʱ�ȭ.");
   }
protected int getI() {
	return i;
}
protected void setI(int i) {
	this.i = i;
}
protected int getJ() {
	return j;
}
public void setJ(int j) {
	this.j = j;
}
  
}  


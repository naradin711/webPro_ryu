package com.lec.ex05_momchild;

public class ChildTestMain {
   public static void main(String[] args) {
	  Child c1 = new Child ("����");
	  Child c2 = new Child ("¯��");
	  Child c3 = new Child ("������");
	  c1.takemoney(1000);
	  c2.takemoney(500);
	  c3.takemoney(800);
	  System.out.println(Child.momPouch.money); // Ŭ���� �̸��� ���ؼ� �׼���
	  System.out.println(c1.momPouch.money); // static�� ������ �����ϴ� ����.
   }

}

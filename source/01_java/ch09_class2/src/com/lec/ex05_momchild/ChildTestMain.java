package com.lec.ex05_momchild;

public class ChildTestMain {
   public static void main(String[] args) {
	  Child c1 = new Child ("페이");
	  Child c2 = new Child ("짱구");
	  Child c3 = new Child ("노진구");
	  c1.takemoney(1000);
	  c2.takemoney(500);
	  c3.takemoney(800);
	  System.out.println(Child.momPouch.money); // 클래스 이름을 통해서 액세스
	  System.out.println(c1.momPouch.money); // static의 목적은 공유하는 목적.
   }

}

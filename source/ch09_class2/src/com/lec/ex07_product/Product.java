package com.lec.ex07_product;

public class Product {
   private int serialNo; // 객체고유의 번호 101, 102, ad24353 .......
   public static int count = 100; 
   //객체가 만들어질 때 맨 처음 클래스에 데이터가 잡힌다.
   public Product ( ) {
      serialNo = ++count;  // 여기서 고유번호 serialNo가 공유변수의 영향을 받음.
   }
   public void infoPrint() {
	  System.out.println("serialNo = "+ serialNo + "\t 공유변수 count = " + count);
   }
   
   
}

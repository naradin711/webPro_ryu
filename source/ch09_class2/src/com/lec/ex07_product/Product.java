package com.lec.ex07_product;

public class Product {
   private int serialNo; // ��ü������ ��ȣ 101, 102, ad24353 .......
   public static int count = 100; 
   //��ü�� ������� �� �� ó�� Ŭ������ �����Ͱ� ������.
   public Product ( ) {
      serialNo = ++count;  // ���⼭ ������ȣ serialNo�� ���������� ������ ����.
   }
   public void infoPrint() {
	  System.out.println("serialNo = "+ serialNo + "\t �������� count = " + count);
   }
   
   
}

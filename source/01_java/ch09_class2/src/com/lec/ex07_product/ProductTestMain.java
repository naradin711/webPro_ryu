package com.lec.ex07_product;

public class ProductTestMain {
   public static void main(String[] args) {
	  Product p1 = new Product();
	  p1.infoPrint();
	  Product p2 = new Product();
	  p2.infoPrint();
	  System.out.println("static ���� = Ŭ���� ���� = �������� (�ϸ� ��α�) count : " + Product.count );
	  
  }
}

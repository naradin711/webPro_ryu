package com.lec.ex4_boxorrect;

public class BoxOrRectTestMain {
   public static void main(String[] args) {
	   Boxorrect box = new Boxorrect(5,6,10);
	   Boxorrect rect = new Boxorrect(5,8);
	   box.vPrint();
	   rect.vPrint();
	   System.out.println("�ڽ� ���Ǵ� " + box.getVolume());
	   System.out.println("���簢�� ���̴� " + rect.getVolume());
	
}
}

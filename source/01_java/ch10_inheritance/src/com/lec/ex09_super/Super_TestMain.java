package com.lec.ex09_super;
public class Super_TestMain {
   public static void main(String[] args) {
	  Person papa = new Person();
	  papa.setName("�ƺ���"); papa.setCharacter("�׶���");
	  papa.intro();
	  Person mom = new Person("������","������");
	  mom.intro();
	  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	  Baby c1 = new Baby();
	  c1.setName("�Ʊ��1"); c1.setCharacter("�ʹ� �Ϳ���");
	  c1.intro();
	  Baby c2 = new Baby("�Ʊ��2", "���� �Ϳ���");
 }
}

package com.lec.ex03_math;

import java.util.Random;
// 0<== Math.random() < 1
// 0<== Math.random()*45 < 45

public class Ex03_Random {
   public static void main(String[] args) {
	  System.out.println(Math.random());
	  System.out.println("0~45�̸��� ���� ���� : "+ (int)(Math.random()*45));
	  System.out.println("�ζ� ��ȣ �̱� : "+ (int)((Math.random()*45)+1));
	  Random random = new Random();
	  System.out.println("int ���� : "+random.nextInt());//���� ����
	  System.out.println("double ���� : "+random.nextDouble());//���� ���� Math.random�� ����
	  System.out.println("T/F ���� : "+random.nextBoolean());
	  System.out.println("0~2���� ���� ���� : "+random.nextInt(3)); // 0�̻� 3�̸��� ���� �ܼ�.
	  System.out.println("�ζǻ̱� : "+(random.nextInt(45)+1));
	  System.out.println("�ζ� ��ȣ �̱� : "+(random.nextInt(45)+1));
	  
	
}
}

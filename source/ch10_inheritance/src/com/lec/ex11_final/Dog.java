package com.lec.ex11_final;
// Animal�κ��� speed, running, stop ��ӹ���.
public class Dog extends Animal {
   @Override //���� �������̵� �Ұž�! 
   public void running() {
	  setSpeed(getSpeed()+ 10);
	  System.out.println("������ ���� �پ��. ����ӵ� : "+getSpeed());
   }
}

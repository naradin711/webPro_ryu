package com.lec.ex11_final;
//Animal���� speed. running(), stop ��ӹ���.
public final class Rabbit extends Animal {
   public void running( ) {
	  setSpeed(getSpeed()+30); // speed += 30;
	  System.out.println("���� �پ��! ���� �ӵ� : "+ getSpeed());
   }
}

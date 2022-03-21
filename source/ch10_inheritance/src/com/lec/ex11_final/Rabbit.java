package com.lec.ex11_final;
//Animal부터 speed. running(), stop 상속받음.
public final class Rabbit extends Animal {
   public void running( ) {
	  setSpeed(getSpeed()+30); // speed += 30;
	  System.out.println("마구 뛰어요! 현재 속도 : "+ getSpeed());
   }
}

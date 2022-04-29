package com.lec.ex11_final;
// Animal로부터 speed, running, stop 상속받음.
public class Dog extends Animal {
   @Override //이제 오버라이드 할거야! 
   public void running() {
	  setSpeed(getSpeed()+ 10);
	  System.out.println("꼬리를 흔들며 뛰어요. 현재속도 : "+getSpeed());
   }
}

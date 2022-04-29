package com.lec.ex04_Car;

public class LowGradeCar extends Car {
   private int tax = 50000;
   public LowGradeCar(String color, String tire, int displacement, String handle) {
	  super(color, tire, displacement, handle);
   }
	@Override
	public void getSpec() {// 스펙들 - 색상, 타이어, 배기량, 핸들, 세금을 출력
		if(getDisplacement()>1000) {
			tax+=(getDisplacement()-1000)*100;
		}
		System.out.println("************************");
		System.out.println("색   상 : "+getColor());
		System.out.println("타이어 : "+getTire());
		System.out.println("배기량 : "+getDisplacement());
		System.out.println("핸   들 : "+getHandle());
		System.out.println("세   금 : "+tax+"원");
		System.out.println("************************");

	}

}

package com.lec.ex04_actor;

public class Actor_TestMain {
	public static void main(String[] args) {
		Actor park = new Actor ("박보검");
		park.canSearch();
		park.catchPrisoner();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpagetti();
		IChef chefPark = new Actor("박요리사"); //앞에 있는 IChef가 특정 인터페이스만 가능하게 함.
		chefPark.makePizza();
		chefPark.makeSpagetti();
//		chefPark.saveMan(); saveMan 메소드는 실행이 불가능하다.
		IPoliceman polPark = new Actor("박경찰관");
		polPark.canSearch();
		IFireFighter firePark = new Actor("박소방관");
		firePark.outFire();
	}

}

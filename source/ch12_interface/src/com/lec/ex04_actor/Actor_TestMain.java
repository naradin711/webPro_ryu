package com.lec.ex04_actor;

public class Actor_TestMain {
	public static void main(String[] args) {
		Actor park = new Actor ("�ں���");
		park.canSearch();
		park.catchPrisoner();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpagetti();
		IChef chefPark = new Actor("�ڿ丮��"); //�տ� �ִ� IChef�� Ư�� �������̽��� �����ϰ� ��.
		chefPark.makePizza();
		chefPark.makeSpagetti();
//		chefPark.saveMan(); saveMan �޼ҵ�� ������ �Ұ����ϴ�.
		IPoliceman polPark = new Actor("�ڰ�����");
		polPark.canSearch();
		IFireFighter firePark = new Actor("�ڼҹ��");
		firePark.outFire();
	}

}

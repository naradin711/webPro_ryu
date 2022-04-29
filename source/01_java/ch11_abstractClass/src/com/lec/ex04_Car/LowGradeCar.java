package com.lec.ex04_Car;

public class LowGradeCar extends Car {
   private int tax = 50000;
   public LowGradeCar(String color, String tire, int displacement, String handle) {
	  super(color, tire, displacement, handle);
   }
	@Override
	public void getSpec() {// ����� - ����, Ÿ�̾�, ��ⷮ, �ڵ�, ������ ���
		if(getDisplacement()>1000) {
			tax+=(getDisplacement()-1000)*100;
		}
		System.out.println("************************");
		System.out.println("��   �� : "+getColor());
		System.out.println("Ÿ�̾� : "+getTire());
		System.out.println("��ⷮ : "+getDisplacement());
		System.out.println("��   �� : "+getHandle());
		System.out.println("��   �� : "+tax+"��");
		System.out.println("************************");

	}

}

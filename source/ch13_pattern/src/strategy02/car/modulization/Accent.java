package strategy02.car.modulization;

import strategy02.car.interfaces.*;

public class Accent extends Car {
	public Accent () {
	   setEngine(new EngineLow());
	   setKm(new Km20());
	   setFuel(new FuelDiesel());	   
	}
	@Override
	public void shape() {
		System.out.println("����Ʈ�� �ڵ�,  ��Ʈ,  ����� �̷���� �ֽ��ϴ�.");
	}

}

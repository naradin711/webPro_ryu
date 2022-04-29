package strategy02.car.modulization;

import strategy02.car.interfaces.*;

public class Sonata extends Car {
	public Sonata () {
	   setEngine(new EngineHybrid());
	   setKm(new Km20());
	   setFuel(new FuelGasoline());	   
	}
	@Override
	public void shape() {
		System.out.println("�ҳ�Ÿ�� �ڵ�,  ��Ʈ,  ����� �̷���� �ֽ��ϴ�.");
	}

}

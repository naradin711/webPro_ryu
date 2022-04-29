package strategy02.car.modulization;

import strategy02.car.interfaces.*;

public class Genesis extends Car {
	public Genesis () {
	   setEngine(new EngineHigh());
	   setKm(new Km10());
	   setFuel(new FuelGasoline());	   
	}
	@Override
	public void shape() {
		System.out.println("���׽ý��� �ڵ�,  ��Ʈ,  ����� �̷���� �ֽ��ϴ�.");
	}

}

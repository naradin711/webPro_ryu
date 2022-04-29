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
		System.out.println("소나타는 핸들,  시트,  도어로 이루어져 있습니다.");
	}

}

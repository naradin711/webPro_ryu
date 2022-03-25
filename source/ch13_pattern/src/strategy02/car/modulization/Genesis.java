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
		System.out.println("제네시스는 핸들,  시트,  도어로 이루어져 있습니다.");
	}

}

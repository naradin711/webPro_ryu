package strategy02.car.modulization;

import strategy02.car.interfaces.*;

public class Car_TestMain {
   public static void main(String[] args) {
	  Car  ac = new Accent();
	  Car  gn = new Genesis();
	  Car  so = new Sonata();
	  Car [] cars = {ac, gn, so};
	    for(Car c : cars) {
	    	c.drive();
	    	c.shape();
	    	c.listEngine();
	    	c.listKm();
	    	c.listFuel();
	    }
	    System.out.println("소나타를 하이브리드로 교체하고 연비를 20로 향상시킨다.");
	    so.setEngine(new EngineHybrid());
	    so.setKm(new Km20());
	    for(int idx = 0; idx<cars.length ; idx++) {
	    	cars[idx].shape();
	    	cars[idx].drive();
	    	cars[idx].listEngine();
	    	cars[idx].listFuel();
	    	cars[idx].listKm();
	    }
	     
}
}

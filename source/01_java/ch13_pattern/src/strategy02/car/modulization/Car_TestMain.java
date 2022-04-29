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
	    System.out.println("�ҳ�Ÿ�� ���̺긮��� ��ü�ϰ� ���� 20�� ����Ų��.");
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

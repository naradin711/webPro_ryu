package com.lec.ex04_Car;

import com.lec.cons.CarSpec;

public class TestMain {
   public static void main(String[] args) {
	  Car car = new LowGradeCar(CarSpec.GRAY_CAR, CarSpec.TIRE_NORMAL, CarSpec.DISPLACEMENT_1500, CarSpec.HANDLE_NORMAL);
      car.getSpec();
      Car c1 = new HighGradeCar(CarSpec.WHITE_CAR, CarSpec.TIRE_WIDE, CarSpec.DISPLACEMENT_2200, CarSpec.HANDLE_POWER);
      c1.getSpec();
   }
}

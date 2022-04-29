package com.lec.ex11_final;

public class Final_TestMain {
   public static void main(String[] args) {
	  Animal [] animals = {new Dog(), new Rabbit()};
//	  animals [0].running();
//	  animals [0].running();
//	  animals [0].stop();
//	  animals [1].running();
//	  animals [1].running();
//	  animals [1].stop();
	  for(Animal ani : animals) {
		  ani.running();
		  ani.running();
		  ani.stop();
	  }
   }
}

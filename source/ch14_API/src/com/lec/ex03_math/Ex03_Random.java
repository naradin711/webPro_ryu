package com.lec.ex03_math;

import java.util.Random;
// 0<== Math.random() < 1
// 0<== Math.random()*45 < 45

public class Ex03_Random {
   public static void main(String[] args) {
	  System.out.println(Math.random());
	  System.out.println("0~45미만의 정수 난수 : "+ (int)(Math.random()*45));
	  System.out.println("로또 번호 뽑기 : "+ (int)((Math.random()*45)+1));
	  Random random = new Random();
	  System.out.println("int 난수 : "+random.nextInt());//정수 난수
	  System.out.println("double 난수 : "+random.nextDouble());//더블 난수 Math.random과 유사
	  System.out.println("T/F 난수 : "+random.nextBoolean());
	  System.out.println("0~2사이 정수 난수 : "+random.nextInt(3)); // 0이상 3미만의 정수 단수.
	  System.out.println("로또뽑기 : "+(random.nextInt(45)+1));
	  System.out.println("로또 번호 뽑기 : "+(random.nextInt(45)+1));
	  
	
}
}

package com.lec.ex09_super;
public class Super_TestMain {
   public static void main(String[] args) {
	  Person papa = new Person();
	  papa.setName("¾Æºü°õ"); papa.setCharacter("¶×¶×ÇØ");
	  papa.intro();
	  Person mom = new Person("¾ö¸¶°õ","³¯¾ÀÇØ");
	  mom.intro();
	  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	  Baby c1 = new Baby();
	  c1.setName("¾Æ±â°õ1"); c1.setCharacter("³Ê¹« ±Í¿©¿ö");
	  c1.intro();
	  Baby c2 = new Baby("¾Æ±â°õ2", "Á¤¸» ±Í¿©¿ö");
 }
}

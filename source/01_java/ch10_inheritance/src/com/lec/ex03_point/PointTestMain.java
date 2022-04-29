package com.lec.ex03_point;

public class PointTestMain {
   public static void main(String[] args) {
	  Point point = new Point (5,5);
	  point.setX(10);
	  point.pointPrint();
	  System.out.println(point.infoString());
	  System.out.println(point); // object.toString(); 한 결과가 화면에 나옴.
}
}

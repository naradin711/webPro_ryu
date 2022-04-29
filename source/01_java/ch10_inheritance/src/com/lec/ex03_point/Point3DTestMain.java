package com.lec.ex03_point;

public class Point3DTestMain {
   public static void main(String[] args) {
	   Point point = new Point (5,5);
		  point.setX(10);
		  point.pointPrint();
		  System.out.println(point.infoString());
		  System.out.println(point); // object.toString(); 한 결과가 화면에 나옴.
          Point3D point3d = new Point3D (1,2,3);
          System.out.println(point3d.info3DString());
          System.out.println(point3d.infoString()); // 상속을 받으면 모든 메소드 생성자를 다받음.
          System.out.println(point3d);	 
}
}

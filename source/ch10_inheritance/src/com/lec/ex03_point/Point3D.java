package com.lec.ex03_point;
// Point3D p1 = new Point3D (20,10,5)
// p1.pointPrint();
public class Point3D extends Point {
   private int z;
   public Point3D() {}
   public Point3D(int x, int y, int z ) {
	 setX(x); setY(y);
	 this.z = z;
   } //p1.point3Dprint(), sysout(p1.info3DString()), sysout(p1)
   public void point3DPrint() {
	   System.out.println("3차원 좌표 : x="+getX()+", y="+getY()+",z ="+z);
   }
   public String info3DString() {
	   return "3차원 좌표 : x="+getX()+", y="+getY()+",z ="+z ;
   }
   public String toString() { // 오버라이드(함수의 재정의) = 상속받은 함수의 매개변수, 리턴타입 동일. .toString 함수를 재정의하다.
		return "3차원 좌표 : x="+getX()+", y="+getY()+",z ="+z ;
	}
}

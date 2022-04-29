package com.lec.ex04_object;

public class Point3D implements Cloneable {
   private double x;
   private double y;
   private double z;
   public Point3D () {
	   x = 0.0; y = 0.0; z = 0.0;
   }
   public Point3D(double x, double y, double z) {
	  this.x = x;
	  this.y = y;
	  this.z = z;
   }
   @Override
   public String toString() {
   	return "��ǥ����" + x+" " + y + " "+z ;
     }
   public boolean equals(Object obj) {
		  // c1.equals(c2) => c1�� ����ü, c2�� obj
		  if(obj !=null && obj instanceof Point3D) {// obj�� Person Ÿ���� ��ü
			  boolean xCk= (x == ((Point3D)obj).x);
			  boolean yCk= (y == ((Point3D)obj).y);
			  boolean zCk= (z == ((Point3D)obj).z);
			  
			  return xCk && yCk && zCk;
		  }else {
			  return false;
		  }
   }  
   protected Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
public double getX() {
	return x;
}
public void setX(double x) {
	this.x = x;
}
public double getY() {
	return y;
}
public void setY(double y) {
	this.y = y;
}
public double getZ() {
	return z;
}
public void setZ(double z) {
	this.z = z;
}
   
}

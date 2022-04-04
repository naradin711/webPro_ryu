package com.lec.ex04_object;
//Rectangle r1 = new Rectangle (10, 5, "����")
public class Rectangle implements Cloneable {
   private int width;
   private int height;
   private String color;
   public Rectangle () {
	   color ="����";
   }
   public Rectangle(int width, int height) {
	this.width = width;
	this.height = height;
	color ="����";
   }
   public Rectangle(int width, int height, String color) {
	this.width = width;
	this.height = height;
	this.color = color;
  } 
   public String toString() {
	 return "���� "+width+"cm, ����"+height+"cm�� "+color+"�� �簢��";
   //  return String.format("���� %dcm, ���� %dcm�� %�� �簢��", width, height, color) 
   }
   public boolean equals(Object obj) {
	   if(obj!= null && obj instanceof Rectangle) {
		  Rectangle temptObj = (Rectangle)obj;
		  boolean widthCk = width == temptObj.width;
		  boolean heightCk = height == temptObj.height;
		  boolean colorCk = color.equals(temptObj.color);
		  return widthCk && heightCk && colorCk;
	   }else {
		   return false; 
	   }	   
   }
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
		
	}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
     
}

package com.lec.ex03_shape;
//shape�� ���� Rect(w, h), Triangle(w, h), Circle(r)�� �� ������ ��.
public abstract class Shape {
   public void draw() {
	   String className = this.getClass().getName(); //com.lec.ex03_shape.Circle
	                                                 //com.lec.ex03_shape.Rect
	   System.out.println(this.getClass().getName()+"������ �׷���.");
   }
   public abstract double computeArea(); //�߻�޼ҵ�
}

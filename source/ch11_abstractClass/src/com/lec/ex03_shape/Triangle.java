package com.lec.ex03_shape;

public class Triangle extends Shape {
   private int w; //�غ�
   private int h; //����
   public Triangle () {}
   public Triangle(int w, int h) {
      this.w = w;
	  this.h = h;
   }

	@Override
	public double computeArea() {
		return w*h*0.5;
	}

}

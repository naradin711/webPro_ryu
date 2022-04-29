package com.lec.ex03_shape;

import com.lec.cons.Constant;

public class Circle extends Shape {
   private int r;
   public Circle(int r) {
	   this.r = r;
   }
   
	@Override
	public double computeArea() {
		return Constant.PI * r *r;
	}

}

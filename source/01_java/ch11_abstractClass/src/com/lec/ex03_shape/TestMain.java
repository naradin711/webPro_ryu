package com.lec.ex03_shape;
public class TestMain {
	public static void main(String[] args) {
		int [] arr = {1,2,3};
		Shape [] shape = {new Rectangle(10, 5), new Triangle(5,6), new Circle(5)};
		for(Shape shp : shape) {
			shp.draw();
			System.out.println("���� ���̴� "+shp.computeArea());
		}
	}

}

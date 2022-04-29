package com.lec.ex4_boxorrect;

public class Boxorrect { //변수
   private int width;
   private int height;
   private int depth; // box의 경우는 깊이, rect일 경우는 0
   private int volume; // box의 경우는 넓이, rect일 경우는 넓이.
   public Boxorrect() {} // 생성자 초기화
   public Boxorrect(int width, int height, int depth) {
	this.width = width;
	this.height = height;
	this.depth = depth;
	volume = width * height * depth ;
    }
   public Boxorrect(int width, int height) {
	this.width = width;
	this.height = height;
	volume = width * height;
    }
   public int getVolume() {
	   return volume;
	}
   public void vPrint() {
	  if(depth!=0) { //box
		System.out.println("부피는 " + volume);
	  }else { //rect
		System.out.println("넓이는 " + volume);
	  }
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
public int getDepth() {
	return depth;
}
public void setDepth(int depth) {
	this.depth = depth;
}
public void setVolume(int volume) {
	this.volume = volume;
}

   
   
}

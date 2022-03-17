package com.lec.ex4_boxorrect;

public class Boxorrect { //����
   private int width;
   private int height;
   private int depth; // box�� ���� ����, rect�� ���� 0
   private int volume; // box�� ���� ����, rect�� ���� ����.
   public Boxorrect() {} // ������ �ʱ�ȭ
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
		System.out.println("���Ǵ� " + volume);
	  }else { //rect
		System.out.println("���̴� " + volume);
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

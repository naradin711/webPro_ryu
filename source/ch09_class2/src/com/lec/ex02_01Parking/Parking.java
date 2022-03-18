package com.lec.ex02_01Parking;

import java.util.Scanner;

import com.lec.cons.Constant; // 해당하는 상수를 상수만을 모아놓은 폴더로 import 시켜서 언제든지 활용한다. 

public class Parking {
   private String no;
   private int inTime;
   private int outTime;
   private int fee;
   public Parking () {}
   public Parking (String no, int inTime) {
	   this.no = no;
	   this.inTime = inTime;
	   System.out.print('"'+no+'"'+"님 어서오세요.\n"+"입차시간 : "+inTime+"시\n");
	   System.out.println("*********************");
   }
   public void out() {
		Scanner sc = new Scanner(System.in);
		System.out.print("몇시에 출차하고 계신가요? : ");
		outTime = sc.nextInt();
		out(outTime);
		   sc.close();
	}
   public void out (int outTime) {
	   int fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
	   System.out.print('"'+no+'"'+"님 안녕히 가세요.\n"+"* 입차시간 : "+inTime+"시\n"+"* 출차시간 : "+outTime+"시\n"+"* 주차요금 : "+fee+"원\n");
	   System.out.println("*********************");
   }
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
}
public int getInTime() {
	return inTime;
}
public void setInTime(int inTime) {
	this.inTime = inTime;
}
public int getOutTime() {
	return outTime;
}
public void setOutTime(int outTime) {
	this.outTime = outTime;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
   
}

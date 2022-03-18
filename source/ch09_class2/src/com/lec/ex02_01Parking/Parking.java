package com.lec.ex02_01Parking;

import java.util.Scanner;

import com.lec.cons.Constant; // �ش��ϴ� ����� ������� ��Ƴ��� ������ import ���Ѽ� �������� Ȱ���Ѵ�. 

public class Parking {
   private String no;
   private int inTime;
   private int outTime;
   private int fee;
   public Parking () {}
   public Parking (String no, int inTime) {
	   this.no = no;
	   this.inTime = inTime;
	   System.out.print('"'+no+'"'+"�� �������.\n"+"�����ð� : "+inTime+"��\n");
	   System.out.println("*********************");
   }
   public void out() {
		Scanner sc = new Scanner(System.in);
		System.out.print("��ÿ� �����ϰ� ��Ű���? : ");
		outTime = sc.nextInt();
		out(outTime);
		   sc.close();
	}
   public void out (int outTime) {
	   int fee = (outTime-inTime) * Constant.HOURLYPARKINGRATE;
	   System.out.print('"'+no+'"'+"�� �ȳ��� ������.\n"+"* �����ð� : "+inTime+"��\n"+"* �����ð� : "+outTime+"��\n"+"* ������� : "+fee+"��\n");
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

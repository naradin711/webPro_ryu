package com.lec.ex04_object;
//Staff s1 = new Staff ("a01", "ȫ�浿", Dept.COMPUTER) - ���� �Ի���
//Staff s2 = new Staff ("a02", "�ű浿", Dept.HUMANRESOURCE, 2022,3,24) - 3�� 24�� �Ի���
//System.out.println(s1) +> [���] [�̸�] [�μ�] [�Ի���]

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Staff {
   private String num;  //���
   private String name; //�̸�
   private String dept; //�μ�
   private Date hireDate; // �Ի���
   public Staff (String num, String name, String dept) {
	   this.num = num;
	   this.name = name;
	   this.dept = dept;
	   hireDate = new Date();
   }
   public Staff (String num, String name, String dept, int y, int m, int d) {
	   this.num = num;
	   this.name = name;
	   this.dept = dept;
	   //hireDate = new Date(y-1900, m-1, d);//�Ի����� y�� m�� d��
	   hireDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	  
   }
      
@Override
public String toString() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� (E)");
	String hdStr = sdf.format(hireDate);
	if (dept.length()>10) {
	return "[���] : " + num + "\t[�̸�] : " + name + "\t [�μ�]" + dept + "\t[�Ի���] : " + hdStr;
	}else {
		return "[���] : " + num + "\t[�̸�] : " + name + "\t [�μ�]" + dept + "\t\t[�Ի���] : " + hdStr;	
	}
	}
public String getNum() {
	return num;
}
public void setNum(String num) {
	this.num = num;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public Date getHireDate() {
	return hireDate;
}
public void setHireDate(Date hireDate) {
	this.hireDate = hireDate;
}
      
}

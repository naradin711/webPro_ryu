package com.lec.ex04_object;
//Staff s1 = new Staff ("a01", "홍길동", Dept.COMPUTER) - 오늘 입사일
//Staff s2 = new Staff ("a02", "신길동", Dept.HUMANRESOURCE, 2022,3,24) - 3월 24일 입사일
//System.out.println(s1) +> [사번] [이름] [부서] [입사일]

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Staff {
   private String num;  //사번
   private String name; //이름
   private String dept; //부서
   private Date hireDate; // 입사일
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
	   //hireDate = new Date(y-1900, m-1, d);//입사일을 y년 m월 d일
	   hireDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	  
   }
      
@Override
public String toString() {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E)");
	String hdStr = sdf.format(hireDate);
	if (dept.length()>10) {
	return "[사번] : " + num + "\t[이름] : " + name + "\t [부서]" + dept + "\t[입사일] : " + hdStr;
	}else {
		return "[사번] : " + num + "\t[이름] : " + name + "\t [부서]" + dept + "\t\t[입사일] : " + hdStr;	
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

package com.lec.ex10_customer;
// name, tel, hiredate, department
// Staff s = new Staff ("홍", "010", "2019-03-16", "개발팀")
public class Staff extends Person {
   private String hiredate; // 곧 Date 함수로 변경할 예정
   private String department;
   public Staff(String name, String tel) {
		super(name, tel);
	}
public Staff(String name, String tel, String hiredate, String department) {
	super(name, tel);
	this.hiredate = hiredate;
	this.department = department;
    } 
// sysout(s.infoString) = [이름] 홍 [전화] 010 [입사일] 2019 03 16 [부서] 개발팀.
    @Override
public String infoString() {
    return super.infoString()+" [입사일] : "+hiredate+" [부서] : "+department;
    }

}

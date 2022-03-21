package com.lec.ex10_customer;
// name, tel, hiredate, department
// Staff s = new Staff ("ȫ", "010", "2019-03-16", "������")
public class Staff extends Person {
   private String hiredate; // �� Date �Լ��� ������ ����
   private String department;
   public Staff(String name, String tel) {
		super(name, tel);
	}
public Staff(String name, String tel, String hiredate, String department) {
	super(name, tel);
	this.hiredate = hiredate;
	this.department = department;
    } 
// sysout(s.infoString) = [�̸�] ȫ [��ȭ] 010 [�Ի���] 2019 03 16 [�μ�] ������.
    @Override
public String infoString() {
    return super.infoString()+" [�Ի���] : "+hiredate+" [�μ�] : "+department;
    }

}

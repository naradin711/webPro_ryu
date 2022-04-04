package com.lec.test02;

public class Staff extends Person {
    private String department; 
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	public void print () {
		System.out.println("(ID)"+getId()+"\t(이름)"+getName()+"\t(부서)"+department);
	}

}

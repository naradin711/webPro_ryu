package com.lec.test02;

public class Student extends Person {
    private String ban; 
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
	}
	public void print () {
		System.out.println("(ID)"+getId()+"\t(¿Ã∏ß)"+getName()+"\t(π›)"+ban);
	}

}

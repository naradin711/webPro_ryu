package com.lec.test02;

public class Gangsa extends Person {
    private String subject; 
	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
	}
	public void print () {
		System.out.println("(ID)"+getId()+"\t(이름)"+getName()+"\t(과목)"+subject);
	}

}

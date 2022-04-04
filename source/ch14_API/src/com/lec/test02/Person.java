package com.lec.test02;
// id name
public class Person {
	private String id;
	private String name;
	Person (String id, String name){
		this.id = id;
		this.name = name;
	}
	public void print () {
		System.out.println("(ID)"+id+"\t(¿Ã∏ß)"+name);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}

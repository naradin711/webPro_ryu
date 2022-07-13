package com.lec.ch03.ex01;

import lombok.Data;

@Data
public class Family {
	private String papaname;
	private String mamaname;
	private String broname;
	private String sisname;
	
	public Family(String papaname, String mamaname) { 
		this.papaname = papaname;
		this.mamaname = mamaname;
	}
	
	
}

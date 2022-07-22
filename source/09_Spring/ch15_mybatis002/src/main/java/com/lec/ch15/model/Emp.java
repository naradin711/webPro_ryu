package com.lec.ch15.model;

import java.sql.Date; 

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	private String loc;
	private int startRow; // 페이징 처리를 위한 추가변수
	private int endRow; // 페이징 처리를 위한 추가변수
}

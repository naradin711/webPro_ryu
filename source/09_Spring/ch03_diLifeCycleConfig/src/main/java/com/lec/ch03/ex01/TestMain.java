package com.lec.ch03.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		String resourcelocation1 = "classpath:/META-INF/ex01/applicationCTX1.xml";
		String resourcelocation2 = "classpath:/META-INF/ex01/applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourcelocation1, resourcelocation2);
		Student student = ctx.getBean("student", Student.class);
		System.out.println("student : " + student);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		System.out.println("studentInfo의 student : " + studentInfo.getStudent());
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family);
		ctx.close();

	}

}

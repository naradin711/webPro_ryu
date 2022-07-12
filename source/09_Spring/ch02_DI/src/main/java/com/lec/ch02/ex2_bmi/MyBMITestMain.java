package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyBMITestMain {
	public static void main(String[] args) {
		String resourcelocation = "classpath:applicationCTX002.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourcelocation);
		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
		myInfo.getInfo();
		ctx.close();
	}
}

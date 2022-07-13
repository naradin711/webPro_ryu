package com.lec.ch03.ex03;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex01.Family;

public class SingletonTestMain {

	public static void main(String[] args) {
		String location = "classpath:META-INF/ex03/applicationCTX4.xml";
		GenericApplicationContext ctx = new GenericXmlApplicationContext(location);
		Family family1 = ctx.getBean("family", Family.class);
		Family family2 = ctx.getBean("family", Family.class);
		family1.setPapaname("박아빠"); family1.setMamaname("박엄마");
		System.out.println("family1 : " + family1);
		System.out.println("family2 : " + family2);
		System.out.println("------------------------------------");
		Family family3 = ctx.getBean("familyPrototype", Family.class);
		Family family4 = ctx.getBean("familyPrototype", Family.class);
		family3.setBroname("집나간 아들"); family3.setSisname("결혼한딸");
		System.out.println("family3 : " + family3);
		System.out.println("family4 : " + family4);
		ctx.close();
	}

}

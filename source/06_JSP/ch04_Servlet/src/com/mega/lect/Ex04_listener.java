package com.mega.lect;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Ex04_listener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 구동되는 시점에 실행된다.
		System.out.println("★★★ ch04 context가 시작될때 (ch04 웹프로젝트가 메모리에 구동됨) ★★★");
		 
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 해제되는 시점에 실행된다.
		System.out.println("♠♠♠ ch04 context가 해제될때 (ch04 웹프로젝트가 메모리에 해제됨) ♠♠♠");
		 
	}
}

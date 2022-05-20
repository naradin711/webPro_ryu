package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
//@WebServlet(name = "HelloWorld", urlPatterns = { "/HW" })
public class Ex01_HW extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  					// 요청 처리 객체                                      // 응답처리객체
		System.out.println("2. doGet호출");
		  response.setContentType("text/html; charset=utf-8");
		  // response.setContentType("text/html; charset=utf-8"); 한글로 연결하는 문자열
		  PrintWriter out = response.getWriter(); // 스프링 객체 생성
		  out.print("<html>");
		  out.print("<head>");
		  out.print("<style>");
		  out.print("h1 {color : blue; font-size = 2.0em;}");
		  out.print("</style>");
		  out.print("</head>");
		  out.print("<body>");
		  out.print("<h1>안녕하세요. 첫 servlet 예제입니다. </h1>");
		  out.print("</body>");		  
		  out.print("</html>");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form method post onclick submit
		System.out.println("1. doPost호출");
		doGet(request, response);
	}

}





















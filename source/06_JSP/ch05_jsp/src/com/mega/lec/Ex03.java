package com.mega.lec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	 request.setCharacterEncoding("utf-8");
        	 response.setContentType("text/html; charset=utf-8");
        	 //어떤 요청이 들어왔는지?
        	 String conPath = request.getContextPath(); // conPath 프로젝트 이름 = /ch_05.jsp
        	 String URI = request.getRequestURI(); // uri= /ch_05.jsp/Ex03 url의 포트번호 이후부터 들어온다 
        	 String command = URI.substring(9);
        	 System.out.println("conPath = " + conPath);  	//conPath = /ch05_jsp
        	 System.out.println("URI = " + URI);  			//URI = /ch05_jsp/Ex03
        	 System.out.println("command = " + command); 	//command = /Ex03
        	
        			
        			 
         }
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	 request.setCharacterEncoding("utf-8");
        	 response.setContentType("text/html; charset=utf-8");
        	 doGet(request, response);
         }

}

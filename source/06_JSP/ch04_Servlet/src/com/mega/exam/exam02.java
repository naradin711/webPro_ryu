package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/exam02")
public class exam02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 String n1 = request.getParameter("name");
		 String a1 = request.getParameter("address");
		 response.setContentType("text/html; charset = utf-8");
		 PrintWriter out = response.getWriter();
		 out.println("반갑습니다! "+n1+"님.");
		 out.println("<br>");
		 out.println("입력받은 주소는 "+a1+"입니다.");
	}

}

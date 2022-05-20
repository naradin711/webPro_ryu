package com.lec.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Ex03")
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html; charset = utf-8");
		 PrintWriter out = response.getWriter();
		 int su = Integer.parseInt(request.getParameter("su"));
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<link href=\"/ch03_semiServlet/css/ex03.css\" rel=\"stylesheet\">");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h3>"+su+"단 구구단\n"+"</h3>");
		 for (int i =1; i<=9 ; i++) {		 
			 out.println("<p>"+su+"*"+i+"="+su*i+"</p>");
			 
		 }
		 out.println("</body>");
		 out.println("</html>");
		 out.close();
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

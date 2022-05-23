package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Exam03")
public class Exam03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // request 입력값의 한글처리
		String t1 = request.getParameter("title");
		String w1 = request.getParameter("writer");
		String word = request.getParameter("word");
		response.setContentType("text/html; charset = utf-8");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<table>");
		 out.println("<caption>반갑습니다 "+w1+"님</caption>");
		 out.println("<tr>");
		 out.println("<th>글제목</th>"); 
		 out.println("<td>"+t1+"</td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<th>글내용</th>"); 
		 out.println("<td>"+word+"</td>");
		 out.println("</tr>"); 
		 out.println("</table>");
		 out.println("</body>");
		 out.println("</html>");
		 
	}
	private void actionDo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	};

}

package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Exam01")
public class Exam01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		String[] su = request.getParameterValues("dansu");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
			if (su!=null) {
				
				out.println("<table>");
				
					for (String s : su) {
						int s1 = Integer.parseInt(s);
						out.println("<tr><th>");
						out.println(s1+"단 ");
						  for(int i=1; i<=9 ;i++) {
							  out.println("<tr><td>");
							  out.println(s1 +"*"+i+"="+s1*i);
							  out.println("</td></tr>");
						  }
						out.println("</th></tr>");
					}
				out.println("</table>");
			} else {
				out.println("<h2>반드시 단수를 선택하시기 바랍니다<h2>");
			}
		out.println("</body>");
		out.println("</html>");
	}

}

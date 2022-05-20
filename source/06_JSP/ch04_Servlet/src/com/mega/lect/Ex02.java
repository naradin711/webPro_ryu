package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //menu, rest : 파라미터가 안들어 올 수 있음. null 가능. => 배열로받음
		//  같은 이름의 파라미터가 여러개 들어올 수 있음
		 //nation 파라미터 : 반드시 하나는 선택함
		String[] mn1  = request.getParameterValues("menu");
		String[] rs1 = request.getParameterValues("rest");
		String nt1 = request.getParameter("nation");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(mn1!=null) {
			out.println("<h3>선택한 메뉴는" );
			for (String m : mn1) {
				out.println(m+". ");
			}
			out.println("</h3>" );
		} else {
			out.println("<h3>선택한 메뉴가 없습니다.</h3>");
			 
		}
		out.println("<br>");
		if(rs1!=null) {
			out.println("<h3>선택한 지역은" );
			for (String r : rs1) {
				out.print(r+". ");
			}
			out.println("</h3>" );
		} else {
			out.println("<h3>선택한 지역이 없습니다.</h3>");
			 
		}
		out.println("<br>");
		out.println("<h3>선택한 국적은 "+nt1+"입니다.</h3>");
		
		out.println("</body>");
		out.println("</html>");
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}

}

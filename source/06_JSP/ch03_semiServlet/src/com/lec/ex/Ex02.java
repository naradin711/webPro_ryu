package com.lec.ex;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( urlPatterns = { "/ex02sooOut" },  initParams = {  @WebInitParam(name = "Ex02", value = "") })
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String n1Str = request.getParameter("num");
		if (n1Str==null || n1Str.equals("")) {
			n1Str = "1";
		};
		int n1 = Integer.parseInt(n1Str); 
		
		int sum = 0;
		for (int i = 0; i <= n1; i++) {
			sum += i;
		}
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>1부터 "+ n1 +"까지 누적합은 "+sum+"입니다. </h1>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // num값이 들어오는 곳
		
		doGet(request, response);
	}

}


















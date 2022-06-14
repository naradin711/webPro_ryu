package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.wsdl.parser.InaccessibleWSDLException;

/**
 * Servlet implementation class Ex03
 */
@WebServlet(
		description = "Ex03", 
		urlPatterns = { "/Ex03" }, 
		initParams = { 
				@WebInitParam(name = "Ex03", value = "", description = "Ex03")
		})
public class Ex03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		// 넘어온 파라미터 id, pw를 이용하여 객체를 만든 후에 view 단으로 넘긴다.
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0 ;
		for (int i=1; i<=su ; i++){
			sum += i;
		}
		request.setAttribute("sum", sum);
		// view단으로 전송
		RequestDispatcher dispatcher = request.getRequestDispatcher("01_dispatcher/ex03_suView.jsp");
		dispatcher.forward(request, response);
		
	}
}





















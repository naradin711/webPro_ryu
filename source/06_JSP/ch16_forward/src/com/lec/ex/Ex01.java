package com.lec.ex;

import java.io.IOException;

import javax.print.attribute.standard.Severity;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/Ex01")
public class Ex01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		 
		actionDo(request, response);
	}	 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		// 넘어온 파라미터 id, pw를 이용하여 객체를 만든 후에 view 단으로 넘긴다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		Member member = new Member(id, pw);
		request.setAttribute("member", member);
		// view단으로 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("01_dispatcher/ex02_view.jsp");
		dispatcher.forward(request, response); // 여기서 request변수 값을 다음 페이지로 전송
		// response.sendRedirect("01_dispatcher/ex02_view.jsp"); 리퀘스트 리스폰스 싹다날라감
		
	}

}

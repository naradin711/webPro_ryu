package com.mall.Fcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mall.service.IdConfirmService;
import com.mall.service.Service;

@WebServlet("*.do")
public class FFController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			actionDo(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			actionDo(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length()); //들어온 요청 : ~do
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) {// 회원 가입 화면 출력
			viewPage = "main/main.jsp";
		} else if (command.equals("/joinView.do")) {
			viewPage = "customer/joinView.jsp";
		} else if (command.equals("/idConfirm.do")) {
			service = new IdConfirmService();//  
			service.execute(request, response);
			viewPage = "customer/idConfirm.jsp";
		};
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}






















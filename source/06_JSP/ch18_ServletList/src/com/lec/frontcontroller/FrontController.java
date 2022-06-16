package com.lec.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.DeleteService;
import com.lec.service.InsertService;
import com.lec.service.SelectService;
import com.lec.service.Service;
import com.lec.service.UpdateService;
 
@WebServlet("*.do") // *.do do 확장자를 지닌 모든 서블릿을 링크하는 확장자이다.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		actionDo(request, response);
	}
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI(); // /ch18_ServletList/insert.do
		String conPath = request.getContextPath(); // /ch18_ServletList
		String command = uri.substring(conPath.length());
		System.out.println("uri = " + uri);
		//uri = /ch18_ServletList/insert.do
		//uri = /ch18_ServletList/update.do
		//uri = /ch18_ServletList/delete.do
		//uri = /ch18_ServletList/select.do 
		System.out.println("conPath = " + conPath);
		System.out.println("들어온 요청 = " + command);
		String viewPage = null;
		Service service = null;
		if (command.equals("/insert.do")) {
			// insert 로직을 수행할 객체 생성
			service = new InsertService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			// request.setAttribute("result", "insert 결과");
			// viewPage = "ex02/select.jsp"; // list결과를 못 뿌림
			viewPage = "select.do";
			
		} else if (command.equals("/select.do")) {
			// select 로직을 수행할 객체 생성
			service = new SelectService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("list", "list 결과");
			viewPage = "ex02/select.jsp";
			
		} else if (command.equals("/delete.do")) {
			// delete 로직을 수행할 객체 생성
			service = new DeleteService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("result", "delete 결과");
			viewPage = "select.do";
			
		} else if (command.equals("/update.do")) {
			// update 로직을 수행할 객체 생성
			service = new UpdateService();
			// 객체이름.메소드(request, response)
			service.execute(request, response);
			//request.setAttribute("result", "update 결과");
			viewPage = "select.do";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}

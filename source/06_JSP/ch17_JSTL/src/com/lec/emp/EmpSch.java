package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/empSch")
public class EmpSch extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response); 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		EmpDao eDao = new EmpDao();
		String scname = request.getParameter("scname");
		String scjob = request.getParameter("scjob");
		ArrayList<EmpDto> emps = eDao.searchEmp(scname, scjob);
		request.setAttribute("emps", emps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("03_emp/empSch.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

}

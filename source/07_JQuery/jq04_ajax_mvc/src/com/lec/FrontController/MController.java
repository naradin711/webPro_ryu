package com.lec.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.IdConfirmService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.PwChkService;

@WebServlet("*.do")
public class MController extends HttpServlet {
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
		com.lec.service.Service service = null;
		if(command.equals("/joinView.do")) {// 회원 가입 화면 출력
			viewPage = "member/join.jsp";
		} else if(command.equals("/join.do")) {// 회원 가입 db 처리
			service = new MJoinService();// 아이디 중복체크 후 회원 가입
			service.excute(request, response);
			viewPage = "loginView.do";
		} else if(command.equals("/loginView.do")) {// 로그인 페이지 가기
			viewPage = "member/login.jsp";
		} else if(command.equals("/login.do")) {// 로그인 db 처리
			service = new MLoginService();//  
			service.excute(request, response);
			viewPage = "member/main.jsp";
		} else if(command.equals("/logout.do")) {// 로그아웃 db 처리
			service = new MLogoutService();//  
			service.excute(request, response);
			viewPage = "member/login.jsp";
		} else if(command.equals("/modifyView.do")) {// 회원정보 페이지 가기
			viewPage = "member/modify.jsp";
		} else if(command.equals("/modify.do")) {// 회원정보 db 처리
			service = new MModifyService();//  
			service.excute(request, response);
			viewPage = "member/main.jsp";
		} else if(command.equals("/allView.do")) {// 회원정보 페이지 가기
			service = new MAllViewService();//  
			service.excute(request, response);
			viewPage = "member/mAllView.jsp";
		} else if(command.equals("/main.do")) {// 회원정보 페이지 가기
			viewPage = "member/main.jsp";
		} else if(command.equals("/idConfirm.do")) { // ID 중복 체크하기
			service = new IdConfirmService();//  
			service.excute(request, response); // mid parameter로 idConfirm한 결과를 request로 객체 set
			viewPage = "member/idConfirm.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}






















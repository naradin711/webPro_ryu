package com.lec.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.AdminLoginService;
import com.lec.service.BoardListService;
import com.lec.service.DeleteMemberService;
import com.lec.service.EmailConfirmService;
import com.lec.service.FreeBoardContentService;
import com.lec.service.FreeBoardDeleteService;
import com.lec.service.FreeBoardModifyService;
import com.lec.service.FreeBoardReplyService;
import com.lec.service.FreeBoardReplyViewService;
import com.lec.service.FreeBoardWriteService;
import com.lec.service.IdConfirmService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;

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
			viewPage = "member/joinView.jsp";
		} else if(command.equals("/join.do")) {// 회원 가입 db 처리
			service = new MJoinService();// 아이디 중복체크 후 회원 가입
			service.execute(request, response);
			viewPage = "loginView.do";
		} else if(command.equals("/loginView.do")) {// 로그인 페이지 가기
			viewPage = "member/login.jsp";
		} else if(command.equals("/login.do")) {// 로그인 db 처리
			service = new MLoginService();//  
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/logout.do")) {// 로그아웃 db 처리
			service = new MLogoutService();//  
			service.execute(request, response);
			viewPage = "member/login.jsp";
		} else if(command.equals("/modifyView.do")) {// 회원정보 페이지 가기
			viewPage = "member/modify.jsp";
		} else if(command.equals("/modify.do")) {// 회원정보 db 처리
			service = new MModifyService();//  
			service.execute(request, response);
			viewPage = "main/main.jsp";
		} else if(command.equals("/allView.do")) {// 회원정보 페이지 가기
			service = new MAllViewService();//  
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		} else if(command.equals("/main.do")) {// 회원정보 페이지 가기
			viewPage = "main/main.jsp";
		} else if(command.equals("/idConfirm.do")) { // ID 중복 체크하기
			service = new IdConfirmService();//  
			service.execute(request, response); // mid parameter로 idConfirm한 결과를 request로 객체 set
			viewPage = "member/idConfirm.jsp";
		} else if(command.equals("/emailConfirm.do")) { // ID 중복 체크하기
			service = new EmailConfirmService();//  
			service.execute(request, response); // mid parameter로 idConfirm한 결과를 request로 객체 set
			viewPage = "member/emailConfirm.jsp";
		} else if (command.equals("/adminLoginView.do")) { // 관리자 로그인 화면
			viewPage = "admin/adminLoginView.jsp";
		} else if (command.equals("/adminLogin.do")) { // ID 중복 체크하기
			service = new AdminLoginService();//  
			service.execute(request, response); // aid parameter로 idConfirm한 결과를 request로 객체 set
			viewPage = "allView.do";
		} else if (command.equals("/deleteMember.do")) { // ID 중복 체크하기
			service = new DeleteMemberService();//  
			service.execute(request, response); // aid parameter로 idConfirm한 결과를 request로 객체 set
			viewPage = "main.do";
		} else if (command.equals("/boardList.do")) { // 글 목록 보기
			service = new BoardListService();//  
			service.execute(request, response); // aid parameter로 idConfirm한 결과를 request로 객체 set
			viewPage = "freeBoard/boardList.jsp";
		}  else if(command.equals("/content_view.do")) {// 상세보기 
			service = new FreeBoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/content_view.jsp";
		} else if(command.equals("/freeboard_modify_view.do")) {// 글 수정 페이지가기 
			service = new FreeBoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/freeboard_modify_view.jsp";
		} else if(command.equals("/freeboard_modify.do")) {// 글 수정하기
			service = new FreeBoardModifyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		} else if(command.equals("/freeboard_delete.do")) {// 삭제하기 
			service = new FreeBoardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		} else if(command.equals("/freeboard_reply_view.do")) {// 답글 페이지가기 
			service = new FreeBoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/freeboard_reply_view.jsp";
		} else if(command.equals("/freeboard_reply.do")) {// 답글 페이지가기 
			service = new FreeBoardReplyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		} else if(command.equals("/write_view.do")) {// 글쓰기
			viewPage = "freeBoard/write_view.jsp";
		} else if(command.equals("/write.do")) {// 답글 페이지가기 
			service = new FreeBoardWriteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}






















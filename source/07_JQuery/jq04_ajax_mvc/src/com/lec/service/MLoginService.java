package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.loginCheck(mid, mpw);
		if(result == MemberDao.LOGIN_SUCCESS) {
			MemberDto member = mDao.memberView(mid);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			request.setAttribute("LoginResult", result);
		} else {
			request.setAttribute("LoginError", "로그인에 실패하셨습니다.");
		}
		
	}

}

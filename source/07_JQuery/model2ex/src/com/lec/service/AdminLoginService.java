package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.AdminDao;
import com.lec.dto.AdminDto;

public class AdminLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao aDao = AdminDao.getInstance();
		int result = aDao.AdminloginCheck(aid, apw);
		if(result == AdminDao.LOGIN_SUCCESS) {
			AdminDto admin = aDao.AdminView(aid);
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			request.setAttribute("AdminLoginResult", "관리자 로그인에 성공하셨습니다.");
		} else {
			request.setAttribute("AdminLoginError", "관리자 로그인에 실패하셨습니다.");
		}

	}

}

package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mid = request.getParameter("mid");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmMid(mid);
		if (result==MemberDao.MEMBER_EXISTENT) {
			request.setAttribute("idConfirmResult", "중복된 아이디 입니다." );
		}else {
			request.setAttribute("idConfirmResult", "사용 가능한  ID입니다." );
		}
		

	}

}

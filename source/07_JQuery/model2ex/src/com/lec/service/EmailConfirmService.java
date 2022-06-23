package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class EmailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.confirmMemail(memail);
		if (result==MemberDao.MEMBER_EXISTENT) {
			request.setAttribute("emailConfirmResult", "중복된 Email 입니다." );
		}else {
			request.setAttribute("emailConfirmResult", "사용 가능한 Email입니다." );
		}
		

	}

}

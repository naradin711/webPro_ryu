package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lec.dao.MemberDao;

public class DeleteMemberService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mid = (String)request.getAttribute("mid") ;
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.deleteMember(mid);
		if (result == MemberDao.SUCCESS) { // 삭제 성공
			session.setAttribute("mid", mid);
			request.setAttribute("DeleteMemberResult", "회원 탈퇴 성공"); 
		} else {
			request.setAttribute("DeleteMemberError", "회원 탈퇴 실패");
		}

	}

}

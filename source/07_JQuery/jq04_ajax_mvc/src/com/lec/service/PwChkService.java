package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PwChkService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mpw= request.getParameter("mpw");
		String pwChk= request.getParameter("pwChk");
		if (pwChk.equals(mpw)) {
			request.setAttribute("pwChkResult", "비밀번호가 일치합니다.");
		}else {
			request.setAttribute("pwChkResult", "비밀번호가 일치하지 않습니다.");
		}
	}

}

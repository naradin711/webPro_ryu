package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//  insert 로직 (DAO 생성 - request.getParameter() - dao.insert)
		int result = 1;
		request.setAttribute("insertResult", result);

	}

}

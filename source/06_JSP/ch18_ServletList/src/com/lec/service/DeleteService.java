package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//  delete 로직 (DAO 생성 - request.getParameter() - dao.delete)
			int result = 1;
			request.setAttribute("deleteResult", result);

	}

}

package com.lec.service;
  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//  select 로직 (ArrayList 생성 - request.getParameter() - dao.list)
//			String[] Dto = {"홍", "백", "적"};
//			ArrayList<Dto> dtos = dao.list(startRow, endRow);
//			int PageCnt, startPage, endPage;
			String rs = "글목록";
			request.setAttribute("list", rs);

	}

}

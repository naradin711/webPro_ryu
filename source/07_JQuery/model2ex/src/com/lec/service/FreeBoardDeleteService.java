package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.FileBoardDao;

public class FreeBoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			int fid = Integer.parseInt(request.getParameter("fid"));
			FileBoardDao fDao = FileBoardDao.getInstance();
			request.setAttribute("FileBoardDeleteResult", fDao.deleteFileBoard(fid));

	}

}

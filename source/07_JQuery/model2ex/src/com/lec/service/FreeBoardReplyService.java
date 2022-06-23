package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.FileBoardDao;
import com.lec.dto.FileBoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FreeBoardReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getRealPath("freeBoardUp");
		int MaxSize = 1024*1024*50; //사진 업로드 제한
		String ffilename = ""; // 첨부된 파일이 저장되는 파일 이름
		MultipartRequest mRequest = null;
		try {
			// mRequest 객체 생성 후 mPhoto 파일이름 얻어옴
			
			mRequest = new MultipartRequest(request, path, MaxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				ffilename = mRequest.getFilesystemName(param);
			}
			System.out.println(ffilename+"들어옴");
			// mRequest 객체를 이용하여 파라미터 받아와서 DB 저장
			String mid = mRequest.getParameter("mid");
			String ftitle = mRequest.getParameter("ftitle");
			System.out.println(1);
			String fcontent = mRequest.getParameter("fcontent");
			System.out.println(2);
			System.out.println(3);
			HttpSession session = request.getSession();
			FileBoardDto ff =(FileBoardDto)session.getAttribute("fileboard");
			String sessionFile = null;
			if (ff!=null) {
				sessionFile = ff.getFfilename() ; // 세션의 pw를 sessionPw에 할당
			}
			ffilename = ffilename==null? sessionFile : ffilename;
			System.out.println(4);
			int fgroup =  Integer.parseInt(mRequest.getParameter("fgroup")) ;
			int fstep =  Integer.parseInt(mRequest.getParameter("fstep")) ;
			int findent =  Integer.parseInt(mRequest.getParameter("findent")) ;
			System.out.println(5);
			String fip = request.getRemoteAddr();
			System.out.println(6);
			FileBoardDao fDao = FileBoardDao.getInstance();
			FileBoardDto fileboard = new FileBoardDto(mid, ftitle, fcontent, ffilename, fgroup, fstep, findent, fip );
			int result = fDao.replyFileBoard(fileboard); 
			if (result == FileBoardDao.SUCCESS) { // 중복멤 없음 회원가입 가능
				System.out.println(7);
				session.setAttribute("fileboard", fileboard );
				request.setAttribute("replyResult", result); 
			} else {
				request.setAttribute("replyResult", result);
			} 
	
		} catch (Exception e) {
			System.out.println(e.getMessage() + " service");
		}
		
		// 파일 복사
		File serverFile = new File (path +"/"+ ffilename);
		if (serverFile.exists() && !ffilename.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro_ryu/source/06_JSP/ch19_mvcmember/WebContent/freeBoardUp/"+ffilename);
				byte[] bs = new byte[(int) serverFile.length()];
				while (true) {
					int readByCnt = is.read(bs);
					if(readByCnt==-1)break;
					os.write(bs, 0, readByCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} 
			}
		}
	}

}

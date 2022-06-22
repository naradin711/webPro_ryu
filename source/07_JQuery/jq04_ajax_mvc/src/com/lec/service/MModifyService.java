package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {
	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = request.getRealPath("memberPhotoUp");
		int MaxSize = 1024*1024*50; //사진 업로드 제한
		String mphoto = ""; // 첨부된 파일이 저장되는 파일 이름
		MultipartRequest mRequest = null;
		try {
			// mRequest 객체 생성 후 mPhoto 파일이름 얻어옴
			
			mRequest = new MultipartRequest(request, path, MaxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			while(params.hasMoreElements()) {
				String param = params.nextElement();
				mphoto = mRequest.getFilesystemName(param);
			}
			System.out.println(mphoto+"들어옴");
			// mRequest 객체를 이용하여 파라미터 받아와서 DB 저장
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			System.out.println(1);
			String mname = mRequest.getParameter("mname");
			System.out.println(2);
			String memail = mRequest.getParameter("memail");
			System.out.println(3);
			HttpSession session = request.getSession();
			MemberDto ms =(MemberDto)session.getAttribute("member");
			String sessionPhoto = null;
			if (ms!=null) {
				sessionPhoto = ms.getMphoto() ; // 세션의 pw를 sessionPw에 할당
			}
			mphoto = mphoto==null? sessionPhoto : mphoto;
			System.out.println(4);
			String mBirthStr = mRequest.getParameter("mbirth");
			System.out.println(5);
			Date mbirth = null;
			if(!mBirthStr.equals("")) {
				mbirth = Date.valueOf(mBirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			System.out.println(6);
			MemberDao mDao = MemberDao.getInstance();
			MemberDto member = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress);
			int result = mDao.modify(member); 
			if (result == MemberDao.SUCCESS) { // 중복멤 없음 회원가입 가능
				System.out.println(7);
				session.setAttribute("member", member);
				request.setAttribute("ModifyResult", result); 
			} else {
				request.setAttribute("ModifyErrorMsg", "회원 정보 수정 실패");
			} 
	
		} catch (Exception e) {
			System.out.println(e.getMessage() + " service");
		}
		
		// 파일 복사
		File serverFile = new File (path +"/"+ mphoto);
		if (serverFile.exists() && !mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro_ryu/source/06_JSP/ch19_mvcmember/WebContent/memberPhotoUp/"+mphoto);
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

<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	String path = request.getRealPath("fileboardUpload");
	int maxSize = 1024*1024*20; // 업로드 제한 용량
	String ffilename = null;// 첨부한 파일 이름
	MultipartRequest mRequest = null;
	try {
		mRequest = new MultipartRequest (request, path, maxSize, "utf-8",
										new DefaultFileRenamePolicy());
		Enumeration<String> params = mRequest.getFileNames();
		String param = params.nextElement(); //파라미터
		ffilename = mRequest.getFilesystemName(param);
	} catch (Exception e){
		System.out.println(e.getMessage());
	}
	if(ffilename!=null){
		InputStream is = null;
		OutputStream os = null;
		try {
			File serverfile = new File(path+"/"+ffilename);
			is = new FileInputStream(serverfile);
			os = new FileOutputStream("D:/webPro_ryu/source/06_JSP/model1ex/WebContent/fileboardUpload/"+ffilename);
			byte[] bs = new byte[(int)serverfile.length()];
			int readByCnt; 
			while((readByCnt = is.read(bs))!= -1) {
				os.write(bs, 0, readByCnt );
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e){
				System.out.println(e.getMessage());
			} 
		}//finally-
	}//if
	
	// 파라미터 정보 받아오기
	String pageNum 	= mRequest.getParameter("pageNum");
	int fnum 		= Integer.parseInt(mRequest.getParameter("fnum"));
	String cid 		= ((CustomerDto)session.getAttribute("customer")).getCid();
	String fsubject = mRequest.getParameter("fsubject");
	String fcontent = mRequest.getParameter("fcontent");
	String fpw 		= mRequest.getParameter("fpw");
	int fref 		= Integer.parseInt(mRequest.getParameter("fref")); // 원글은 0 답변글은 원글의 fref들어옴
	int frestep 	= Integer.parseInt(mRequest.getParameter("frestep")); // 원글은 0 답변글은 원글의 frestep들어옴
	int frelevel 	= Integer.parseInt(mRequest.getParameter("frelevel")); // 원글은 0 답변글은 원글의 frelevel들어옴
	String fip 		= request.getRemoteAddr();
	FileboardDto fbDto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 0, fref, frestep, frestep, fip, null);
	FileboardDao fbDao = FileboardDao.getInstance();
	int result;
	if(fnum == 0){
		result = fbDao.insertBoard(fbDto);
	} else {
		result = fbDao.reply(fbDto);
	}
	if(result== FileboardDao.SUCCESS){%>
		<script>
			alert('글 작성 완료');
			location.href= 'fboardList.jsp?pageNum=<%=pageNum %>';
		</script> 
  <%}else {%>
		<script>
			alert('글 작성 실패');
			history.back();
		</script>
  <%}%>	



</body>
</html>






































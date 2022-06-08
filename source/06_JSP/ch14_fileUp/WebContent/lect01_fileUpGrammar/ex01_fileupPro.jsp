<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
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
	String path = request.getRealPath("fileUpFolder");
	//out.println(path); // 하드디스크가 아닌 웹 톰캣의 웹 앱으로가서 해당 폴더에 저장
	int maxSize = 1024*1024*10; // 업로드 최대 용량을 10메가바이트
	String filename = ""; // 서버에 저장될 파일 이름 - 첨부파일 없으면 null처리
	String originalFilename = ""; //업로드한 오리지널 파 일이름
	
	try{
		MultipartRequest multipartrequest = new MultipartRequest(request, path, maxSize, "utf-8",
							new DefaultFileRenamePolicy()); 
		// new DefaultFileRenamePolicy() 같은 이름의 파일이 있을 경우 rename : 1.jpg -> 11.jpg	
		Enumeration<String> paramNames = multipartrequest.getFileNames(); // 파라미터 이름을 받아온다
		String param = paramNames.nextElement(); // 파라미터 이름 "file"
		filename = multipartrequest.getFilesystemName(param); //파라미터 이름으로 저장된 파일 이름
		originalFilename = multipartrequest.getOriginalFileName(param); //파라미터 이름으로 저장된 오리지널파일 이름
		// 파일 첨부를 하지 않을 경우 filename에 originalFilename에는 null이 들어간다.
		System.out.println("파라미터 이름 : "+ param + " / 서버에 저장된 파일이름 : "+ filename + 
							" / 사용자가 업로드한 오리지널 파일이름 : " + originalFilename );
	} catch (IOException e){
		out.println(e.getMessage());
	}
	// 서버 fileUpFolder에 업로드한 파일을 소스의 fileUpFolder로 file copy 
	InputStream is = null;
	OutputStream os = null;
	try {
		File serverfile = new File(path+"/"+filename);
		if(serverfile.exists()) { // 첨부한 파일이 있는지, 첨부하지 않았으면 파일 복사 안함
			is = new FileInputStream(serverfile); // 원본파일 - 서버에 있는 파일을 인풋!
			os = new FileOutputStream("D:/webPro_ryu/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/"+filename); //복사될 파일을 하드의 웹컨텐츠의 폴더에 복사로 아웃풋!
			byte[] bs = new byte[(int)serverfile.length()]; //서버파일의 길이 = 서버 파일의 크기!	
			while (true) {
				int nReadCnt = is.read(bs); //서버파일을 byte 숫자로 형변환해서 읽어들임
				if(nReadCnt == -1) break; // 파일을 다 읽었으면 break
				os.write(bs, 0, nReadCnt); // 0 = 시작하는 인덱스 nReadCnt = 끝나는 인덱스
			}//while
			System.out.println("서버 첨부 & 복사 완료");
		}//if
	} catch (Exception e) {
		System.out.println(e.getMessage());	
	} finally {
		if(os!=null) os.close();
		if(is!=null) is.close();
	}
	
	if (filename!=null) {
%>
	<h3>첨부한 오리지널 파일이름 = <%=originalFilename %></h3>
	<h3>서버에 저장된 파일 = <%=path %><%=filename %></h3>
	<img alt="설윤이미지" src="<%=conPath %>/fileUpFolder/<%=filename %>">
<%		
	} else {
		out.println("<h2> 첨부파일 존재하지 않음</h2>");
	}
%>
</body>
</html>




















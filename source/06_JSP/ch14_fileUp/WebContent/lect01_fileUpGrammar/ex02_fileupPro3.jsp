<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Arrays"%>
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
	<title>파일 첨부</title>
	<link href="<%=conPath %>/css/style.css " rel="stylesheet" type="text/css">
	
</head>
<body>
<%
	String path = request.getRealPath("fileUpFolder");
	//out.println(path); // 하드디스크가 아닌 웹 톰캣의 웹 앱으로가서 해당 폴더에 저장
	int maxSize = 1024*1024*100; // 업로드 최대 용량을 10메가바이트
	String[] filename = {"", "", ""}; // 서버에 저장될 파일 이름 - 첨부파일 없으면 null처리
	String[] originalFilename = {"", "", ""}; //업로드한 오리지널 파일이름
	try {
		MultipartRequest mRequest = new MultipartRequest (request, path, maxSize, "utf-8",
														   new DefaultFileRenamePolicy());
		Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 네임을 받아옵니다.
		int idx = 0;
		while (paramNames.hasMoreElements()) {
			String param = paramNames.nextElement(); // 파라미터 이름!
			filename[idx] = mRequest.getFilesystemName(param);
			originalFilename[idx] = mRequest.getOriginalFileName(param);
			System.out.println(idx+"번째 파라미터 : " +param+ ", 저장파일 : " +filename[idx] + ",원파일명 : " + originalFilename[idx]);
			
			idx++;
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}//try
	// 서버에 있는 저장 파일을 소스폴더로 복사
	for (String f : filename) {
		if(f!=null) {
			InputStream is = null;
			OutputStream os = null;
			try {
				File serverfile = new File(path+"/"+f);
				if(serverfile.exists()) { // 첨부한 파일이 있는지, 첨부하지 않았으면 파일 복사 안함
					is = new FileInputStream(serverfile); // 원본파일 - 서버에 있는 파일을 인풋!
					os = new FileOutputStream("D:/webPro_ryu/source/06_JSP/ch14_fileUp/WebContent/fileUpFolder/"+f); //복사될 파일을 하드의 웹컨텐츠의 폴더에 복사로 아웃풋!
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
		}	 
	}
%>

<%=Arrays.toString(filename) %>
<%=Arrays.toString(originalFilename) %>
	<h2>파일 1 첨부내용 </h2>
	<h4><%=path %>/<%=filename[2] %></h4>
	<img src="../fileUpFolder/<%=filename[2] %>"  alt="첫번째 첨부파일">
	<h2>파일 2 첨부내용 </h2>
	<h4><%=path %>/<%=filename[1] %></h4>
	<img src="../fileUpFolder/<%=filename[1] %>"  alt="두번째 첨부파일">
	<h2>파일 3 첨부내용 </h2>
	<h4><%=path %>/<%=filename[0] %></h4>
	<img src="../fileUpFolder/<%=filename[0] %>"  alt="세번째 첨부파일">
</body>
</html>
















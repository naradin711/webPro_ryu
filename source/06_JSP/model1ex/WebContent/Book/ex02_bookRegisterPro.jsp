<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
<%@page import="com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter"%>
<%@page import="java.awt.Image"%>
<%@page import="java.sql.Date"%>
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
<%  // 한글 인코딩 처리 - multipartRequest 객체 생성 - 첨부된 파일명 get - 그 외 파라미터에서 입력된 정보  get - insert
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("bookImg");
	int maxSize = 1024*1024*5; // 최대 업로드 용량 5mb
	String[] image = {"", ""};
	MultipartRequest mRequest = null;
	try{
		// mullpartRequest get
		mRequest = new MultipartRequest(request, path, maxSize, 
						"utf-8", new DefaultFileRenamePolicy());
		// 서버에 저장된 파일명 get 
		Enumeration<String> paramNames = mRequest.getFileNames();
		int idx = 0;
		while(paramNames.hasMoreElements()){
			String param = paramNames.nextElement(); //파라미터 이름
			image[idx] = mRequest.getFilesystemName(param); // 저장된 파일명
			idx++;
		}// while
	}catch (Exception e) {
		System.out.println(e.getMessage()+"xx");	
	}
	//서버(톰캣폴더)에 저장된 bookImg 폴더 파일을 소스(컴퓨터의 하드)폴더의 bookImg 폴더로 복사
	for (String img : image){
		if(img!=null) {
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path+"/"+img);
			try{
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:/webPro_ryu/source/06_JSP/ch14_fileUp/WebContent/bookImg/"+img);        
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readbyCnt = is.read(bs); //is에서 읽은 파일을 숫자화 
					if(readbyCnt == -1) break;
					os.write(bs, 0, readbyCnt);		
					 
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());	
			} finally{
				try{
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());	
				}	
			}//try-finally
		} // if
	}//for img : image
	
	// 파일 첨부와 파라미터에서 입력된 정보 get
	int bid = 0 ;      
	String btitle	= mRequest.getParameter("btitle");
	int bprice		= Integer.parseInt(mRequest.getParameter("bprice"));   
	String bimage1	= image[1]==null? "noImg.png":image[1];
	String bimage2	= image[0]==null? "NOTHING.JPG":image[0];     
    String bcontent	= mRequest.getParameter("bcontent");  
    int bdiscount  	= Integer.parseInt(mRequest.getParameter("bdiscount"));  
    Date brdate = null;	
	
	//DB에 insert!
	
	BookDao bDao = BookDao.getInstance();
	BookDto book = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);
	//bookDto book = new bookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount, brdate);			
	int result = bDao.insertBook(book);
	if (result == BookDao.SUCCESS){
		out.println("책 등록 성공");
	}else{
		out.println("책 등록 실패");
	}
	
	// 파일 첨부의 파라미터에서 입력된 정보 get
%>

<h3>책 이름 : <%=btitle %></h3>
<h3>책 대표 이미지 : <%=path %>/<%=bimage1 %></h3>
<img src="../bookImg/<%=bimage1 %>" alt="대표">
<h3>책 부가 이미지 : <%=path +"/"+ bimage2 %></h3>
<img src="../bookImg/<%=bimage2 %>" alt="부가">
<h3>책 설명</h3>
<pre><%=bcontent %></pre>
<h3>책 가격 : <del><%=bprice %></del> <%=bprice*(100-bdiscount)/100 %>원 </h3>
<h3>할인율 : <%=bdiscount %>%</h3>
<br>
<br>
<a href="ex03_list_board.jsp">책 전체 리스트 (게시판 스타일)</a>
<br>
<a href="ex03_list_boardp.jsp">책 전체 리스트 (페이징 스타일)</a>
<br>
<br>
<a href="ex03_list_product.jsp">책 찾기 리스트 (블록 스타일)</a>
<br>
<a href="ex03_list_productp.jsp">책 찾기 리스트 (블록 페이징 스타일)</a>
</body>
</html>

















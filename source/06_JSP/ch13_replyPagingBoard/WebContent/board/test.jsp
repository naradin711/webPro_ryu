<%@page import="com.lec.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lec.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>여기는 테스트 페이지 입니다.</title>
	<link href="<%=conPath %>/css/style1.css " rel="stylesheet" type="text/css">
	
</head>
<body>
	<a href="xx.jsp">xxxddd</a>
<%--
	BoardDao bDao = BoardDao.getInstance();	
	out.println("<h2>1. DB 글 갯수 : "+ bDao.getBoardTotalCnt() +"개 입니다.</h2>");
	out.println("<h2>2. DB 글 목록 </h2>");
	ArrayList<BoardDto> dtos = bDao.listBoard();
	for (BoardDto dto : dtos) {
		out.println(dto + "<br>");
	}
	out.println("<h2>3. 글쓰기(원본) </h2>");
	
	//BoardDto dto = new BoardDto(0, "신길동", "글제목 4", "본문\n입니다", "sin@sin.com", 0, "1", 0, 0, 0, "155.155.15.57", null);
	//int result = bDao.insertBoard(dto); // 인서트 함수
	 //out.println(result== BoardDao.SUCCESS ? "글쓰기 성공":"글쓰기 실패");
	BoardDto dto = new BoardDto();
	out.println("<h2>4 & 5. 글 번호로  상세보기 </h2>");
	bDao.readcountUp(1); // 클릭 했으니 조회수 카운트.
	dto = bDao.getBoardOneLine(1); // 카운트하고 글 상세 불러오기
	out.println("수정전의 1번글 : <br>" +dto);
	out.println("<h2>6. 글 수정하기 </h2>");
	dto.setSubject("바뀐 제목 111"); // dto로 제목 바꿔보기
	dto.setContent("바뀐 본문 111"); // dto로 본문 바꿔보기
	int result = bDao.updateBoard(dto); // 해당 바꾸기의 결과 값은 bDao의 업뎃보드 함수
	if (result == BoardDao.SUCCESS) { // 만약 결과값이 성공이라면 
		dto = bDao.getBoardOneLine(1); // 1번 글 다시 불러온다 (수정후)
		out.println("수정 후의 1번 글 : " + dto);	 // 수정후 1번글 출력하기
	} else {
		out.println("수정 실패"); // 수정실패
	}
	out.println("<h2>7. 글 삭제하기 </h2>");
	result = bDao.deleteBoard(7, "111");
	out.println(result == BoardDao.SUCCESS ? "7번글 삭제성공" : "7번글 삭제 실패");
	result = bDao.deleteBoard(5, "1");
	out.println("<br>");
	out.println(result == BoardDao.SUCCESS ? "5번글 삭제성공" : "5번글 삭제 실패");
--%>
</body>
</html>







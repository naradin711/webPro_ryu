<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:set var="conPath" value="${pageContext.request.contextPath }"  />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회 원 가 입</title>
<link href="${conPath }/css/style.css " rel="stylesheet" type="text/css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function () {
		$('#mid').keyup(function() {
			var mid = $('#mid').val();
			$.ajax({
				url : '${conPath}/idConfirm.do',
				data : 'mid='+mid,
				type : 'get',
				dataType : 'html',
				success : function(data) {
					$('#idConfirmResult').html(data);
				}//success
			});//ajax
		});//keyup
		$('#mpw, #pwChk').keyup(function() {
			var mpw 	= $('#mpw').val();
			var pwChk 	= $('#pwChk').val();
			if (mpw == pwChk){
				$('#pwChkResult').text('비밀번호 일치');
			} else {
				$('#pwChkResult').text('비밀번호 불일치');
			}
		});//keyup checkpw
		$('form').submit(function() {
			var idConfirmResult = $('#idConfirmResult').text().trim();
			var pwChkResult = $('#pwChkResult').text().trim();
			if(idConfirmResult!= '사용 가능한  ID입니다.' ){
				alert('사용가능한 ID를 입력하세요.');
				$('#idConfirmResult').focus();
				return false;
			} else if (pwChkResult!='비밀번호 일치')  {
				alert('올바른 비밀번호를 입력하세요.');
				$('#pwChkResult').focus();
				return false;
			}
		});
		$('#memail').keyup(function(){
			var patternMail = /^[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+){1,2}$/; // 메일 패턴
			var mEmail = $('#memail').val();
			if(patternMail.test(mEmail)){
				$.ajax({
					url : '${conPath}/emailConfirm.do',
					type : 'get',
					dataType : 'html',
					data : "mEmail="+mEmail,
					success : function(data){
						$('#emailConfirmResult').html(data);
					}
				});//ajax
			}else if(!mEmail){
				$('#emailConfirmResult').html(' &nbsp; ');
			}else{
				$('#emailConfirmResult').html('메일 형식을 지켜주세요');
			}//if
		});// mEmail keyup 이벤트
});//document.ready
</script>
</head>
<body>
<script>
  $( function() {
    $( "#datepicker" ).datepicker({
    	dateFormat : 'yy-mm-dd',
    	changeMonth : true, // 월을 바꿀 수 있는 셀렉트 박스 표시
    	monthNamesShort : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
    	showMonthAfterYear : true,
    	yearSuffix : '년', // "2020년 3월"
    	showOtherMonths : true,
    	dayNamesMin:['일','월','화','수','목','금','토'],
			changeYear : true, // 년을 바꿀 수 있는 셀렉트 박스 표시
			minDate : '-100y', // 현재 날짜로부터 100년 이전까지 표시
			yearRange : 'c-100:c+0', // 년도 선택 셀렉트 
    });
  } );
  </script>
  <jsp:include page="../main/header.jsp"/>
  <br>
	<form action="${conPath }/join.do" method="post" enctype="multipart/form-data" id="content_form">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="mid" id="mid" required="required">
					<div id="idConfirmResult"> &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="mpw" id="mpw" required="required">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="pwChk" id="pwChk" required="required">
					<div id="pwChkResult"> &nbsp; </div>		 
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
				 	<input type="text" name="mname" id="mname" required="required">
				</td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td>
					<input type="email" name="memail" id="memail" required="required">
					<div id="emailConfirmResult"> &nbsp; </div>
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="mphoto">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="text" name="mbirth" id="datepicker"><br>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="maddress" id="maddress">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" class="btn">
					<input type="button" value="로그인" class="btn" onclick="location='${conPath}/loginView.do'">
				</td>
			</tr>
		</table>
	</form>
  <br>
  <jsp:include page="../main/footer.jsp"/>
</body>
</html>
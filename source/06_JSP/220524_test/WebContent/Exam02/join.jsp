<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	<link href="../css/join.css" rel="stylesheet">
	<script type="text/javascript">
	 	function chkJoin() {
	 		// 두 비밀번호가 일치하고 메일 수신을 한개 이상 선택한 경우만 디폴트 이벤트 적용
	 		if(frmJoin.pw.value != frmJoin.pwChk.value){
	 			alert('비밀번호를 확인하세요');
	 			pw.value ='';
	 			pwChk.value ='';
	 			pw.focus;
	 			return false;
	 		}
	 		var hobby = document.querySelectorAll('input[name="hobby"]');
			var cnt = 0; //체크박수를 선택한 갯수 카운트
			for (var i=0; i<hobby.length ; i++){
				cnt= cnt + hobby[i].checked;
				//if(hobby[i].checked){//체크박스나 라디오버튼에 체크의 여부 확인하는 함수	
					//cnt++; //카운트 해놓기
				//}
			}//for
			if(!cnt){
				alert("취미를 1개 이상 선택하셔야 합니다.");
				return false;
			}
			var male = document.querySelector('input[id="m"]');
			var female = document.querySelector('input[id="f"]');
			if (!male.checked && !female.checked) {
				alert("성별을 선택하십시오.");
				return false;
			};
	 	};// function
	</script>
</head>
<body>
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post" name="frmJoin" class="frmJoin" onsubmit="return chkJoin()">
			<div id="join_title">회원가입
			<input type="hidden" name="hiddenParam" value="보이지는 않으나 전달되는 값">
			</div>
			<table>
				<tr>
				   <th>
				   <label for="name">이름</label>
				   </th>
				   <td>
				   	<input type="text" name="name" id="name" class="name" required="required" autofocus="autofocus"/>
				   </td> 
				</tr>
				<tr>
				   <th>
				   <label for="id">아이디</label>
				   </th>
				   <td>
				   	<input type="text" name="id" id="id" class="id" required="required"/>
				   </td> 
				</tr>
				<tr>
				   <th>
				   <label for="pw">비밀번호</label>
				   </th>
				   <td>
				   	<input type="password" name="pw" id="pw" class="pw" required="required"/>
				   </td> 
				</tr>
				<tr>
				   <th>
				   <label for="pwChk">비밀번호확인</label>
				   </th>
				   <td>
				   	<input type="password" name="pwChk" id="pwChk" class="pwChk"/>
				   </td> 
				</tr>
				  <tr>
				   <th>
				   <label for="birth">생일</label>
				   </th>
				   <td>
				   	<input type="date" name="birth" id="birth" class="birth" required="required"/>
				   </td> 
				</tr>
				<tr>
				   <th>
				   <label >취미</label>
				   </th>
				   <td>
				   	<input type="checkbox" name="hobby" id="reading" class="hobby" value="독서"/>
				   	<label for="reading" >독서</label>
				   	<input type="checkbox" name="hobby" id="cooking" class="hobby" value="요리"/>
				   	<label for="cooking" >요리</label>
				   	<input type="checkbox" name="hobby" id="exercising" class="hobby" value="운동"/>
				   	<label for="exercising" >운동</label>
				   	<input type="checkbox" name="hobby" id="sleeping" class="hobby" value="취침"/>
				   	<label for="sleeping" >취침</label>
				   </td> 
				</tr>
				<tr>
				   <th>
				   <label>성 별</label>
				   </th>
				   <td>
				   	<input type="radio" name="gender" id="m" value="m"/>
				   	<label for="m">남자</label>
				   	<input type="radio" name="gender" id="f" value="f"/>
				   	<label for="f">여자</label>
				   </td> 
				</tr>
				<tr>
				   <th>
				   <label for="email">메일</label>
				   </th>
				   <td>
				   	<input type="email" name="email" id="email" class="email" required="required"/>
				   </td> 
				</tr>
				<tr>
					<th>
					메일 수신
					</th>
					<td>
					<select name="mailSend" multiple="multiple" class="mailSend">
						<option>모두 수신 거부</option>
						<option>광고</option>
						<option>배송</option>
						<option>공지</option>
						<option>뉴스</option>
						
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="가입하기" class = "joinBtn_style">
						<input type="reset" value="다시하기" class = "joinBtn_style">
						<input type="button" value="뒤로가기" class = "joinBtn_style" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>		
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>
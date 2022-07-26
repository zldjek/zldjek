<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypageInfo.jsp</title>
</head>
<body>
	<div><%=id %>님 환영합니다</div>
	
	<section >
<h2>가입 상세정보</h2>

	<section>
		<section>
			<img>
		</section>
		<section>
			<b>이름 : </b> <br>
			<b>주소 : </b> <br>
			<b>전화번호 : </b> <br>
			<b>이메일 : </b> <br>
		</section>
		<div></div>
		<nav>
			<a href="#">쇼핑계속하기</a>
			
		</nav>
	</section>
</section>
	<!-- 일단 a테그로 이동 시켜봅니다.-->
	<!-- <input type="button" value="" onclick="location.href=''"> -->
	<a href="myInfoUpdate.jsp">회원정보 수정</a>
	
	
	
	<br><br><br><br><br><br>
	<!-- 회원탈퇴는 맨 밑쪽에 있었으면 합니다! -->
	
	
	<div>
		<input type="button" value="회원탈퇴" onclick="location.href='myInfoDelete.jsp'">
	</div>
</body>
</html>
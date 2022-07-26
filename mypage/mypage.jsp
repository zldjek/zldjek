<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage.jsp</title>
</head>
<body>
	<h1>마이페이지</h1>
	<p>로그인시 사용가능 합니다</p>
	<%
	String id = (String)session.getAttribute("id");
	
	if (id == null) {
	%>
	<a href="#">로그인</a>
	<%} else { %>
	<a href="mypageInfo.jsp"></a>	
	<%} %>
	
	<p>사용가능한 아이디가 없을시 회원가입 후 서비스가 가능합니다</p>
	<a href="#">회원가입</a><br>
	
	<a href="mypageInfo.jsp">회원정보 확인</a><br>
	<a></a>
	<a href="orderInfo.jsp">주문내역 확인</a><br>
</body>
</html>
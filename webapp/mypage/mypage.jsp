<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>mypage.jsp</title>
<script>
	function changeView(value) {
		if(value == "0") {
			location.href="#"; // Home 버튼 클릭시 main 화면으로 이동 
		} else if(value == "1") { // 로그인 버튼 클릭시 로그인 화면으로 이동
			location.href="#";
		} else if(value == "2") { // 회원가입 버튼 클릭시 회원가입 화면으로 이동
			location.href="#";
		} else if(value == "3") { // 내정보 버튼 클릭시 회원정보 보여주는 화면으로 이동
			location.href="myInfo.bo";
		} else if(value == "4") { // 주문내역 버튼 클릭시 주문 주문정보 보여주는 화면으로 이동
			location.href="orderInfo.bo" 
		}
	}
</script>
</head>
<body>

	<div>
		<!--헤더<jsp:include page="#"/>-->
	</div>
	
	<h1>마이페이지</h1>
	<p>로그인시 사용가능 합니다</p>
	<p>사용가능한 아이디가 없을시 회원가입 후 서비스가 가능합니다</p>
	<!-- Home 화면이동 버튼 -->
	<input type="button" name="main" value="Home" onclick="changeView(0)">
	<!-- 로그인 안되었을 경우 -->
	<c:if test="${sessionScope.sessionId == null }">
		
		<input type="button" name="" value="로그인" onclick="changeView(1)">
		<input type="button" name="" value="회원가입" onclick="changeView(2)">
		
	</c:if>
	<!-- 로그인이 되었을 경우 - 내정보,주문내역 이동-->
	<c:if test="${sessionScope.sessionId != null }">
		<br>
		<span>${sessionScope.sessionId } 님 환영합니다.</span>
		<input type="button" name="myInfo" value="내정보" onclick="changeView(3)">
		<input type="button" name="orderInfo" value="주문내역" onclick="changeView(4)">
	</c:if>
	
	
	<div>
		<!--풋터<jsp:include page="#"/>-->
	</div>	
</body>
</html>
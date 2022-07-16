<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY);
int minute = c.get(Calendar.MINUTE);
int second = c.get(Calendar.SECOND);
%>
<meta charset="UTF-8">
<title>TimeNow</title>
</head>
<body>
	<h1><span style="color: highlight;"> TimeNow is <%=hour %>Hour <%=minute %>Minute <%=second %>Second</span></h1>
</body>
</html>

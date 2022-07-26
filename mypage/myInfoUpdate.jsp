<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myInfoUpdate.jsp</title>
</head>
<body>
	<h2>내정보 수정</h2>
	<form action="myInfoUpdate" method="post">
 		<table>
   		<tr>
     		<td><p>아이디</td>
     		<td><input type="text" name="id" value="" disabled="disabled" ></td>
     
   		</tr>
 		
 		<tr>
     		<td><p>비밀번호</td>
     		<td><input type="password" name="passwd" value="" >
     	</td>
   		</tr>
   		
   		<tr>
     		<td><p>이름</td>
     		<td><input type="text" name="name" value="" disabled="disabled"></td>
   		</tr>
   		
   		<tr>
     		<td><p>이메일</td>
     		<td><input type="text" name="email"  value="" ></td>
   		</tr>
   		
   		<tr>
     		<td><p>전화번호</td>
     		<td><input type="text"  name="phone" value=""></td>
   		</tr>
   
   		<tr>
    		<td><input type="submit" value="수정하기" >
      		 <input type="reset" value="다시입력" ></td>
   		</tr>
 	</table>
	</form>
</body>
</html>
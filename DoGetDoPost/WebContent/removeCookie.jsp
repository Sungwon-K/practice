<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie=new Cookie("id","");//id쿠키값 지움
		cookie.setMaxAge(0);//유효기간 종료
		response.addCookie(cookie);//덮어씀
		
	%>
	<h3>쿠키가 삭제됨</h3>
	<a href="getCookies.jps">쿠키삭제확인</a>
</body>
</html>
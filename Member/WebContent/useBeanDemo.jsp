<%@ page import = "com.saeyan.javabeans.MemberBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	MemberBean member=new MemberBean();
member.setName("홍길동");
member.setUserid("hkd");

out.println(member.getName()+"<br>");
out.println(member.getUserid()+"<br>");
%> --%>
<jsp:useBean id="member2" class="com.saeyan.javabeans.MemberBean"/>
<jsp:setProperty property="name" name="member2" value="이순신"/>
<jsp:setProperty property="userid" name="member2" value="LSS"/>

<jsp:getProperty property="name" name="member2"/>
<jsp:getProperty property="userid" name="member2"/>
</body>
</html>
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
   /* RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
   request.setAttribute("name","홍길동"); 
   dispatcher.forward(request, response); */
%>
   <jsp:forward page="main.jsp">
   		<jsp:param value="홍길동" name="name"/>
   </jsp:forward>

</body>
</html>
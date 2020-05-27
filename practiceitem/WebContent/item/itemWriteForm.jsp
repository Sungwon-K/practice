<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/item.js"></script>
</head>
<body>
<h1>정보 입력 폼</h1>
<form method="post" name="frm">
	<table>
		<tr>
			<th>상 품 명</th>
			<td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<th> 가 격 </th>
			<td><input type="text" name="price"></td>
		</tr>
		<tr>
			<th> 설 명 </th>
			<td><textarea cols="80" rows="10" name="description"></textarea></td>
		</tr>	
	</table>
	<br>
	<div align="center">
		<input type="submit" value="등록" onclick="return itemCheck();">
		<input type="reset" value="취소">
	</div>
</form>
</body>
</html>
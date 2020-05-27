<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정보 입력 폼</h1>
<form method="post" name="frm" action="">
	<table>
		<tr>
			<th>상 품 명</th>
			<td><input type="text" name="name" size="80"></td>
		</tr>
		<tr>
			<th> 가 격 </th>
			<td><input type="text" name="price"> 원 </td>
		</tr>
		<tr>
			<th> 설 명 </th>
			<td><textarea cols="80" rows="10" name="description"></textarea></td>
		</tr>	
	</table>
	<br>
	<input type="submit" value="등록" onclick="">
	<input type="reset" value="취소">
</form>
</body>
</html>
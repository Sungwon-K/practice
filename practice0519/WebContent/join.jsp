<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form name="form1" action="JoinServlet" method="post"
		onsubmit="return check();">
		id <input type="text" name="id"><br> 
		name <input	type="text" name="name"><br> 
		pw <input type="password" name="pw"><br>
		email<input type="text" name="email"><br>
		
		email수신<input type="radio" value="예" name="emailYN">예 
		<input type="radio" value="아니오" name="emailYN">아니오<br>
		 
		 취미
		  <input type="checkbox" value="운동" name="hobby"> 운동 
		  <input type="checkbox" value="독서" name="hobby"> 독서 
		  <input type="checkbox" value="등산" name="hobby"> 등산 
		  <input type="checkbox" value="낚시" name="hobby"> 낚시 <br>
		   
		  직업<select	name="job">
			<option value="학생">학생</option>
			<option value="직장인">직장인</option>
			<option value="군인">군인</option>
			<option value="기타">기타</option>
		</select>
		
		<br> 자기소개<br>
		<textarea name="introduce" cols="50" rows="10"></textarea>
		<br> 사진 <input type="file" name="picture"><br> 
		<input type="submit" value="등록">
	</form>
</body>
</html>
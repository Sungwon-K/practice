<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "get" action = "ParamServlet">
		id <input type="text" name="id"><br>
		age <input type="text" name="age"><br>
		favorites
			<input type="checkbox" name="item" value ="신발"> 신발
			<input type="checkbox" name="item" value ="가방"> 가방
			<input type="checkbox" name="item" value ="모자"> 모자<br>
		
		interest
		<select
		id="interest" name="interest" size='5' multiple="multiple">
			<option value="에스프레소">에스프레소</option>
			<option value="로스팅">로스팅</option>
			<option value="생두">생두</option>
			<option value="원두">원두</option>
			<option value="핸드드립">핸드드립</option>
		</select>
		<input type="submit" value="전송"><br>
	</form>
</body>
</html>
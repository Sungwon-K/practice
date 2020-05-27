<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css" type = "text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
<script src="script.js" type="text/javascript"></script>
<title>Coupang Demo</title>
</head>
<body>	
	<form name="form" action="Coupang.do" style="max-width:450px;margin:auto">
	<a href="https://www.coupang.com/">
		<img src="image\coupang.jpg"   class="title"   alt="쿠팡이미지">
	</a>
  
  <div class="input-container">
  	<i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text" placeholder="아이디(이메일)" name="id" id="id" onfocusout="idck()">
  </div>
  <div class="warn" id="warnid">이메일을 입력하세요.</div>
  
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="비밀번호(영문 숫자 특수문자 2가지 이상 6~15자 이내)" name="pass" id="pass" onfocusout="pwck();"><br/>
  </div>
  <div class="warn" id="warnpw">비밀번호는 6~15자 이내로 입력하셔야 합니다.</div>
  
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="비밀번호 확인" name="passck" id="passck" onfocusout="pwckck();"><br/>
  </div>
  <div class="warn" id="warnpwck" >비밀번호가 일치하지 않습니다.</div>
  <div class="warn" id="wrongpw" >비밀번호가 잘못되었습니다.</div>
  
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="이름" name="name" id="name" onfocusout="nameck();"><br/>
  </div>
  <div class="warn" id="warnname" >이름을 정확히 입력하세요.</div>
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="휴대폰 번호" name="phonenum" id="phonenum" onfocusout="pnck();"><br/>
  </div>
  <div class="warn" id="warnpn" >휴대폰 번호를 정확하게 입력하세요.</div>  
  <div class="warn" id="wrongpn" >잘못된 번호 입니다.</div>

  <input type="button" value="동의하고 가입하기" class="btn" id="btn" onclick="check();">
  <jsp:include page="footer.jsp"/>
</form>	
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<button type="button" onclick="self.location = '/authAdd' " class="btn btn-danger btn-xs pull-right">강사 등록</button>
<button type="button" onclick="self.location = '/studyManager/classList' " class="btn btn-danger btn-xs pull-right">강사 관리 페이지</button>
</body>
</html>

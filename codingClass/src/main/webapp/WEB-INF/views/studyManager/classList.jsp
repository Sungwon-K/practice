<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 관리 페이지</title>
</head>
<%@ include file="../includes/sideMenu.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		
		$(".classTitle").on("click", function(){
			self.location = "/studyManager/classManage";
		});
		
	})
</script>
<body>
	
	<div id="page-wrapper">
    	<div class="row">
        	<div class="col-lg-12">
            	<h1 class="page-header">클래스 리스트</h1>
            </div>
                <!-- /.col-lg-12 -->
        </div>
            <!-- /.row -->
        <div class="row">
        	<div class="col-lg-12">
				<a href="/studyManager/classManage">클래스 관리</a>
				<a href="/studyManager/studentShow">클래스 조회</a>
			</div>
		
		</div>
		<form>
		<c:forEach items="${list }" var="classes">
			<tr>
				<td><c:out value="${classes.classNo}"/></td>
				<td><span style="cursor:pointer;" class="classTitle"><c:out value="${classes.classTitle}"/></span></td>
				<td><c:out value="${classes.userNo}"/></td>
				<td><c:out value="${classes.classInfo}"/></td>
				<td><c:out value="${classes.classCurriculum}"/></td>
				<td><c:out value="${classes.classLevel}"/></td>
				<td><c:out value="${classes.classThumnail}"/></td>
				<td><c:out value="${classes.classFlag}"/></td>
				<td><c:out value="${classes.classDetail}"/></td>
				<td><c:out value="${classes.classDate}"/></td>
				<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${classes.classDate }"/></td>
			</tr>
		</c:forEach>
		</form>
	</div>
</body>
</html>
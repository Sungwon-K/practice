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

<script src="http://code:jquery.com/jquery-3.2.1.min.js"></script>

<script>
	$(".move").on("click", function(e){
		console.log("move");
		console.log($(this).attr("href"));
		e.preventDefault();
		//actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");		
		//actionForm.attr("action","/studyManager/studyManage");
		//actionForm.submit();
	});
</script>
<style>
table{
	border:1px solid;
}
th, td{
	border:1px solid;
}
</style>
<body>
	
	<div id="page-wrapper">    	
        
        <!-- 페이지 대분류 -->
        <div class="col-lg-12">
           	<h1 class="page-header">클래스 리스트</h1>
        </div>
        <!-- 페이지 대분류 ----------------------------------------->               
        
        <!-- 페이지 소분류 -->
            <div class="col-lg-12">
				<a href="/studyManager/classManage">클래스 관리</a>
				<a href="/studyManager/studentShow">클래스 조회</a>
				<button type="button" onclick="self.location='/studyManager/classRegister'">클래스 생성</button>
			</div>		
		<!-- 페이지 소분류 ----------------------------------------->
		
		<!-- class 리스트 -->
		<table>
			<thead>
				<tr>
					<th>#번호</th>
					<th>클래스 명</th>
					<th>수강생 수</th>
					<th>구분</th>
					<th>클래스 개설일</th>
					<th>최근 수정일</th>					
				</tr>
			</thead>
			<c:forEach items="${list }" var="classes">
				<tr>
					<td><c:out value="${classes.classNo}"/></td>
					<td>						
<!-- 						<a class="move" href="<c:out value='${classes.classNo}'/>"> -->
						<a class="move" href="#">
    	                	<c:out value="${classes.classTitle }"/>                               					
	                    </a>	                
                	</td>
					<td><c:out value="${classes.userNo}"/></td>					
					<td><c:out value="${classes.classFlag}"/></td>				
					<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${classes.classDate }"/></td>
					<td><fmt:formatDate pattern = "yyyy-MM-dd" value="${classes.classDate }"/></td>
				</tr>
			</c:forEach>
		</table>
		<!-- classes 리스트 ------------------------------------->
		
		<!-- form -->
		<%-- <form id='actionForm' action="/studyManager/classList" method='get'>
			<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'/>
			<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
			<input type='hidden' name='type' value="<c:out value='${pageMaker.cri.type }'/>">
			<input type='hidden' name='keyword' value="<c:out value='${pageMaker.cri.keyword }'/>">															
		</form> --%>
		<!-- form --------------------------------------------->
		
		
		<%@ include file="../includes/footer.jsp" %>		
	</div>
</body>
</html>
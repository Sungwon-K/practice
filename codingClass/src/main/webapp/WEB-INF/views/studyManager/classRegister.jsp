<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강사 관리 페이지</title>
</head>

	<!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<!-- Bootstrap js -->
	<script src="/resources/vendor/bootstrap/js/bootstrap.js"></script>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    
    

<%@ include file="../includes/sideMenu.jsp" %>

<script>
$(document).ready(function() {
	
	
	//모달창에 사용하는 변수
	var modal = $("#modal");
	var modalInputUrl = modal.find("input[name='studyUrl']");	
	
	//세션 수정 버튼을 눌렀을 경우 모달창 상태
	//.show .hide .modal은 부트스트랩 함수
	$("button[data-oper='session']").on("click",function(e) {
		e.preventDefault();
		console.log("세션 수정 버튼 클릭");
		
		modal.find("input").val("");//input태그 값 삭제		
		modalInputUrl.closest("div").hide();//url항목 숨김
		
		$("#sessionRegisterBtn").show();//세션 저장 버튼 노출
		$("#studyRegisterBtn").hide();//강의 저장 버튼 숨김
		
		
		$("#modalTitle").text("세션 수정");//모달 제목 '세션수정'		
		$(".no").text("세션 번호")	;//넘버 '세션번호'
		$(".title").text("세션 제목");//제목 '세션제목'
		
		$("#modal").modal("show");
	});
	
	//강의 수정 버튼을 눌렀을 경우 모달창 상태
	//.show .hide .modal은 부트스트랩 함수
	$("button[data-oper='studyVideo']").on("click",function(e) {
		e.preventDefault();
		console.log("강의 수정 버튼 클릭");
		
		modal.find("input").val("");//input태그 값 삭제		
		modalInputUrl.closest("div").show();//url항목 보이게	
		
		$("#sessionRegisterBtn").hide();//세션 저장 버튼 숨김
		$("#studyRegisterBtn").show();//강의 저장 버튼 노출
		
		$("#modalTitle").text("강의 수정")//모달 제목 '강의수정'
		$(".no").text("강의 번호")	;//넘버 '강의번호'
		$(".title").text("강의 제목");//제목 '강의제목'
		
		$("#modal").modal("show");			
	});
 
	
	//클래스 등록 버튼
	//클릭시 classform submit
	$(".registerBtn").on("click",function(e){
		e.preventDefault();
		console.log("클래스 저장버튼 클릭")
		
		//classNo 빈칸 체크
		if($("#classNo").val() == ""){
			alert("클래스 번호를 입력하세요");
			return;
		}
		
		//userNo 빈칸 체크
		if($("#userNo").val() == ""){
			alert("유저 번호를 입력하세요");
			return;
		}
		
	//세션폼 강의폼 넘버 넘겨받음
	//나중에 반드시 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	$("#sessionClassNo").val($("#classNo").val());	
	$("#studyVideoSessionNo").val($("#sessionNo").val());	
		
	console.log($("#classForm"));
	console.log($("#sessionForm"));
	console.log($("#studyVideoForm"));
	//$("#classForm").submit();	
	});
	
	
	//세션 수정 모달창의 세션 등록 버튼 처리
	$("#sessionRegisterBtn").on("click",function(e){
		
		console.log("세션 수정 모달창의 세션 등록버튼 클릭");
		
		//세션번호 빈칸 체크
		if($("#no").val() == ""){
			alert("세션 번호를 입력하세요");
			return;
		}
		
		//세션제목 빈칸 체크
		if($("#title").val() == ""){
			alert("세션 제목을 입력하세요");
			return;
		}
		
		//세션번호 input 태그의 값을 모달창에서 입력받은 값으로 변경
		//나중에 반드시 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		$("#sessionNo").val($("#no").val());
		
		//세션제목 input 태그의 값을 모달창에서 입력받은 값으로 변경
		$("#sessionTitle").val($("#title").val());
		$("#modal").modal("hide");
	});
	
	
	//강의 수정 모달창의 강의 등록 버튼 처리
	$("#studyRegisterBtn").on("click",function(e){
		
		console.log("강의 수정 모달창의 강의 등록버튼 클릭");
		
		//세션번호 빈칸 체크
		if($("#no").val() == ""){
			alert("강의 번호를 입력하세요");
			return;
		}
		
		//세션제목 빈칸 체크
		if($("#title").val() == ""){
			alert("강의 제목을 입력하세요");
			return;
		}
		
		//강의번호 input 태그의 값을 모달창에서 입력받은 값으로 변경
		//나중에 반드시 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		$("#studyVideoNo").val($("#no").val());
		
		//강의번호 input 태그의 값을 모달창에서 입력받은 값으로 변경
		//나중에 반드시 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		$("#studyUrl").val($("#url").val());
		
		
		//세션제목 input 태그의 값을 모달창에서 입력받은 값으로 변경
		$("#studyVideoTitle").val($("#title").val());
		$("#modal").modal("hide");
	});
});
</script>
<body>
	<div id="page-wrapper">
    	
    	<!-- 페이지 대분류 -->
        <div class="col-lg-12">
           	<h1 class="page-header">클래스 리스트</h1>
        </div>
        <!-- 페이지 대분류 ----------------------------------------->               
        
        <!-- 페이지 소분류 -->       
        <div class="col-lg-12">
			<span style="color:skyblue;">클래스 리스트</span> /
			<a href="/studyManager/studentShow">클래스 조회</a>
		</div>				
		<!-- 페이지 소분류 ----------------------------------------->
		
		<!-- 클래스 폼 -->
        <form id="classForm" action="/studyManager/classRegister" method="post">      
			
	    	<div class="form-group">
	    		<label>클래스 번호</label>
	    		<input id="classNo" class="form-control" name="classNo">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>클래스 제목</label>
	    		<input class="form-control" name="classTitle">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>유저 번호</label>
	    		<input id="userNo" class="form-control" name="userNo">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>클래스 소제목</label>
	    		<textarea class="form-control" rows="2" name="classInfo"></textarea>
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>클래스 커리큘럼</label>
	    		<textarea class="form-control" rows="3" name="classCurriculum"></textarea>
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>클래스 레벨</label>
	    		<input class="form-control" name="classLevel">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>클래스 썸네일</label>
	    		<input class="form-control" name="classThumnail">
	    	</div>
	    	
	    	<div class="form-group">
	    		<label>강의 디테일 소개</label>
	    		<textarea class="form-control" rows="3" name="classDetail"></textarea>
	    	</div>
	    </form>
    	<!-- 클래스 폼 ------------------------------------------>
	    
	    <!-- 세션 폼 -->
	    <form id="sessionForm" action="/studyManager/classRegister" method="post">
		    <input id="sessionNo" type="hidden" value="" name="ssessionNo">
			
			<input class="fotm-control" id="sessionTitle" name="sessionTitle" value="세션 이름">
			<button data-oper="session" class="sessionBtn">세션 수정</button>
			
			<input id="sessionClassNo" type="hidden" value="" name="classNo">			
		</form>
		<!-- 세션 폼 ------------------------------------------>
		
		<!-- 강의 폼 -->
		<form id="studyVideoForm" action="/studyManager/classRegister" method="post"> 
			<input id="studyVideoNo" type="hidden" value="" name="studyVideoNo">
			
			<input class="fotm-control"  id="studyVideoTitle" name="studyVideoTitle" value="강의 이름">
			<button data-oper="studyVideo" class="studyVideoBtn">강의 수정</button>
			
			<input id="studyUrl" type="hidden" value="" name="studyUrl">
			<input id="studyVideoSessionNo" type="hidden" value="" name="sessionNo">		
		</form>
		<!-- 강의 폼 ------------------------------------------>
				
		<button type="button" class="registerBtn">클래스 저장</button>     		
	    	
    	
    	
    	<!-- 모달 -->
		<div id="modal" class="modal fade"  role="dialog">
			<div class="modal-dialog">
							
				<!-- 모달 내용-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 id="modalTitle" class="modal-title"></h4>						
					</div>
					<div class="modal-body">
						<div>
							<label class="no"></label> <input id="no" class="form-control" name="no">
						</div>
						<div>
							<label class="title"></label> <input id="title" class="form-control" name="title">
						</div>
						<div>
							<label>강의 URL</label> <input id="url" class="form-control" name="studyUrl">
						</div>
					</div>
					
					<div class="modal-footer">
						<button type="button" id="sessionRegisterBtn" class="btn btn-default">세션 저장</button>
						<button type="button" id="studyRegisterBtn"	class="btn btn-default">강의 저장</button>
						<button type="button" id="modal_close_btn" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				<!-- 모달 내용------------------------------------>
			</div>
			<div class="modal_layer"></div>
		</div>
		<!-- 모달 -------------------------------------->          	        
	</div>
</body>
</html>
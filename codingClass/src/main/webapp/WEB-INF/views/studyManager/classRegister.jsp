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
	
	//form태그 변수
	var formObj = $("form[role='form']");
	
	//모달창에 사용하는 변수
	var modal = $("#modal");
	var modalInputUrl = modal.find("input[name='studyUrl']");
	
	//가변형 리스트 UL
	var sessionUL = $(".sessionList ul");
	
	
	//세션 갯수 정하는 변수
	$("#sessionNum").on("change",function(){
		
		alert("세션 갯수 변경시 작성중이던 내용은 사라집니다.");		
		
		sessionUL.find("li").remove();
		sessionUL.find("div").remove();		
		
		var str= "";		
		
		for(i = 1; i <= $("#sessionNum").val(); i++){
			
			str+= "<li>";
				str+= "<span> 세션번호 "+i+"</span>";    		
		
				str+= "<input class='form-control' name='sessionTitle' value='세션 이름'>";
				
				str+= "<select data-index='"+i+"' name='studyVideoNum' class='studyVideoNum' id='studyVideoNum"+i+"'>";
					str+= "<option value='0'>강의 갯수</option>";
					str+= "<option value='1'>1</option>";
					str+= "<option value='2'>2</option>";
					str+= "<option value='3'>3</option>";
					str+= "<option value='4'>4</option>";
					str+= "<option value='5'>5</option>";
					str+= "<option value='6'>6</option>";
					str+= "<option value='7'>7</option>";
					str+= "<option value='8'>8</option>";
					str+= "<option value='9'>9</option>";
					str+= "<option value='10'>10</option>";
				str+= "</select>";		
				
			str+= "</li>";	
			
		};				
	
		sessionUL.append(str);
	});	
	
	
	//강의 갯수 정하는 변수
	$(".sessionList").on("change","select",function(){		
		
		var sessionIndex = $(this).attr("data-index");
		var studyVideoNum = $(this).val();
		
		var str= "";
		
		$(".sessionList ul li").each(function(index,arr){
			
			if((sessionIndex - 1) == index){
				
				var afterStr = $(arr).html().split('</select>');
				
				str+="<li>";
					str += afterStr[0];
					str += "</select>";			
				
				for(i = 1; i <= studyVideoNum; i++){
					
					str+= "<div>";
						
						str+= "<span> 강의 번호"+i+"</span>";    		
				
						str+= "<textarea required='required' class='form-control' rows='1'>강의 제목</textarea>";
						str+= "<textarea required='required' class='form-control' rows='1'>강의 url</textarea>";						
							
					str+= "</div>";					
				};				
				
				str += "</li>";
			
			}else{				
				str+="<li>";
					str += $(arr).html();
				str += "</li>";
				str += "</li>";				
			};
		});
		
		sessionUL.find("li").remove();
		sessionUL.find("div").remove();	
		
		sessionUL.append(str);
	});		
	
	
	//강의 수정 버튼을 눌렀을 경우 모달창 상태
	//.show .hide .modal은 부트스트랩 함수
	$(".sessionList").on("click","button",function(e) {
		e.preventDefault();
		console.log("강의 수정 버튼 클릭");
		
		modal.find("input").val("");//input태그 값 삭제		
				
		$("#modal").modal("show");			
	});
 
	
	//클래스 등록 버튼
	//클릭시 classform submit
	$(".registerBtn").on("click",function(e){
		e.preventDefault();
		console.log("클래스 저장버튼 클릭")
		
		var str="";
		
		//classNo 빈칸 체크
		/*
		if($("#classNo").val() == ""){
			alert("클래스 번호를 입력하세요");
			return;
		}
		
		//userNo 빈칸 체크
		if($("#userNo").val() == ""){
			alert("유저 번호를 입력하세요");
			return;
		}*/
		
		$(".sessionList ul li input").each(function(i,obj){
			
			var sessionObj = $(obj);		
			
			
			str+="<input type='hidden' name='sessionList["+i+"].sessionTitle' value='"+sessionObj.val()+"'>";
			
			$(".sessionList ul li textarea").each(function(index,studyVideoObj){
				
				var studyVideoObj = $(studyVideoObj);
				
				var j = 0;
				
				if(index%2 == 1){
					str+="<input type='hidden' name='studyVideoList["+j+"].studyVideoUrl' value='"+studyVideoObj.val()+"'>";
					j++;
				}else{
					str+="<input type='hidden' name='studyVideoList["+j+"].studyVideoTitle' value='"+studyVideoObj.val()+"'>";
				}
			}			
		});
		
	//세션폼 강의폼 넘버 넘겨받음
	//나중에 반드시 삭제!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/* $("#sessionClassNo").val($("#classNo").val());	
	$("#studyVideoSessionNo").val($("#sessionNo").val()); */	
	
	
		formObj.append(str).submit();
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
        <form role="form" id="classForm" action="/studyManager/classRegister" method="post">		
	    	
	    	
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
	    
	    <!-- 강의 수정 구획 -->
	    <select name="sessionNum" id="sessionNum">
	    			<option value="0">세션 갯수</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
		</select>
		
	    <div class='sessionList'>		
	    	<ul>  	    		
	    			    		
	    	</ul>	    
	    </div>	    
	    <!-- 강의 수정 구획 ------------------------------------------>
				
		<button type="button" class="registerBtn">클래스 저장</button>     	
    	       	        
	</div>
</body>
</html>
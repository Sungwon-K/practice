<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../includes/header.jsp" %>

<script src="/resources/js/reply.js"></script>

<script>
$(document).ready(function() {
    
	var bnoValue = "<c:out value='${board.bno}'/>";
	var replyUL=$(".cahr"); //<ul></ul> 태그
	
	shewList(1);
	
	function showList(page){
		console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		replyService.getList({bno:bnoValue, page:page ||1},
				function(list){
					var str="";
					//목록이 없을 경우
					if(list == null || list.lengh==0){
						replyUL.html("");
						return;
					}
					//목록이 있는 경우
					for(var i=0,len=list.length||0;i<len;i++){
						str+="<li class='left clearfix' data-rno='"+list[i].rno+"'>";
						str+="<div><div class='header'><strong class = 'primay-font'>"+list[i].replyer+"</strong>";
						str+="<small class = 'pull-right text-muted'>"+replyService.displayTime(list[i].replyDate)+"</small></div>";
						str+="<p>"+list[i].reply+"</p></div>";
						str+="</li>";
					}
					console.log(str);
					replyUL.html(str);
				}
		);
	}
    
	
	//미리 찾아놓는다.
	//같은 엘리먼트를 여러번 탐색할 경우, 탐색을 미리해서 레퍼런스를 만들고
	//레퍼런스를 재활요하는 것이 속도에 도움이 됨
	
	
	var modal=$("#myModal");
	var modalInputReply=modal.find("input[name='reply']");
	var modalInputReplyer=modal.find("input[name='replyer']");
	var modalInputReplyDate=modal.find("input[name='replyDate']");
	
	var modalModBtn=$("#modalModBtn");
	var modalRemoveBtn=$("#modalRemoveBtn");
	var modalRegisterBtn=$("#modalRegisterBtn");
	
	$("#addReplyBtn").on("click",function(e){
		console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		modal.find("input").val("");//input태그 값 삭제
		modalInputReplyDate.closest("div").hide();//replyDate항목 안보이게
		modal.find("button[id!='modalCloseBtn']").hide();//닫기버튼만 제외하고 다른 버튼들은 안보이게
		modalRegisterBtn.show();//등록버튼은 보이게
		
		$("#myModal").modal("show");
	});
	
	
	modalRegisterBtn.on("click",function(3){
		var reply={
			reply:modalInputReply.val(),
			replyer:modalInputReplyer.val(),
			bno:bnoValue
		};
		
		replyService.add(reply,function(result){
			alert(result);
			modal.find("input").val("");//입력항목 초기화
			modal.modal("hide");
			
			showList(1);//목록새로고침
		});
	});
	
	var operFrom=$("#operForm");
    $("button[data-oper='modify']").on("click", function(e) {
       operForm.attr("action", "/board/modify").submit();
    })
    
    $("button[data-oper='list']").on("click", function(e) {
       // operForm.find("#bno").remove(); 
       operForm.attr("action", "/board/list");
       operForm.submit();
    })
    
    $(".chat").on("click","li",function(e){
    	var rno=$(this).data("rno");
    	console.log(rno);
    	
    	replyService.get(rno,function(reply){
    		modalInputReply.val(reply.reply);
    		modalInputReplyer.val(reply.replyer);
    		modalInputReplydate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readony")
    		modal.data("rno",reply.rno)
    		modal.find("button[id!='modalCloseBtn']").hide();
    		modalModBtn.show();
    		modalRemoveBtn.show();
    		$("#myModal").modal("show");
    	});
    });
	
	/* 
	//replyService add 테스트
	replyService.add(
		{reply:"JS TEST", replyer:"tester", bno:bnoValue},
		//callback처리
		function(result){
			alert("Result: " + result);
		}
		//error생략
	);
	
	replyService.getList({bno:bnoValue, page:1}, 
						function(list){
							for(var i=0, len = list.length || 0; i < len; i++){
								console.log(list[i]);
						 	}
						}
	);
	
	 */
})
</script>

		<!-- 컨텐츠 ----------------------->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                
                        <div class="panel-heading">
                            	글내용
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                           	
                        		<div class="form-group">
                        			<label>글번호</label>
                        			<input class="form-control" name='bno'
                        			value='<c:out value = "${board.bno}"/>'readonly="readonly">
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Title</label>
                        			<input class="form-control" name='title'
                        			value='<c:out value = "${board.title}"/>'readonly="readonly">
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Content</label>
                        			<textarea class="form-control" rows="3" name='content' readonly="readonly">
                        				<c:out value="${board.content}"/>
                        			</textarea>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Writer</label>
                        			<input class="form-control" name='writer'
                        			value='<c:out value = "${board.writer}"/>'readonly="readonly">
                        		</div>
                        		
                        		<button data-oper='modify' class="btn btn-default">Modify</button>
                        		<button data-oper='list' class="btn bnt-info">List</button>
                        			
                        		<form id='operForm' action="/board/modify" method="get">
                        			<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
                        			<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
                        			<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
                        			<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>
                        			<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>
                        		</form>
                        
                        </div>              
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    
                    <div class="row">
                    	<div class="col-lg-12">
                    	<!-- 댓글 목록 -------------------------->
                    	<div class="panel panel-default">
                    	<div class="panel-heading">
                    		<i class="fa fa-comments fa-fw"></i> Reply
                    		<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">
                    			New Reply
                    		</button>
                    	</div>                    	
                    	<!-- /.panel-heading -->
                    	<div class="panel-body">
                    		<ul class="chat">
                    		
                    		</ul>
                    	</div>
                    	<!-- /.panel-body -->
                    	</div>
                    	<!-- 댓글 목록 -->
                    	</div>
                    </div>
                    
                    <!-- 모달창 ---------------------->
                    <div id="myModal" class="modal fade" role="dialog">
                    	<div class="modal-dialog">
                    	
                    		<!-- modal content  -->
                    		<div class="modal-content">
                    			<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">$times;</button>
									<h4 class="modal-title">REPLY MODAL</h4>              			
                    			</div>                    		
                    			<div class="modal-body">
                    				<div class="form-group">
                    					<label>Reply</label>
                    					<input class="form-control" name="reply">
                    				</div>
                    				<div class="form-group">
                    					<label>Replyer</label>
                    					<input class="form-control" name="replyer">
                    				</div>
                    				<div class="form-group">
                    					<label>ReplyDate</label>
                    					<input class="form-control" name="replyDate">
                    				</div>
                    			</div>                  
                    			<div class ="modal-footer">
                    				<button type="button" id="modalModBtn" class="btn btn-default">Modify</button>
                    				<button type="button" id="modalRemoveBtn" class="btn btn-default">Remove</button>
                    				<button type="button" id="modalRegisterBtn" class="btn btn-default">Register</button>
                    				<button type="button" id="modalCloseBtn" class="btn btn-default">Close</button>
                    			</div>                    			                    		
                    		</div>
                    	</div>
                    </div>
                    <!-- 모달창 -->
                </div>
                <!-- /.col-lg-12 -->
            </div>          
        <!-- 컨텐츠 -->
  
<%@ include file="../includes/footer.jsp" %>
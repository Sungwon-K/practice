<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="../includes/header.jsp"%>


<script src="/resources/js/reply.js"></script>
<script src="http://code:jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/dist/css/pointer.css">


<script>
	$(document).ready(function() {

		var bnoValue = '<c:out value="${board.bno}"/>';
		var passValue = '<c:out value="${board.password}"/>';
				
		var replyUL = $(".chat");// <ul></ul>태그
		
		(function(){
			
			var bno = '<c:out value="${board.bno}"/>';
			
			$.getJSON("/board/getAttachList", {bno: bno}, function(arr){
				
				console.log(arr);
				
				var str= "";
				
				$(arr).each(function(i, attach){
					
					//image type
					if(attach.fileType){
						
						var fileCallPath = encodeURIComponent( attach.uploadPath + "/s_" + attach.uuid + "_" + attach.fileName);
																		
						str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"'>";
							str += "<div>";
								str+= "<img src='/display?fileName="+fileCallPath+"'>";
							str += "</div>";
						str += "</li>";
					
					}else{
						
						str += "<li data-path='"+attach.uploadPath+"' data-uuid='"+attach.uuid+"' data-filename='"+attach.fileName+"' data-type='"+attach.fileType+"'>";
							str += "<div>";
								str += "<span>  "+attach.fileName+"  </span><br>";
								str += "<img src='/resources/img/attach.png'>";
							str += "</div>";
						str += "</li>";
					}
				});
				
				$(".uploadResult ul").html(str);
				
			});//end getjson
		})();//end function				

		showList(1);
		
		function showList(page) {
			console.log("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
			replyService.getList({bno : bnoValue,
								page : page || 1},
								function(replyCnt, list) {
									console.log("replyCnt:"	+ replyCnt);
									console.log("list: " + list);
									console.log(list);

									//page가 -1이면 마지막페이지로 이동.등록후 사용
									if (page == -1) {
										pageNum = Math.ceil(replyCnt / 10.0);
										showList(PageNum);
										return;
									}

									var str = "";
									//목록이 없을 경우
									if (list == null || list.length == 0) {
										replyUL.html("");
										return;
									}
									
									//목록이 있는 경우
									for (var i = 0, len = list.length || 0; i < len; i++) {
										str += "<li class='left clearfix' data-rno='"+list[i].rno+"'>";
										str += "<div><div class='header'><strong class='primary-font'>"	+ list[i].replyer+ "</strong>";
										str += "<small class='pull-right text-muted'>"+ replyService.displayTime(list[i].replyDate)	+ "</small></div>";
										str += "<p>"+ list[i].reply+ "</p></div>";
										str += "</li>"
									}
									
									console.log(str);
									replyUL.html(str);
									showReplyPage(replyCnt);//댓글페이징
									}

			);
			
		}
		//미리 찾아놓는다.
		//같은 엘리먼트를 여러번 탐색할 경우, 탐색을 미리해서 레퍼런스를 만들고
		//레퍼런스를 재활용하는 것이 속도에 도움이됨

		var modal = $("#myModal");
		var psmodal = $("#passModal");
		var modalInputReply = modal.find("input[name='reply']");
		var modalInputReplyer = modal.find("input[name='replyer']");
		var modalInputReplyDate = modal.find("input[name='replyDate']");

		var modalModBtn = $("#modalModBtn");
		var modalRemoveBtn = $("#modalRemoveBtn");
		var modalRegisterBtn = $("#modalRegisterBtn");

		$("#addReplyBtn").on("click", function(e) {
			console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			
			modal.find("input").val("");//input태그 값 삭제
			modalInputReplyDate.closest("div").hide();//replyDate항목 안보이게
			modal.find("button[id!='modalCloseBtn']").hide();//닫기번튼만 제외하고 다른버튼들은 안보이게
			modalRegisterBtn.show();//등록버튼은 보이게				

			$("#myModal").modal("show");			
		});

		$("#pwckBtn").on("click", function(e) {
			$("#passModal").find("input").val("패스워드를 입력하세요.");//password태그 값 삭제
			$("#passModal").modal("show");
		});

		modalRegisterBtn.on("click", function(e) {
			var reply = {
					reply : modalInputReply.val(),
					replyer : modalInputReplyer.val(),
					bno : bnoValue
			};

			replyService.add(reply, function(result) {
				alert(result);
				modal.find("input").val("");//입력항목초기화
				modal.modal("hide");

				//showList(1);//목록새로고침
				showList(pageNum);//마지막페이지로 이동
				});
			});

		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click",function(e) {
			
			operForm.attr("action", "/board/modify");
			operForm.submit();
		});
		
		
		$("button[data-oper='list']").on("click", function(e) {
			//operForm.find("#bno").remove();
			operForm.attr("action", "/board/list");
			operForm.submit();
		});
		
		
		$("#pwck").on("focus",function(){
			$("#pwck").val("");			
		});
		
				
		$("button[data-oper='remove']").on("click",function(e) {
			
			var pwck = $("#pwck").val();
			
			if(pwck == passValue){	
				
				operForm.attr("action", "/board/remove");
				operForm.attr("method", "post");
				operForm.submit();	
			
			}else{
				alert("비밀번호가 잘못되었습니다.");
				$("#passModal").modal("hide");
			}								
		});

		$(".chat").on("click","li",function(e) {
			
			var rno = $(this).data("rno");
			
			console.log(rno);
		
			replyService.get(rno,function(reply) {
				
				modalInputReply.val(reply.reply);
				modalInputReplyer.val(reply.replyer);
				modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readony");
				
				modal.data("rno",reply.rno);
				modal.find("button[id!='modalCloseBtn']").hide();
				modalModBtn.show();
				
				modalRemoveBtn.show();
				
				$("#myModal").modal("show");
			});
		});

		//댓글수정
		modalModBtn.on("click", function(e) {
			console.log("댓글수정");

			var reply = {
					rno : modal.data("rno"),
					reply : modalInputReply.val()
			};
			
			replyService.update(reply, function(result) {
				alert(result);
				modal.modal("hide");
				showList(pageNum);
			});
		});

		//댓글삭제
		modalRemoveBtn.on("click", function(e) {
			var ckRemove = confirm("댓글을 삭제하시겠습니까?");
			
			if (ckRemove) {
				var rno = modal.data("rno");
				
				replyService.remove(rno, function(result) {
					alert(result);
					modal.modal("hide");
					showList(pageNum);
				});
			} else {
			
				return;
			}
		});

		//댓글 페이징처리
		var pageNum = 1;
		var replyPageFooter = $(".panel-footer");

		function showReplyPage(replyCnt) {
			//끝페이지
			var endNum = Math.ceil(pageNum / 10.0) * 10;
			//시작페이지
			var startNum = endNum - 9;
			//prev필요여부 Flag
			var prev = startNum != 1;
			//next필요여부 Flag
			var next = false;
			//계산으로 구한 endPage보다 실제페이지가 적으면 보정
			if (endNum * 10 >= replyCnt) {
				endNum = Math.ceil(replyCnt / 10.0);
			}
			//endPage보다 실제페이지가 많으면 next를 true로 변경
			if (endNum * 10 < replyCnt) {
				next = true;
			}
			
			var str = "<ul class='pagination pull-right'>";

			if (prev) {
				str += "<li class='page-item'><a class='page-link' href='"
					+ (startNum - 1) + ">Previous</a></li>";
			}

			for (var i = startNum; i <= endNum; i++) {
				//현재페이지번호이면 active클래스 설정
				var active = pageNum == i ? "active" : "";
			
				str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"
					+ i + "</a></li>";
			}

			if (next) {
				str += "<li class='page-item'><a class='page-link' href='"
					+ (endNum + 1) + ">Next</a></li>";
			}

			str += "</ul>";
			console.log(str);
			replyPageFooter.html(str);
		
		}

		//댓글페이지번호를 클릭시 해당페이지로 이동
		replyPageFooter.on("click", "li a", function(e) {
			e.preventDefault();
			console.log("page click");
			var targetPageNum = $(this).attr("href");
			console.log("targetPageNum: " + targetPageNum);
			pageNum = targetPageNum;//pageNum를 클릭한 페이지번호로 변경
			showList(pageNum);
		
		});
		
		$(".uploadResult").on("click","li",function(e){
			console.log("view image");
			
			var liObj = $(this);
			
			var path = encodeURIComponent(liObj.data("path")+"/"+liObj.data("uuid")+"_"+liObj.data("filename"));
			
			if(liObj.data("type")){
				showImage(path.replace(new RegExp(/\\/g),"/"));
			}else{
				//download
				self.location="/download?fileName="+path;
			}
		});
		
		function showImage(fileCallPath){
			
			alert(fileCallPath);
			
			$(".bigPictureWrapper").css("display","flex").show();
			
			$(".bigPicture")
			.html("<img src='/display?fileName="+fileCallPath+"'>")
			.animate({width:'100%',height:'100%'},1000);
		}
		
		$(".bigPictureWrapper").on("click",function(e){
			$(".bigPicture").animate({width:'0%',height:'0%'},1000);
			setTimeout(function(){
				$('.bigPictureWrapper').hide();
			}, 1000);
		});

	});
</script>

<!--  컨텐츠 ---------------------------------->
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Board</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글내용</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="form-group">
						<label>글번호</label> <input class="form-control" name="bno"
							value='<c:out value="${board.bno}"/>' readonly>
					</div>
					<div class="form-group">
						<label>Title</label> <input class="form-control" name="title"
							value='<c:out value="${board.title}"/>' readonly>
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" rows="3" name="content" readonly><c:out
								value="${board.content}" /></textarea>
					</div>
					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer"
							value='<c:out value="${board.writer}"/>' readonly>
					</div>
					<button data-oper="modify" class="btn btn-default">수정</button>
					<button data-oper="list" class="btn btn-default">목록</button>
					<button id="pwckBtn" class="btn btn-default">삭제</button>

					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id="bno" name="bno" value="<c:out value='${board.bno}'/>">
						<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }'/>">
						<input type="hidden" name="amount" value="<c:out value='${cri.amount}'/>">
						<input type="hidden" name="type" value='<c:out value="${cri.type}"/>'>
						<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}"/>'>
						<input type="hidden" name="password" value='<c:out value="${board.password}"/>'>						
					</form>


				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
			
			<!-- 첨부파일 영역 --------------------->
			<div class='bigPictureWrapper'>
				<div class='bigPicture'>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class= "panel panel-default">
						
						<div class="panel-heading">Files</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
						
							<div class='uploadResult'>
								<ul>
								</ul>
							</div>
						</div>
						<!-- end panel-body -->
					</div>
					<!-- end panel-body -->
				</div>
				<!-- end panel -->
			</div>
			<!-- /.row -->
			
			<!-- 첨부파일 영역 -->
			<div class="row">
				<div class="col-lg-12">
					<!-- 댓글목록 -------------------------------------------->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-comments fa-fw"></i> Reply
							<button id="addReplyBtn"
								class="btn btn-primary btn-xs pull-right">New Reply</button>

						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<ul class="chat">

							</ul>
						</div>
						<!-- /.panel-body -->

						<!-- 댓글 페이징 ------------------------------------------>
						<div class="panel-footer"></div>
						<!-- 댓글 페이징 -->

					</div>

					<!-- /.panel -->

					<!-- 댓글목록 -->
				</div>
			</div>

			<!-- 패스워드 모달창 ----------------------------------------->
			<div id="passModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- 모달 컨테이너 -------------------------------------->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">패스워드 체크</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Password</label>
								<input class="form-control" id="pwck" name="pwck">
							</div>
						</div>
						<div class="modal-footer">
							<button data-oper="remove" class="btn btn-default">삭제</button>
							<button type="button" id="modalCloseBtn" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- 모달 컨테이너 -->

				</div>
			</div>
			<!-- 패스워드 모달창 -->

			<!-- 모달창 ----------------------------------------------->
			<div id="myModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">REPLY MODAL</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label>Reply</label> <input class="form-control" name="reply">
							</div>
							<div class="form-group">
								<label>Replyer</label> <input class="form-control"
									name="replyer">
							</div>
							<div class="form-group">
								<label>Reply Date</label> <input class="form-control"
									name="replyDate">
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" id="modalModBtn" class="btn btn-default">Modify</button>
							<button type="button" id="modalRemoveBtn" class="btn btn-default">Remove</button>
							<button type="button" id="modalRegisterBtn"
								class="btn btn-default">Register</button>
							<button type="button" id="modalCloseBtn" class="btn btn-default"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>
			<!-- 모달창 -->


		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->

</div>
<!-- 컨텐츠 -->

<script>
	$(document).ready(function() {

	});
</script>

<script>
	/* console.log("=================");
	console.log("!!!!!!!!!!");
	
	var bnoValue='<c:out value="${board.bno}"/>';
	replyService.add(
		{reply:"JS TEST",replyer:"tester",bno:bnoValue},
		function(result){
			alert("result : "+result);
		}
	);
	
	replyService.getList({bno:bnoValue,page:1},
						function(list){
							for(var i=0,len=list.length||0;i<len;i++){
								console.log(list[i]);
							}
						}		
	); */
</script>

<%@ include file="../includes/footer.jsp"%>

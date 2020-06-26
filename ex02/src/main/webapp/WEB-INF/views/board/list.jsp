<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../includes/header.jsp" %>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({},null,null);
		
		function checkModal(result){			
			
			if(result === '' || history.state){
				return;
			}
			
			if(parseInt(result) > 0) {
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		
		
		//등록화면으로 이동
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
		
		var actionForm=$("#actionForm");
		
		$(".paginate_button a").on("click",function(e){
			
			e.preventDefault();//다음페이지로 이동을 막는다.
			
			console.log('click');
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});		
		
		$(".move").on("click", function(e){
			
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
			actionForm.attr("action","/board/get");
			actionForm.submit();
		});
		
		var searchForm = $("#searchForm");
		
		$(".amountbox").on("change",function(e){
			e.preventDefault(); //전송방지
			searchForm.submit();
		})
		
		
		$("#searchForm button").on("click",function(e){
			e.preventDefault(); //전송방지
			
		if(!searchForm.find("option:selected").val()){
			alert("검색종률를 선택하세요");
			return false;
		}
		
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요");
			return false;
		}
		
		searchForm.find("input[name='pageNum']").val("1");
		
		searchForm.submit();
		
		});		
		
		
	});
</script>
<style>
.selectbox{
  width: 15%;
  height: 20px;

  border: 1px;
  border-radius: 4px;
  background-color: #f1f1f1;
 }
 
 .amountbox{
 	width: 8%;
 }
</style>
		<!-- 컨텐츠 ----------------------->
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
                        <div class="panel-heading">
                  		          글목록
                  			<button id="regBtn" type="button" class="btn btn-danger btn-xs pull-right">글쓰기</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                               	<tbody>
                               	<c:forEach items="${list }" var="board">
                               		<tr>
                               			<td><c:out value="${board.bno}"/></td>
                               			<td width="200">
                               				<%-- <a href='/board/get?bno=<c:out value="${board.bno}"/>'>
                               					<c:out value="${board.title}"/>
                               				</a> --%>
                               				<a class="move" href="<c:out value='${board.bno}'/>">
                               					<c:out value="${board.title }"/>                               					
                               				</a>                               	
                               				<span class="badge"><b><c:out value="${board.replyCnt }"/></b></span>                                			
                               			</td>
                               			<td><c:out value="${board.writer}"/></td>
                               			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                               			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                               		</tr>
                               	</c:forEach>
                               	</tbody>
                            </table>  
                            
                            <!-- 검색폼 ------------------------------------->
                           	<div class='row'>
                           		<div class="col-lg-12">
                           		
	                           		<form id='searchForm' action="/board/list?" method='get'>
	                           			<select name="amount" class="selectbox amountbox">
	                           				<option value="5" <c:out value="${pageMaker.cri.amount eq '5'?'selected':''}"/>>5</option>
	                           				<option value="10" <c:out value="${pageMaker.cri.amount eq '10'?'selected':''}"/>>10</option>
	                           				<option value="15" <c:out value="${pageMaker.cri.amount eq '15'?'selected':''}"/>>15</option>
	                           				<option value="20" <c:out value="${pageMaker.cri.amount eq '20'?'selected':''}"/>>20</option>
	                           			</select>
	                           			<select name='type' class='selectbox'>
	                           				<option value="" <c:out value="${pageMaker.cri.type==null?'selected':''}"/>>--</option>
		                           				<option value="T" <c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>제목</option>
		                           				<option value="C" <c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>내용</option>
		                           				<option value="W" <c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>작성자</option>
		                           				<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>제목  or 내용</option>
		                           				<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>제목  or 작성자</option>
		                           				<option value="TWC" <c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>제목  or 내용 or 작성자</option>
	                           			</select>
	                           			<input type='text' name='keyword' value="<c:out value='${pageMaker.cri.keyword}'/>"/>
	                           			<input type='hidden' name='pageNum' value="<c:out value='${pageMaker.cri.pageNum}'/>"/>
	                           			<input type='hidden' name='amount' value="<c:out value='${pageMaker.cri.amount}'/>"/>
	                           			<button class='btn btn-default'>Search</button>
	                           		</form>
                           		</div>
                           	</div>
                            <!-- 검색폼 -->         
                                 
                            <form id='actionForm' action="/board/list" method='get'>
								<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
								<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
								<input type='hidden' name='type' value="<c:out value='${pageMaker.cri.type }'/>">
								<input type='hidden' name='keyword' value="<c:out value='${pageMaker.cri.keyword }'/>">															
							</form>  
                            <!-- paging ----------------------------------->
                            <div class="pull-right">
								<ul class="pagination">
								<c:if test="${pageMaker.prev}">
									<li class="paginate_button previous">
										<a href="${pageMaker.startPage-1}">prev</a></li>
								</c:if>
								
								<c:forEach var = "num" begin="${pageMaker.startPage}" end="${pageMaker.endPage }">
									<li class="paginate_button ${pageMaker.cri.pageNum == num? "active":""}">
										<a href="${num}">${num}</a></li>
								</c:forEach>
								
								<c:if test="${pageMaker.next}">
									<li class="paginate_button next">
										<a href="${pageMaker.endPage+1}">next</a></li>
								</c:if>
								</ul>
							</div>
                            <!-- paging --> 
                                                        												
							<!-- Modal -->
							<div id="myModal" class="modal fade" role="dialog">
								<div class="modal-dialog">
							
							    	<!-- Modal content-->
							    	<div class="modal-content">
								      	<div class="modal-header">
							    	    	<button type="button" class="close" data-dismiss="modal">&times;</button>
								    	    <h4 class="modal-title">알림</h4>
							      		</div>
							      		<div class="modal-body">
									        <p>처리가 완료되었습니다.</p>
								      	</div>
								      	<div class="modal-footer">
								        	<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								      	</div>
							    	</div>
								</div>
							</div>
							<!-- Modal -->                                              
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>          
        </div>
        <!-- 컨텐츠 -->
  
<%@ include file="../includes/footer.jsp" %>
    
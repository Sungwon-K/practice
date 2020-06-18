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
		
		function checkModal(result){
			
			if(result === ''){
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
		
	});
</script>
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
                               				<a href='/board/get?bno=<c:out value="${board.bno}"/>'>
                               					<c:out value="${board.title}"/>
                               				</a>
                               			</td>
                               			<td><c:out value="${board.writer}"/></td>
                               			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
                               			<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
                               		</tr>
                               	</c:forEach>
                               	</tbody>
                            </table>  
                                                        												
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
    
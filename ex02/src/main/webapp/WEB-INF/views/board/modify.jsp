<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../includes/header.jsp" %>
<script>
	$(document).ready(function() {
		
		var formObj=$("form");//form태그를 찾음
		
		$('button').on("click",function(e){
				
			e.preventDefault();//전송을 막음
			
			var operation=$(this).data("oper");// data-oper 속성값을 구함
			console.log(operation);
			
			if(operation==="remove"){			
				
				var res = confirm("정말 삭제하시겠습니까?");				
				
				if(res){
					formObj.attr("action","/board/remove");//form의 action값을 변경		
				}
			
			}else if(operation === "list"){
			
				//self.location = "/board/list";//목록으로 이동
				//return;
				
				formObj.attr("action","/board/list").attr("method","get");
				
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();
				
				formObj.empty();
				
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);				
			}
			
			formObj.submit();
		});
		
	});
</script>

		<!-- 컨텐츠 ----------------------->
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Register</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	글 등록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                           	<form role="form" action="/board/modify" method="post">
                           		<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }'/>">
                           		<input type="hidden" name="amount" value="<c:out value='${cri.amount }'/>">
                           		<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }'/>">
                           		<input type="hidden" name="type" value="<c:out value='${cri.type }'/>">
                           	
                        		<div class="form-group">
                        			<label>Bno</label>
                        			<input class="form-control" name='bno'
                        				value='<c:out value="${board.bno }"/>' readonly="readonly">
                        		</div>

                        		<div class="form-group">
                        			<label>Title</label>
                        			<input class="form-control" name='title'
                        				value='<c:out value="${board.title }"/>'>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Content</label>
                        			<textarea class="form-control" rows="3" name='content'>
                        				<c:out value="${board.content }"/>
                        			</textarea>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Writer</label>
                        			<input class="form-control" name='writer'
                        				value='<c:out value="${board.writer }"/>' readonly="readonly">
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Update Date</label>
                        			<input class="form-control" name='UpdateDate'
                        				value='<fmt:formatDate pattern ="yyyy/MM/dd" value= "${board.updateDate}"/>' readonly="readonly">
                        		</div>
                        		
                        		<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                        		<button type="submit" data-oper='remove' class="btn bnt-danger">Remove</button>
                        		<button type="submit" data-oper='list' class="btn bnt-info">List</button>
                           	</form>
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
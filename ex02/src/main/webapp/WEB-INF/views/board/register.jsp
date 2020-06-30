<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<link rel="stylesheet" type="text/css" href="/resources/dist/css/pointer.css">
<%@ include file="../includes/header.jsp" %>
<script>
	$(document).ready(function(e){
		
		var formObj = $("form[rold='form']");
		var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
		var maxSize = 5242880; //5MB
		
		function showUploadResult(uploadResultArr){
			if(!uploadResultArr || uploadResultArr.length == 0){ return; }
			
			var uploadUL = $(".uploadResult ul");
			
			var str= "";
			
			$(uploadResultArr).each(function(i,obj){
				
				//image type
				if(obj.image){

					var fileCallPath = encodeURIComponent( obj.uploadPath+"/s_"+obj.uuid + "_"+obj.fileName);
					
					//var originPath = obj.uploadPath + "\\"+obj.uuid+"_" + obj.fileName;
					
					//originPath = originPath.replace(new RegExp(/\\/g),"/");
					
					//console.log(fileCallPath);
					
					str+="<li>";
						str+="<div>";
							str+="<span> "+obj.fileName+"   </spane>";
							str+="<button type='button' class='btn btn-warning btn-circle'>";
								str+="<i class='fa fa-times'></i>";
							str+="</button><br>";
							
							str+="<img src='/display?fileName="+fileCallPath+"'>";
						str+="</div>";						
					str+="</li>";
					
				
				}else{						
					
					var fileCallPath = encodeURIComponent( obj.uploadPath+"/"+obj.uuid + "_"+obj.fileName);
					console.log(fileCallPath);
					
					var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
					
					str += "<li>";
						str += "<div>";
							str += "<span> "+obj.fileName+"   </span>";
							str += "<button type='button' class='btn btn-warning btn-circle'>";
								str+= "<i class='fa fa-times'></i>"
							str += "</button><br>";
							str += "<img src='/resources/img/attach.png'>";							
						str	+= "</div>";
					str	+= "</li>";
				}
				
			});
			uploadUL.append(str);
		}
		
		$("button[type='submit']").on("click",function(e){
			e.preventDefault();
			console.log("submit clicked");
		});
		
		function checkExtension(fileName, fileSize){
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			
			if(regex.test(fileName)){
				alert("해당 종류의 파일은 업로드할 수 없습니다.");
				return false;
			}
			
			return true;
		}
		
		$("input[type='file']").change(function(e){
			var formData = new FormData();
			
			var inputFile = $("input[name='uploadFile']");
			
			var files = inputFile[0].files;
			
			for(var i=0; i < files.length; i++){
				if(!checkExtension(files[i].name,files[i].size)){
					return false;
				}
				formData.append("uploadFile",files[i]);
			}
			
			$.ajax({
				url: '/uploadAjaxAction',
				processData: false,
				contentType: false,
				data: formData,
				type: 'POST',
				dataType:'json',
					success: function(result){
							console.log(result);
							showUploadResult(result); //업로드 결과 처리 함수
					}
			});//$.ajax
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

                           	<form role="form" action="/board/register" method="post">
                        		<div class="form-group">
                        			<label>제목</label>
                        			<input class="form-control" name='title'>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Content</label>
                        			<textarea class="form-control" rows="3" name='content'></textarea>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>Writer</label>
                        			<input class="form-control" name='writer'>
                        		</div>
                        		
                        		<div class="form-group">
                        			<label>password</label>
                        			<input class="form-control" name='password'>
                        		</div>
                        		
                        		<button type="submit" class="btn btn-default">Submit</button>
                        		<button type="reset" class="btn bnt-default">Reset</button>
                           	</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div> 
            <!-- /.row -->
            <!-- 새로운 row --------------------->
            <div class = "row">
            	<div class="col-log-12">
            		<div class="panel panel-default">
            			
            			<div class="panel-heading">파일 첨부</div>
            			<!-- /.panel-heading -->
            			<div class="panel-body">
            				<div class="form-group uploadDiv">
            					<input type="file" name='uploadFile' multiple>
            				</div>
            				
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
            <!-- 새로운 row -->         
        </div>
        <!-- 컨텐츠 -->
  
<%@ include file="../includes/footer.jsp" %>
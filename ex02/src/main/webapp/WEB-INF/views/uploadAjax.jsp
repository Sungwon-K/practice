<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/dist/css/pointer.css">
</head>
<body>
	
	<div class='uploadDiv'>
		<input type='file' name='uploadFile' multiple>
	</div>
	
	<div class='uploadResult'>
		<ul>
		
		</ul>
	</div>
	
	<div class='bigPictureWrapper'>
		<div class="bigPicture"></div>
	</div>
	
	<button id="uploadBtn">Upload</button>
	
	<!-- jquery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script>		
		function showImage(fileCallPath){			
			$(".bigPictureWrapper").css("display","flex").show();
			
			$(".bigPicture")
			.html("<img src='/display?fileName="+encodeURI(fileCallPath)+"'>")
			.animate({width:'100%',height:'100%'},1000);					
		};
		
		$(document).ready(function(){
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5MB
			
			$(".uploadResult").on("click","span",function(e){
				
				var targetFile = $(this).data("file");
				var type = $(this).data("type");
				console.log(targetFile);
				
				$.ajax({
					url: '/deleteFile',
					data: {fileName: targetFile, type:type},
					dataType: 'text',
					type: 'POST',
						success : function(result){
							alert(result);
						}
				}); //$.ajax
				
				//가장 가까운 li 삭제
				$(this).closest("li").remove();
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
			
			var cloneObj = $(".uploadDiv").clone();			
			
			$("#uploadBtn").on("click",function(e){
				var formData = new FormData(); //form태그에 대응되는 객체
				var inputFile=$("input[name='uploadFile']");//input file 태그찾기
				
				//무조건 배열로 받는다.
				var files = inputFile[0].files;
				
				console.log(files);
				
				for(var i = 0 ; i<files.length;i++){
					
					//파일확장자, 파일사이즈 체크
					if(!checkExtension(files[i].name, files[i].size)){
						return false;
					}
					formData.append("uploadFile",files[i]);
				}
				
				$.ajax({
					url: '/uploadAjaxAction',
					//ajax전송시 아래 2개 false 필수
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType:'json',
					success: function(result){
						console.log(result);
						
						showUploadedFile(result);
						
						$(".uploadDiv").html(cloneObj.html());						
					}
				});//$.ajax
			});
			
			var uploadResult = $(".uploadResult ul");
			
			function showUploadedFile(uploadResultArr) {
				var str="";
				
				$(uploadResultArr).each(function(i,obj){
										
					if(!obj.image){
						var fileCallPath = encodeURIComponent( obj.uploadPath+"/"+obj.uuid + "_"+obj.fileName);
						console.log(fileCallPath);
						
						var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
						
						str += "<li>";
							str += "<div>";
								str += "<a href='/download?fileName="+fileCallPath+"'>";
									str += "<img src='/resources/img/attach.png'>"+obj.fileName;
								str += "</a>";
								str += "<span data-file='"+fileCallPath+"' data-type='file'> x </span>";
							str	+= "</div>";
						str	+= "</li>";
					
					}else{						
						
						var fileCallPath = encodeURIComponent( obj.uploadPath+"/s_"+obj.uuid + "_"+obj.fileName);
						
						var originPath = obj.uploadPath + "\\"+obj.uuid+"_" + obj.fileName;
						
						originPath = originPath.replace(new RegExp(/\\/g),"/");
						
						console.log(fileCallPath);
						
						str+="<li>";
							str+="<a href=\"javascript:showImage('"+originPath+"')\">";
								str+="<img src='/display?fileName="+fileCallPath+"'>";
							str+="</a>";
							str+="<span style='cursor:pointer' data-file='"+fileCallPath+"' data-type='image'> x </span>"
						str+="</li>";
					}
				});
				
				uploadResult.append(str);
			}
			
			$(".bigPictureWrapper").on("click",function(e){
				$(".bigPciture").animate({width:'0%',height: '0%'}, 1000);
				setTimeout(function(){
					$('.bigPictureWrapper').hide();					
				},1000);
			});
			
			
		});
		
	</script>
		
</body>
</html>
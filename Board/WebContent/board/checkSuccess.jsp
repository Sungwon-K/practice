<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(window.name == "update"){
		opener.location.href = "BoardServlet?command=board_update_form&num=${param.num}";		
	}else if(window.name == 'delete'){
		//삭제 처리 코드 추가
		var result = confirm("정말 삭제하시겠습니까?")
		if(result){
			alert('삭제되었습니다.');
			opener.location.href = "BoardServlet?command=board_delete&num=${param.num}";	
		}else{
			window.close();	
		}		
	}
	window.close();
</script>
</head>
<body>

</body>
</html>
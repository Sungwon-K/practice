function productCheck(){
	var nameWord = document.frm.name.value;
	var descWord = document.frm.description.value;
	
	var wrongword_arr = new Array("나쁜말","심한말","못된말");
	var i = wrongword_arr.length;

	if(document.frm.name.value.length == 0){
		alert("상품명을 써주세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.price.value.length == 0){
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	if (isNaN(document.frm.price.value)){
		alert("숫자를 입력하세요");
		frm.price.select();//값을 선택. 수정하기 편하다.
		return false;
	}
	
	while(i-- > 0){
		if(nameWord.indexOf(wrongword_arr[i]) >= 0){
			alert(wrongword_arr[i] + "은(는) 금칙어입니다.")
			return false;
		}
		if(descWord.indexOf(wrongword_arr[i]) >= 0){
			alert(wrongword_arr[i] + "은(는) 금칙어입니다.")
			return false;
		}
	}
	return true;
}

function deleteCheck(){
	var result;
	result = confirm("정말 삭제하시겠습니까?");
	
	if(result){
		return true;
	}else{
		return false;
	}
}
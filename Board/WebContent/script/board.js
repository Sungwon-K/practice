function boardCheck() {
	if (document.frm.name.value.length == 0) {
		alert("작성자를 입력하세요.");
		return false;
	}
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력하세요.");
		return false;
	}
	return true;
}

/* 새 창 열기 */
function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}

/* 비밀번호 체크 */
function passCheck() {
	
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
}

/* 댓글 입력확인 */
function replyCheck(){	

	if(document.frm.name.value.length==0){
		alert("이름을 입력하세요");
		document.frm.name.focus();
		return false;
	}
	if(document.frm.password.value.length==0){
		alert("비밀번호를 입력하세요");
		document.frm.password.focus();
		return false;
	}
	if(document.frm.content.value.length==0){
		alert("내용을 입력하세요");
		document.frm.content.focus();
		return false;
	}
}
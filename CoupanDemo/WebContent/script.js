function idck(){
	if(document.form.id.value == ""){
			$("#warnid").css("display","block");
			$("#id").css("border","0.5px solid red");			
			return;
	}
	$("#warnid").css("display","none");
	$("#id").css("border","0.5px solid #A9A9A9");
}

function pwck(){
	if(document.form.pass.value == ""){
		$("#warnpw").css("display","block");
		$("#pass").css("border","0.5px solid red");			
		return;
	}else if((document.form.pass.value.length>15) || (document.form.pass.value.length<6)){
		$("#warnpw").css("display","block");
		$("#pass").css("border","0.5px solid red");			
		return;
	}
	$("#warnpw").css("display","none");
	$("#pass").css("border","0.5px solid #A9A9A9");
}

function pwckck(){
	if((document.form.passck.value == "") || (document.form.passck.value != document.form.pass.value)){
		$("#wrongpw").css("display","none");
		$("#warnpwck").css("display","block");
		$("#passck").css("border","0.5px solid red");			
			return;
	}else if((document.form.pass.value.length>15) || (document.form.pass.value.length<6)){
		$("#wrongpw").css("display","block");
		$("#warnpwck").css("display","none");
		$("#passck").css("border","0.5px solid red");			
		return;
	}
	$("#wrongpw").css("display","none");
	$("#warnpwck").css("display","none");
	$("#passck").css("border","0.5px solid #A9A9A9");
}

function nameck(){
	if(document.form.name.value == ""){
			$("#warnname").css("display","block");
			$("#name").css("border","0.5px solid red");			
			return;
	}
	$("#warnname").css("display","none");
	$("#name").css("border","0.5px solid #A9A9A9");
}

function pnck(){
	var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;

	if(document.form.phonenum.value == ""){
			$("#wrongpn").css("display","none");
			$("#warnpn").css("display","block");
			$("#phonenum").css("border","0.5px solid red");			
			return;
	}else if(!regExp.test(document.form.phonenum.value)){
		$("#wrongpn").css("display","block");
		$("#warnpn").css("display","none");
		$("#phonenum").css("border","0.5px solid red");			
		return;
	}
	$("#wrongpn").css("display","none");
	$("#warnpn").css("display","none");
	$("#phonenum").css("border","0.5px solid #A9A9A9");
}


function check(){
	idck(); pwck(); pwckck(); nameck(); pnck();
	
	document.from.submit();
};
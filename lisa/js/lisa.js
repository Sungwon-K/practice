function pwck(){
    var pw = prompt("패스워드를 입력해주세요","0");

    if(pw==""){
        alert("패스워드를 입력하지 않았습니다.");
        return;
    }
    else if(pw=="1234"){
        location.href="https://discord.gg/FXSJBt"
    }
    else{
        alert("패스워드를 잘못 입력했습니다.")
        return;
    }
}
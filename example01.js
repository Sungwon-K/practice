//단순출력
//document.write("<h1>입력됬습니다.</h1>");
//documnet.write("환영합니다.");


//삼항연산자 이용 코드
/*
var name= prompt("당신의 이름은?","");
var height= prompt("당신의 신장은?","0");
var weight= prompt("당신의 몸무게는?","0");

var normal_w=(height - 100)*0.9;
var result = (weight >= normal_w-5 && weight <= normal_w+5);
result = result ? "적정체중입니다." : "적정 체중이 아닙니다.";
document.write(name+"님은"+result);
*/

//내장 객체 생성
/*
var tv= new Object();
tv.color="white";
tv.price="30";
tv.info = function(){
    document.write("tv색상: " + this.color,"<br>");
    document.write("tv가격: " + this.price,"<br>");
}

var car = {
    color:"black",
    price:"100",
    info: function(){
        document.write("car색상: "+this.color,"<br>");
        document.write("car가격: "+this.price,"<br>");
    }
};
document.write("<h1>tv 객체 메소드 호출</h1>")
tv.info();
document.write("<h1>car 객체 메소드 호출</h1>")
car.info();
*/

var ko = prompt("국어점수는?","0");
var en = prompt("영어점수는?","0");
var ma = prompt("수학점수는?","0");

var student = {
    name:"홍길동",
    국어:Number(ko),
    영어:Number(en),
    수학:Number(ma),
    score:function(){
        var avg = (this.국어+this.수학+this.영어)/3;
        
        if(avg>=80){
            score = "A";
        }
        else if(avg>=70){
            score = "B";
        }
        else if(avg>=60){
            score = "C";
        }
        else if(avg>=50){
            score = "D";
        }
        else{
            score = "F";
        }

        document.write(this.name+": "+score+"입니다.");
    }
}
student.score();
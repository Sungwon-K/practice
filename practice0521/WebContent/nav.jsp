<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 #nav {
            width: 100%;
            height: 30px;
            background-color: rgb(90, 90, 87);
            padding-left: 10px;
            list-style-type: none;           
        }

        #nav li{
           float: left;
        }
        #nav li a{
            padding-left: 10px;
            text-decoration: none;
            color:black;    
        }
        #con{
            position: relative;
        }

        #box1 , #box2 , #box3{
            width: 100px;
            height: 30px;
            color:black;
            background-color: rgb(155, 155, 155);
            border-radius: 5px;

            position:absolute;
            
            opacity: 0;
            transition: 1s;
            transition-timing-function: cubic-bezier(0,1.02,.91,1);        
        }

        #con:hover #box1{
            
            transform: translateY(10px); 
            opacity: 1;
          
        }
        #con:hover #box2{
            margin-left : 5px;
            transform: translateY(42px); 
            opacity: 1;
           
        }
        #con:hover #box3{
            margin-left : 10px;
            transform: translateY(74px); 
            opacity: 1;
        }
</style>
</head>
<body>
<ul id = "nav">
        <li><a href="#home">교육센터소개</a></li>
        <li><a href="#news">교육센터연혁</a></li>
        <li><a id = "con" href="#contact">교육과정
            <div id ="box1">자바</div>
            <div id ="box2">디자인</div>
            <div id ="box3">네트워크</div>
        </a></li>
</ul>
</body>
</html>
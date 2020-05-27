<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
            padding: 0;
            margin: 0;
        }

        header {
            width: 100%;
            height: 150px;
            padding: 50px;
            background-color: black;
            color: whitesmoke;

        }

        aside {
            width: 100px;
            height: 600px;
            padding: 10px;
            background: #cccccc;
            float: left;

        }

        article {
            width: 700px;
            height: 600px;
            padding: 10px;
            background: white;
        }

        footer {
            width: 100%;
            height: 70px;
            padding: 20px;
            background: rgb(230, 227, 227);
            clear: both;
        }
</style>
</head>
<body>
<header>
        <h1>TIS edu</h1>
</header>
<jsp:include page="nav.jsp"/>
<aside>
        About<br>
        History<br>
        Board<br>
    </aside>
    <article>
        TIS 교육센터는 정부지원 IT전문교육기관 입니다.
    </article>
    <footer>
        TIS Edu.
    </footer>
</body>
</html>
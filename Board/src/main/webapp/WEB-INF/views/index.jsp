<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        Hello world~
    </title>
</head>
<body>
<h1>
    로그인3
</h1>

<form action="/movie/login" method="post">
    ID: <input type="text" name="moviename">
    PW: <input type="password" name="password">
    <button type="submit"> 로그인 </button>
</form>
<a href="/movie/register">회원가입</a>
</body>
</html>

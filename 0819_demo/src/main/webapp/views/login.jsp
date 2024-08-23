<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<h3>로그인 폼</h3>
	<form action="/member/login" method="post">
		id: <input type="text" name="id"><br/>
		pw: <input type="password" name="pw"><br/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>
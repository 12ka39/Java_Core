<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h3>로그인 폼</h3>
<form action="/test/login" method="post">
	<table border="1">
		<tr><th>ID</th><td><input type="text" name="id" value="aaa"></td></tr>
		<tr><th>PWD</th><td><input type="password" name="pwd" value="111"></td></tr>
		<tr><th>LOGIN</th><td><input type="submit" value="로그인"></td></tr>
	</table>
</form>
</body>
</html>
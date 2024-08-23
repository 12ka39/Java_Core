<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 폼</title>
</head>
<body>
<form action="/book/add" method="post">
	<table border="1">
		<tr><td>작성자</td><td><input type="text" name="writer"></td></tr>
		<tr><td>글비밀번호</td><td><input type="text" name="pwd"></td></tr>
		<tr><td>내용</td><td><input type="text" name="content"></td></tr>
		<tr><td>작성</td><td><input type="submit" value="작성"></td></tr>
	</table>
</form>
</body>
</html>
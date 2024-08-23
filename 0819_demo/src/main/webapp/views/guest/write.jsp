<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성하기</title>
</head>
<body>

<form action="/guest/write" method="post">
	writer: <input type="text" name="writer"><br>
	pwd: <input type="password" name="pwd"><br>
	content: <input type="text" name="content"><br>
	<input type="submit" value="글 작성하기">
</form>

</body>
</html>
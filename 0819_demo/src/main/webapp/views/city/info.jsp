<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도시 번호를 입력하세요</title>
</head>
<body>
<h3>도시 검색</h3>
<form action="/city/detail" method="get">
	id: <input type="number" name="id"><br/>
	<!-- 이 id가 컨트롤러의  -->
	<input type="submit" value="검색">
</form>
</body>
</html>
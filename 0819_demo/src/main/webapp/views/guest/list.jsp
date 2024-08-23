<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/guest/write">글 작성하기</a>
<h3>list 입니다</h3>
<table border="1">
<tr><th>num</th><th>writer</th><th>pwd</th><th>wdate</th><th>content</th>

<c:forEach var="c" items="${list}">
<tr>
    <td>${c.num}</td>
    <td><a href="/guest/detail?num=${c.num }">${c.writer}</a></td>
    <td>${c.pwd}</td>
    <td>${c.wdate}</td>
    <td>${c.content}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
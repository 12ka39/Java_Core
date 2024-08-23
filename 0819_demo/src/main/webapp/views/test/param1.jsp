<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param1</title>
</head>
<body>

<c:forEach var="s" items="${list }">
	<h3>${s }</h3>	
</c:forEach>
</body>
</html>
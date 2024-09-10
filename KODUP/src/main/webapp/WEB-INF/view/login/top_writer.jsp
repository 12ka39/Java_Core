<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login/top_writer.jsp</title>
</head>
<body>
	<br/><br/>
	<span style="font-weight: 600;">#Top Writer</span>
	<hr/>
	<c:forEach items="${listTopWriter }" var="twVo">
		<a href="javascript:void(0);" onclick="runTopWriterProfile('${twVo.nickname }')" class="text-decoration-none" style="float: left;">
			<img id="index_top_writer_profile" src="upload/${twVo.profile_img }">
			<span id="index_top_writer_nickname">${twVo.nickname }</span>
		</a>
		<br/><br/>
	</c:forEach>
</body>
</html>
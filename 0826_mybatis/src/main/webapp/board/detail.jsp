<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const d = () => {
	location.href="/board/del?num=${b.num }";
}

</script>
</head>
<body>
<h3>상세 페이지- c:set var 변수 만들기</h3>
<c:if test="${sessionScope.loginID != b.writer }">
	<c:set var="str">readonly</c:set> <!-- let str = "readonly"; 이거랑 같다 --> 
</c:if>
<form action="/board/edit" method="post">
<table border="1">
	<tr>
		<th>num</th>
		<td><input type="text" name="num" value="${b.num }" readonly></td>
	</tr>
	<tr>
		<th>writer</th>
		<td><input type="text"  value="${b.writer }" readonly></td>
	</tr>
	<tr>
		<th>wdate</th>
		<td><input type="text" value="${b.wdate}" readonly></td>
	</tr>
	<tr>
		<th>title</th>
		<td><input type="text" name="title" value="${b.title }" ${str }></td>
	</tr>
	
	<tr>
		<th>content</th>
		<td><textarea rows="5" cols="40" name="content" ${str }>${b.content }</textarea></td>
	</tr>

<c:if test="${sessionScope.loginId == b.writer }">
	<tr><th>편집</th>
	<td><input type="submit" value="수정">
	<input type="submit" value="삭제" onclick="d()"></td></tr>
</c:if>
</table>
</form>
</body>
</html>
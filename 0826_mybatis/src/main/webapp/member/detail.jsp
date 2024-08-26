<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 확인</title>
</head>
<body>
<c:if test="${sessionScope.loginId != null }">
	<form action="/member/detail" method="post" name="f">
		<table border="1">
			<tr><th>ID</th>
			<td>
				<input type="text" name="${member.id }" readonly><!-- member.id -->
			</td></tr>
			<tr><th>PWD</th><td><input type="text" name="${member.pwd }"></td></tr>
			<tr><th>이름</th><td><input type="text" name="${member.name }"></td></tr>
			<tr><th>이메일</th><td><input type="text" name="${member.email }"></td></tr>
			<tr><th>회원타입</th>
				<td>
					<select name="type">
						<option>${member.type }</option>
						<option>판매자</option>
					</select>
				</td></tr>
			<tr><th>EDIT</th><td><input type="submit" value="회원수정"></td></tr>
		</table>
	</form>
</c:if>

</body>
</html>
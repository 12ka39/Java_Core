<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 태그 라이브러리 지시자 jsp에서 if문 .. 쓸 때 필요. 정의문의 위치를 알려줌-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도시 추가</title>
</head>
<body>
	<form action="/city/add" method="post">
		도시이름: <input type="text" name="name"><br>
		지역코드: 
		<select name="countryCode">
			<c:forEach var="code" items="${list }">
				<option>${code }</option>
			</c:forEach>
		</select><br/>
		
		<!-- 자바에서 for(String code :list ) 와 똑같은 코드 -->
		
		지역: <input type="text" name="district"><br>
		인구: <input type="number" name="population"><br>
		<!-- DB에 인구가 int라서 type="number" -->
		<input type="submit" value="입력">
	</form>
</body>
</html>
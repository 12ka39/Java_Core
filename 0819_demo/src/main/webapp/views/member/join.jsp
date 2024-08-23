<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 폼</h3>
	<form action="/mem/join" method="post">
	
	<!-- 서버에서 데이터 받아갈 때 name으로 받아가고,
	vo클래스의 멤버변수와 이름이 같아야 자동으로 값이 들어간다 -->
		id: <input type="text" name="id"><br/>
		pwd: <input type="password" name="pwd"><br/>
		name: <input type="text" name="name"><br/>
		email: <input type="text" name="email"><br/>
		<input type="submit" value="가입">
	</form>
</body>
</html>
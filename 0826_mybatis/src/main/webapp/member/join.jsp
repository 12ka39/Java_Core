<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript">
	const a = () =>{ // 팝업창 띄우는 함수
		let win = open("idcheck.jsp", "win", "width=300, height=300, top=10, left=10");
			//새 창을 띄워서 idcheck.jsp 페이지를 열고,       , 크기와, 위치지정
			//open(url, 새창이름 , windowFeatures);

	}
</script>

</head>
<body>
<h3>회원가입</h3>
<form action="/member/join" method="post" name="f">
	<table border="1">
		<tr><th>ID</th>
		<td>
			<input type="text" name="id">
			<input type="button" value="중복체크" onclick="a()">
		</td></tr>
		<tr><th>PWD</th><td><input type="password" name="pwd"></td></tr>
		<tr><th>이름</th><td><input type="text" name="name"></td></tr>
		<tr><th>이메일</th><td><input type="text" name="email"></td></tr>
		<tr><th>회원타입</th>
			<td>
				<select name="type">
					<option>구매자</option>
					<option>판매자</option>
				</select>
			</td></tr>
		<tr><th>JOIN</th><td><input type="submit" value="회원가입"></td></tr>
	</table>
</form>
</body>
</html>
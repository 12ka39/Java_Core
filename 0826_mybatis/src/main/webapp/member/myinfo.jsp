<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 확인</title>
<script type="text/javascript">
window.onload = () => { // 구매자인지 판매자인지 체크해서 보여주기 위한 js
	console.log(typeof(${m.type}));//undefined?
	if('${m.type}' == '구매자'){ // js에서 문자열은 다 '' 붙여주기
		// 만약 ${m.type} 가 숫자였다면 ${m.type} 그대로 써도 된다
		document.getElementById("op1").selected = true;
	}else{
		document.getElementById("op2").selected = true;
	}
}

</script>
</head>
<body>
<h3>내 정보</h3>
<form action="/member/edit" method="post">
	<table border="1">
		<tr><th>ID</th>
		<td>
			<input type="text" name="id" value="${m.id }" readonly>
		</td></tr>
		<tr><th>이름</th><td><input type="text" name="name" value="${m.name }"></td></tr>
		<tr><th>이메일</th><td><input type="text" name="email" value="${m.email }"></td></tr>
		<tr><th>회원타입</th>
			<td>
				<select name="type">
					<option id="op1">구매자</option>
					<option id="op2">판매자</option>
				</select>
			</td></tr>
		<tr><th>EDIT</th><td><input type="submit" value="수정"></td></tr>
	</table>
</form>
</body>
</html>
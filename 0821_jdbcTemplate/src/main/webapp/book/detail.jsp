<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	let pwd = prompt("글 비밀번호는?", "");
	if(pwd == '${gb.pwd}'){ // EL표현식은 " "를 붙여주자
		let cont = prompt("새 글 내용", ""); 
		location.href="/book/edit?num=${gb.num}&content="+cont; //get방식
		}else{		// 수정할 번호와 글내용을 갖고 get방식으로 /book/edit로 간다
		alert('글 비밀번호 불일치');
	}
}

const b = () => {
	let pwd = prompt("글 비밀번호는?", "");
	if(pwd == '${gb.pwd}'){ // EL표현식은 " "를 붙여주자
		location.href="/book/del?num=${gb.num}"; //get방식
		}else{
		alert('글 비밀번호 불일치');
	}
}
</script>
</head>
<body>
<h3>상세 페이지</h3>
<table border="1">
	<tr><td>글번호</td><td>${gb.num }</td></tr>
	<tr><td>작성자</td><td>${gb.writer}</td></tr>
	<tr><td>내용</td><td>${gb.wdate }</td></tr>
	<tr><td>작성</td><td>${gb.content }</td></tr>
	<tr><th>변경</th>
		<td>
			<input type="button" value="수정" onclick="a()">
			<input type="button" value="삭제" onclick="b()">
		</td>
	</tr>	
</table>
</body>
</html>
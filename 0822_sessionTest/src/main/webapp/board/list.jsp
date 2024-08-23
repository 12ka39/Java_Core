<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트 목록</title>
<script type="text/javascript">
const a = (num) => { // 이 함수는 제목 누르면 글내용 미리보기 뜨게 하는 기능  
			// 글 번호를 파라미터로 받음
	//비동기 요청 객체 생성
	let req = new XMLHttpRequest(); 
	
	//비동기 요청 응답이 오면 자동 호출될 핸들러(함수) 등록 
	//받은 응답은 비동기 객체(req)의 responseText 속성에 저장됨
	//{"num": 1, "writer": "aaa"}
	
	req.onload = () => { // 응답이 오면 자동으로 실행될 핸들러
		//alert(req.responseText);
		let res = document.getElementById("res");
		let obj = JSON.parse(req.responseText); // 객체 변환
		let txt = "글 상세내용<br/>";
		txt += "num :" + obj.num + "<br/>";
		txt += "writer :" + obj.writer + "<br/>";
		txt += "wdate :" + obj.wdate + "<br/>";
		txt += "title :" + obj.title + "<br/>";
		txt += "content :" + obj.content + "<br/>";
		res.innerHTML = txt; // res영역에 출력
	}
	
	//전송할 파라미터 정의
// 	let number = document.getElementById("num").value;
// 	let params = 'num='+num; // 파라미터 만들어 주기
	
	//open() 함수로 요청 설정 
	req.open('get', '/board/getAjax?num='+num); //get 요청으로 파라미터 넘김
	
	//요청 전송
	req.send();
}



const b = () => {

	let res = document.getElementById("res");
	res.innerHTML = ''; // 공백으로 바꾸기
}



</script>
</head>
<body>
<span id="res" style="position:absolute; top:200px; left:300px"></span>
<h3>게시판</h3>
<a href="/board/readlist">오늘 읽은 글목록</a><br>
<a href="/board/add">글작성</a><br/>
<select name="gettype">
	<option>작성자</option>
	<option>제목</option>
</select>
<input type="text" name="search">
<input type="button" value="검색">
<table border="1">
	<tr><th>num</th><th>title</th><th>writer</th></tr>
	<c:forEach var="b" items="${list }">
		<tr>
			<td><a href="/board/detail?num=${b.num }">${b.num }</a></td>
			<td><span onmouseover="a(${b.num })" onmouseout="b()">${b.title }</span></td>
					            <!-- ${b.num} 값이 숫자이므로 따옴표 없이 전달합니다 -->
			<td>${b.writer }</td>
			
		</tr>
	</c:forEach>
</table>

</body>
</html>
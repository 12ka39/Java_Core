<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	//get방식 요청 (String) -- id 중복체크
	const a = () => {
		//실행순서가 1-3-4-2. 2번이 맨 마지막에 실행된다
		
		//1.비동기 요청 객체 생성 (비동기 -> 현재페이지 새로고침 안되고 바뀜 -> 데이터 남아있음)
		let req = new XMLHttpRequest(); 
		
		//2. 서버로부터 결과값(비동기 요청 응답)이 오면 자동 호출될 핸들러 함수를 정의
		//받은 응답은 비동기 객체(req)의 responseText 속성에 저장됨
		//res: {"flag" : true }
		req.onload = () => {   
			//서버로부터 받은 결과 처리
			let res = document.getElementById("res");
			let msg = '중복된 아이디';
			
		/*
			비동기 요청 응답의 종류
		  - 일반 텍스트 : req.responseText에 저장됨
			텍스트 자체를 화면 출력
		  - json : req.responseText에 저장됨
			JSON.parse(req.responseText) => 객체로 파싱
			받은 데이터를 객체나 배열로 변환하여 뷰 페이지에서 사용
		*/
			let obj = JSON.parse(req.responseText); //json을 객체로 바꿔준다
			//db로 검색한 뒤 Member 객체에 담긴 회원 정보
			if(obj.flag){ // flag 값이 true면
				msg = '사용가능한 아이디';
			}
			res.innerHTML = msg;
		}

		
		//3. 요청 정보 셋팅
		//전송할 파라미터 정의
		let params = 'id='+document.getElementById("id").value; // 파라미터 만들어 주기
		
		//open() 함수로 요청 설정 
		req.open('get', '/member/idcheckAjax?'+params); //get 요청으로 파라미터 넘김
			//@GetMapping("/idcheckAjax") 여기서 -> 실행하는 메소드 (params)
		
		//4. 요청 전송
		req.send();
	}
</script>
</head>
<body>
<h3>회원가입</h3>
<form action="/member/join" method="post" name="f">
	<table border="1">
		<tr><th>ID</th>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="중복체크" onclick="a()">
			<div id="res"></div><!-- 사용 가능/불가능 출력하는 div -->
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">

	//get방식 요청 (String)
	const a = () => {
		//비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		//비동기 요청 응답이 오면 자동 호출될 핸들러(함수) 등록 
		//받은 응답은 비동기 객체(req)의 responseText 속성에 저장됨
		req.onload = () => { // 응답이 오면 자동으로 실행될 핸들러
			let res = document.getElementById("res");
			res.innerHTML = req.responseText;	
		}
		
		//전송할 파라미터 정의
		let num = document.getElementById("num").value;
		let name = document.getElementById("name").value;
		let params = 'num='+num+'&name='+name; // 파라미터 만들어 주기
		
		//open() 함수로 요청 설정 
		req.open('get', '/ajax/test1?'+params); //get 요청으로 파라미터 넘김
		
		//요청 전송
		req.send();
	}
	
	
	//post방식 요청 (String)
	const b = () => {
		//비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		req.onload = () => { 
			let res = document.getElementById("res");
			res.innerHTML = req.responseText;
		}
		
		//전송할 파라미터 정의
		let num = document.getElementById("num").value;
		let name = document.getElementById("name").value;
		let params = 'num='+num+'&name='+name; // 파라미터 만들어 주기
		
		//open() 함수로 요청 설정 --- post방식은 여기가 다르다
		req.open('post', '/ajax/test2'); 		
		req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		//이 코드가 필요한 이유.  일반 form 전송은     application 으로,
		// 파일전송은 multipart로 설정
		
		req.send(params); //요청 전송
	}	
	
	
	//get방식 요청 - json
	const c = () => {
		//비동기 요청 객체 생성
		let req = new XMLHttpRequest(); 
		
		req.onload = () => { 
			let res = document.getElementById("res");
			//json처리
			let obj = JSON.parse(req.responseText); // JSON.parse(). json을 파싱
				// {  } => 객치로,  []는 배열로 바꿔준다.
			
			let num = obj.num;
			let name = obj.name;
			res.innerHTML = "num:"+num+"<br/>name:"+name;
		}
		
		let num = document.getElementById("num").value;
		let name = document.getElementById("name").value;
		let params = 'num='+num+'&name='+name; 
		
		req.open('get', '/ajax/test3?'+params); 
		
		//요청 전송
		req.send();
	}	
	
	
	
	
</script>
</head>
<body>
<h3>ajax get 요청으로 String 받음</h3>
<h3>ajax 테스트</h3>
<div id="res"></div>
<input type="number" id="num"><br/>
<input type="text" id="name"><br/>
<input type="button" value="get/string" onclick="a()">
<input type="button" value="post/string" onclick="b()"><br/>
<input type="button" value="get/json" onclick="c()">
<br/>

</body>
</html>
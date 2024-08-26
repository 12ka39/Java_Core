<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload = () =>{ // 이 페이지가 시작되자마자. 이거 팝업창입니다.
	
	if('${msg}' == ''){ 
		f.id.value = opener.document.f.id.value;	// join.jsp에서 id 체크 팝업창 띄웠음
				//opener 이 파일을 연 사람은 join.jsp 창의 f.id.value 값
	}else{
		if(${flag}){
			let div = document.getElementById("div"); // id가 div인 요소를 가져와서
			let html = "<input type='button' value='아이디 사용' onclick='b()'>";
			div.innerHTML = html; // div에 버튼 추가
		}
	}
}

const b = () => {
	opener.document.f.id.value = '${resultid}'; // 이전 아이디 창에 
	close(); // 현재 팝업 창을 닫음
}
</script>
</head>
<body>
<h3>중복체크</h3>
${msg }
<form action="/member/idcheck" method="post" name="f">
id: <input type="text" name="id" value="${resultid }">
<input type="submit" value="id 중복체크">
</form>
<div id="div"></div>
</body>
</html>
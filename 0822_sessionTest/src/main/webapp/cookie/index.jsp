<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 테스트</h3>
<!-- 
http://localhost:8081/cookie/list 로 접속해서 확인
쿠키 이름인 num 인 객체의 name과 value 출력 -->
${cookie.num.name } / ${cookie.num.value } <br/>
${cookie.name.name } / ${cookie.name.value } <br/>
${cookie.JSESSIONID.name } / ${cookie.JSESSIONID.value } <br/>
<a href="/cookie/add?num=1&name=aaa">쿠키추가</a><br/>
<a href="/cookie/list">쿠키목록</a><br/>
</body>
</html>
<!-- 
JSESSIONID란?
- 톰캣 컨테이너에서 세션을 유지하기 위해 발급하는 키
- HTTP 프로토콜은 stateless하다. 요청시마다 새로운 연결이 생성되고 응답후 연결은 끊기게 되므로 상태를 유지할 수 없다.
- 따라서, 상태를 저장하기 위해서 톰캣은 JSESSIONID 쿠키를 클라이언트에게 발급해주고 이 값을 통해 세션을 유지할 수 있도록 한다.
 
동작방식에 대해서
1. 브라우저에 최초 접근시 톰캣은 Response 헤더에 다음과 같이 JSESSIONID값이 발급된다.
 
Set-Cookie: JSESSIONID=3CB361E0BE1A9A7DE7DB926DF0772BAE
 
2. 브라우저 재요청시 Response를 통해 받은 JSESSIONID를 Request 헤더의 쿠키에 값을 넣어 서버에 요청한다. 쿠키를 통해 JSESSIONID값을 전달받게 되면 서버는 새로운 JSESSIONID 값을 Response 헤더에 발급하지 않는다.
 
3. 클라이언트로부터 전달받은 JSESSIONID값을 기준으로 서버에서는 세션 메모리 영역에 상태를 유지할 값들을 저장할 수 있게 된다. (HttpSession 등)
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello Spring<br>
	${sessionScope.loginId }님 반갑습니다</h3>
	<!-- 
	http://localhost:8081/test/sessiontest 여기 갔다가
	http://localhost:8081 다시 접속하면 ~님 아이디가 뜰 거다
	 -->
	<a href="/mem/join">회원가입</a><br>
	<!-- 링크로 이동하는 건 get방식 -->
	<a href="/member/login">로그인</a><br/>
	${m1.id } / ${m1.pwd } / ${m1.name } / ${m1.email }<br/>
	<!-- 컨트롤러에서 커맨드 객체로 사용한 Member m 이 view단으로 넘어오는데,
	소문자 클래스가 객체 이름으로 나타낸다 
	JSP에서는 EL표현식으로 자바 값을 출력할 수 있다 
	 
	EL 표현식
	jsp에서 자바값 출력
	  
	값 있으면 출력, 없으면 출력 안 함
	
	처음에 index 접속했을 땐 EL표현식에 값이 없는 상태라 빈 공간만 뜨고 오류 안남. (편하다)
	
	EL표현식은 자기가 알아서 getter를 호출해준다.
	private 멤버도 객체.멤버 member.id 로 작성. (자동으로 getter 호출하니까)
	그래서 private 멤버인데도 member.getId 이렇게 안 적어줘도 값을 불러올 수 있다. 
	 -->
	<a href="/city/info">도시검색</a><br>
	<a href="/city/add">도시추가</a><br>
<!-- 	=> 도시 추가 폼(city/add.jsp) -> 폼에 도시 정보 입력 submit -> /city/add :post 요청
	도시 추가되면 index로 돌아오도록 -->
	<a href="/city/list">도시목록</a>
	
	<hr><br>
	<a href="/guest/list">방명록 입니다~</a>
</body>
</html>
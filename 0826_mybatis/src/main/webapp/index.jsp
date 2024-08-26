<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕~</title>
</head>
<body>
<c:if test="${sessionScope.loginId == null }">
	${msg }<br/>
	<a href="/member/join">회원가입</a><br/>
	<a href="/member/login">멤버 로그인</a><br/>
	<hr>
	<a href="/test/login">테스트 로그인</a>
</c:if>

<c:if test="${sessionScope.loginId != null }">
	${sessionScope.loginId } 님은 ${sessionScope.type } 입니다.<br/>
	<a href="/member/logout">로그아웃</a><br/>
	<hr>
	<a href="/member/detail?id=${loginId }">(me) 내정보확인...</a><br/><br/> <!-- 이거 과제 -->	
	
	<a href="/member/myinfo">(teacher) 내정보확인</a><br/> <!-- 이거 과제 -->	
	<a href="/member/out">탈퇴</a><br/>
	<a href="/board/list">게시판</a><br/>
	<hr>
	<a href="/test/logout">테스트 로그아웃</a>
</c:if>

${msg }<br/><!-- 로그인 성공필패 메시지 -->
</body>
</html>
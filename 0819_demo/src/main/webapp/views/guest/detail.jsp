<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
const a = () => {
	location.href="";
}
</script>
</head>
<body>
<h3>상세페이지</h3>
<!--  EL 표기법 -->
 ${msg }<br/> <!-- 검색 결과가 없으면 msg만 뜨고 밑에 건 다 안 나온다 -->
 
 <form action="/guest/edit" method="post">
	 <input type="text" name="num" value="${guest.num }" readonly> <br/>
	 name: ${guest.writer } <br/>
	 countryCode: ${guest.pwd } <br/>
	 district: ${guest.wdate }<br/>
	 <input type="text" name="content" value="${guest.content }"><br/>
	 <input type="submit" value="수정">
	 <input type="button" value="삭제" onclick="a()">
 </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<script type="text/javascript">
const a = () => {
	location.href="/city/del?id=${city.id}";
}
</script>
</head>
<body>
<h3>상세페이지</h3>
<!--  EL 표기법 -->
 ${msg }<br/> <!-- 검색 결과가 없으면 msg만 뜨고 밑에 건 다 안 나온다 -->
 
 <form action="/city/edit" method="post">
	 <input type="text" name="id" value="${city.id }" readonly> <br/>
	 name: ${city.name } <br/>
	 countryCode: ${city.countryCode } <br/>
	 district: ${city.district }<br/>
	 <input type="text" name="population" value="${city.population }"><br/>
	 <input type="submit" value="수정">
	 <input type="button" value="삭제" onclick="a()">
 </form>
</body> 
</html>
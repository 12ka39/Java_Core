package com.example.demo.ajaxtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//쿠키
//클라이언트 컴퓨터 정보 저장
//데이터 유형 !!!!!텍스트!!!!!!
//텍스트 파일 형태로 보관



//http://localhost:8081/cookie/index.jsp 접속해서 확인
// 쿠키 추가 클릭 후 -> (변화 없음) -> 쿠키 확인 누르고 콘솔창 확인하자
// 결과:
//name:numvalue: 1
//name:namevalue: aaa
//name:JSESSIONIDvalue: 0D1A211C3274D8E24F470EADC1BB403E

@Controller
@RequestMapping("/cookie")
public class CookieTestController {
	
	//쿠키 추가 : 쿠키 추가할 뿐이라
	/*
	 웹 어플리케이션에 첫 요청을 하면 세션 id발급(쿠키에 담아서)
	클라이언트는 매 요청시 request 헤더에 발급받은 session id를 담아서 보냄
	 */
	@GetMapping("/add") 
	public String add(int num, String name, HttpServletResponse res,
			HttpServletRequest req) {
		Cookie c1 = new Cookie("num", num+""); // 쿠키 객체 생성
								// num이란 이름으로   int num을 넣어줌. 근데, 쿠키는 ~~텍스트로 저장~~되니까
								// 문자열로 저장했다 (num+"")
		Cookie c2 = new Cookie("name", name);
		
		//클라이언트에게 보내줄 거라 response 객체가 필요하다
		res.addCookie(c1);
		res.addCookie(c2);
		
		return "cookie/index";
	}
	
	// 쿠키 목록 확인
	@GetMapping("/list")
	public String list(HttpServletRequest req) {
		Cookie[] list = req.getCookies();
		// request.getCookies(); => request에 담긴 전체 쿠키 읽음. 반환값은 배열(Cookie[])
		
		for(Cookie c : list ) {
			System.out.println("name:" + c.getName() + "value: " + c.getValue());
		}
		return "cookie/index";
	}
}

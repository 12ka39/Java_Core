package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class TestController {

	// 로그인 폼
	@GetMapping("/test/login")
	public void loginForm() {}
	
	
	// 로그인
	@PostMapping("/test/login")
	public String login(String id, String pwd, HttpSession session) {
		//세션 정보 확인 (세션은 웹 접속하면 자동으로 부여된다)
		System.out.println("session id: " + session.getId());
		System.out.println("CreateTime: " + session.getCreationTime()); // 세션이 생성된  시간
		System.out.println("session 마지막 접근: " + session.getLastAccessedTime() ); // 이 세션의 마지막 접근 시간
		System.out.println("session 최대 시간 :" + session.getMaxInactiveInterval() ); 
		
		
		//로그인 처리 : aaa / 111  
		String msg = "로그인 실패";
		if(id.equals("aaa") && pwd.equals("111")) {
			session.setAttribute("loginId", "aaa");
			session.setAttribute("type", "구매자"); // 로그인 유지 될 때, 회원의 정보도 세션에 저장할 수 있다
			msg = "로그인 성공";
		}
		
		session.setAttribute("msg", msg);
		return "index";
	}
	
	//로그아웃
	@GetMapping("/test/logout")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "index";
	}
}

package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

//타임리프 연결 테스트

@Controller
@RequestMapping("/test")
public class TestController {
	
	//http://localhost:8081/test/test1 로 접속하면 자동으로 로그인 정보가 실리도록 설정했다.
	@GetMapping("/test1")
	public String test1(Model m) {
		m.addAttribute("name", "hello");
		m.addAttribute("tel", "1234");
		return "index"; // template/index.html
	}
	
	
	// http://localhost:8081/test/test1 로 실행후
	// 두 번째 hello 링크 클릭 -> 콘솔창(name: hello)과, 인터넷 주소 ?name=hello 확인
	@GetMapping("/test2")
	public String test2(String name) {
		System.out.println("name: " + name);
		return "index";
	}
	
	//http://localhost:8081/ 로 접속해서 - 로그인, 로그아웃 처리하면 된다
	//로그인 처리
	@GetMapping("/test3")
	public String test3(HttpSession session) {
		session.setAttribute("loginId", "hello"); //세션에 로그인 아이디 저장
		return "index";
	}
	
	
	// 로그아웃
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
	//http://localhost:8081/test/test5 로 접속
	@GetMapping("/test5")
	public String test5(Model m) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		
		m.addAttribute("list", list);
		return "index"; // template/index.html
		
	}
	
	
}

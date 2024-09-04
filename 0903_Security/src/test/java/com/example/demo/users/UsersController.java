package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

	@Autowired
	private UsersService service;
	
	
	@GetMapping("")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("join")
	public String joinForm() {
		return "member/join";
	}
	
	
	@PostMapping("join")
	public String join(UsersDto dto) {
		service.save(dto);
		return "redirect:/";
	}
	
	
	@GetMapping("/loginform")
	public String loginForm() {
		return "member/login";
	}
	
	
	@RequestMapping("/autherror") //인증 오류가 나면 이동할 페이지
	public String error() {
		return "error";
	}
	
	
	@RequestMapping("/auth/test") //인증 요구 테스트
	public String test() {
		System.out.println("인증 테스트");
		return "index_auth";
	}
}

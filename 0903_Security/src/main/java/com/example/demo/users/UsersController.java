package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {
	@Autowired
	private UsersService service;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	// (로그인 후 -- 인증 마치고) 구매자 페이지
	@RequestMapping("/index_con")
	public String index_con() {
		System.out.println("인증 테스트_con");
		return "index_con";
	}
	
	
	// (로그인 후) 판매자 페이지
	@RequestMapping("/index_sel")
	public String index_sel() {
		System.out.println("인증 테스트_sel");
		return "index_sel";
	}
	
	
	
	@GetMapping("/join")
	public String joinForm() {
		return "member/join";
	}
	
	
	@PostMapping("/join")
	public String join(UsersDto dto) {
		service.save(dto);
		return "redirect:/";
	}
	
	
	@GetMapping("/loginform")
	public String loginForm() {
		return "member/login";
	}
	
	
	@RequestMapping("/autherror")
	public String error() {
		return "error";
	}
	
	
	@RequestMapping("/auth/test")
	public String test(){
		System.out.println("인증 테스트");
		return "index_auth";
	}
	
	
	//로그아웃
	@GetMapping("/auth/logout")
	public String logout() {
		//인증 객체 null 로 처리
		//로그인 인증 결과가 authentication 객체에 들어있는데 그걸 null로 처리.
		//authentication 객체는 우리가 만든 게 아니라 스프링에서 만든 거 가져오는 거라 코드가 복잡함
		
		//SecurityContextHolder 
		SecurityContextHolder.getContext().setAuthentication(null); // 인증 날림 - 로그 아웃
		return "redirect:/";
		
		
	}
	
}

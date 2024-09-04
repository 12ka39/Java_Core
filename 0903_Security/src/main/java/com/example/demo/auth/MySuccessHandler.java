package com.example.demo.auth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//인증 성공시 실행
public class MySuccessHandler implements AuthenticationSuccessHandler {
	
	
	@Override   	//로그인 인증 결과가 authentication 에 들어있다.
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//로그인 인증 결과가 authentication 에 들어있다.
		String loginId = authentication.getName();//로그인 아이디
		System.out.println("로그인 성공 / loginId:"+loginId);
		String path = "";
		if(authentication.getAuthorities().
				contains(new SimpleGrantedAuthority("구매자"))){
			System.out.println("구매자");
			path = "/index_con"; // 구매자 이동 페이지
		}else if(authentication.getAuthorities().
				contains(new SimpleGrantedAuthority("판매자"))){
			System.out.println("판매자");
			path = "/index_sel"; // 판매자 이동 페이지
		}else {
			System.out.println("권한모름");
			path = "/"; //루트로 이동
		}
		//path 경로로 forward로 이동
		request.getRequestDispatcher(path).forward(request, response);
	}

}

package com.example.demo.users;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//인증 성공 시 실행
public class MySuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

			String loginId = authentication.getName(); // 로그인(인증 통과한) 아이디
			System.out.println("로그인 성공 / loginId: "+ loginId);

			String path = "";
			if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("구매자"))) { //getAuthorities() 리스트. 구매자가 있는지 여부 확인 contains()
				path = "/index_con"; //구매자면 구매자 페이지로
			} else if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("판매자"))) {
				path = "/index_sel";
			} else {
			System.out.println("구매자도 판매자도 아님");
			path = "/";
			}
			
			// 지정된 path 경로로 forward로 이동
			request.getRequestDispatcher(path).forward(request, response); 
		}

}

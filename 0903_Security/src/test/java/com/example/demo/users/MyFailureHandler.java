package com.example.demo.users;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	//이거 onAuthenticationFailure메소드 오버라이드 한 거 (마우스 우클릭)
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.onAuthenticationFailure(request, response, exception);
		this.setDefaultFailureUrl("/autherror");
		request.setAttribute("msg", "인증 실패"); 
		
		
	}

	
	
}

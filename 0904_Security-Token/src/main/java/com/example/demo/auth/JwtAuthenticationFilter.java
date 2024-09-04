package com.example.demo.auth;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 필터 클래스 추가
// ~~요청이 올 때마다~~ 요청 헤더에서 토큰을 꺼내 유효성 체크

public class JwtAuthenticationFilter extends GenericFilterBean {

	private final TokenProvider provider;
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse res = (HttpServletResponse) response; // 다운캐스팅
		res.setHeader("Access-Control-Allow-Origin", "*"); // 접근 허용 범위 설정. 모든  것
		res.setHeader("Access-Control-Allow-Credentials", "true"); 
		res.setHeader("Access-Control-Allow-Methods", "*"); 
		res.setHeader("Access-Control-Allow-Max-Age", "3600"); 
		res.setHeader("Access-Control-Allow-Headers", 
				"Origin, X-Requested-With, Content-Type, Accept, Authorization"); 
		
		// 헤더에 이런 정보값이 들어간 것만 필터를 통과하게 하겠다
		res.setStatus(HttpServletResponse.SC_OK);
		
		
		//토큰 꺼내자
		String token = provider.resolveToken((HttpServletRequest) request);
		
		//헤더에 토큰이 있고 토큰 파기(만료) 시간이 남아있으면 정상
		if(token != null && provider.validateToken(token)) {
			
			//인증
			Authentication a = provider.getAuthentication(token); // 인증결과로 받아온 Authentication객체 a를 
			SecurityContextHolder.getContext().setAuthentication(a); // SecurityContextHolder 에 담는다
		}
		
		//이어서 진행할 다음 필터 실행
		chain.doFilter(request, response);
	}

}

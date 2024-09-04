package com.example.demo.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;

//보안과 관련된 설정 파일(클래스)
@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {
	private final TokenProvider provider; // 사용할 토큰 프로바이더
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			AuthenticationConfiguration authenticationConfiguration) 
					throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//보안 관련 설정 메서드 추가
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception {
		http.httpBasic(HttpBasicConfigurer::disable)//기본 설정 disable
			.csrf(CsrfConfigurer::disable) // 쓰기 작업 막은것을 해제, post, put...요청 가능
			.cors(Customizer.withDefaults()) //네트워크 도메인, ip 허용 코드 작성한 내용 적용
			.authorizeHttpRequests((authz)->authz
					//forward 요청 모두 허용
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/","/join", "/error", "/login").permitAll() // 이 경로는 자유로운 접근 허용
					.requestMatchers("/auth/**", "/index_**").authenticated() // auth, index_ 로 시작하는 모든 url 에 인증을 요구한다.

					//요청 처리 전에 실행될 필터	
					.addFilterBefore(new JwtAuthenticationFiler(provider), 
							(Class <? extends Filter>)
							UsernamePasswordAuthenticationToken.class);
			
			//세선 사용 안함 설정
			http.sessionManagement(configurer -> 
			configurer.sessionCreationPolicy(
					SessionCreationPolicy.STATELESS));
			
			
			
			return http.build();
	}
}

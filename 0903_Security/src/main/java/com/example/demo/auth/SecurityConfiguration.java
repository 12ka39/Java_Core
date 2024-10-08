package com.example.demo.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

//보안과 관련된 설정 파일(클래스)
@Configuration
public class SecurityConfiguration {
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
					.requestMatchers("/","/join", "/autherror","/loginform", "/login").permitAll() // 이 경로는 자유로운 접근 허용
					.requestMatchers("/auth/**", "/index_**").authenticated()) // auth, index_ 로 시작하는 모든 url 에 인증을 요구한다.
			//로그인 폼 설정
			.formLogin((login)->login
					.loginPage("/loginform")//로그인 폼을 주는 요청 url  을 /loginform로 하겠다
					.loginProcessingUrl("/login") //로그인 처리 요청 url (로그인 처리되는 url)
					.usernameParameter("id")//id 입력양식의 이름 (username의 파라미터 이름을 id로 하겠다)
					.passwordParameter("pwd")//패스워드 입력양식의 이름
					.defaultSuccessUrl("/", true).permitAll()//성공시 기본 이동 경로
					.successHandler(new MySuccessHandler())//성공시 실행될 핸들러 MySuccessHandler() 사용자가 만든 클래스
					.failureHandler(new MyFailureHandler())//실패시 실행될 핸들러
			);
			return http.build();
	}
}

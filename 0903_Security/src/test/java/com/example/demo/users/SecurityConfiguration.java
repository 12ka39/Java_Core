package com.example.demo.users;

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

@Configuration // 설정파일 클래스
public class SecurityConfiguration {

	@Bean   // autowired처럼 필요로하는 객체를 자동 생성
	//@bean 어노테이션은 게터 세터 형태로 메소드를 적는다
	
	//autowired는 우리가 직접만든 클래스,
	//bean은 api 객체 주입할 때 주로 쓴다
	
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	@Bean 
	public AuthenticationManager authenticationManager( // 인증과 관련된 관리 감독
			AuthenticationConfiguration authenticationConfiguration) 
				throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	//보안 관련 설정 메소드 (원하는 만큼) 추가
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) 
			throws Exception { // HttpSecurity 객체에 이런 저런 설정을 해준다
		http.httpBasic(HttpBasicConfigurer::disable) // 기본 설정 안 쓸 거라 disable
			.csrf(CsrfConfigurer::disable) // 쓰기 작업 막은것을 해제, post, put...요청 가능
			.cors(Customizer.withDefaults()) //네트워크 도메인, ip 허용 코드 작성한 내용 적용한
			.authorizeHttpRequests((authz)->authz
					// forward 요청(서버 내 이동) 모두 허용
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() 
					
					// 허용할 요청들. /는 당연히 모두 접속 허용해야 해야 사람 접근 가능 
					.requestMatchers("/", "/join", "/autherror", "/loginfomr", "/login").permitAll() // 모두 허용
					.requestMatchers("/auth").authenticated()) // /auth로 시작하는 주소는 인증을 한다

		//로그인 폼 설정
		.formLogin((login) -> login
					.loginPage("/loginform") // 로그인 폼을 주는 요청 url.  이걸 로그인 페이지로 할 거야, 라고 설정.  이거 안 쓰면, 기본적으로 제공되는 로그인 페이지가 제공됨
					.loginProcessingUrl("/login") // 로그인 처리 요청 url  (컨트롤러에 /login 안 만들었지만,  action에서 이 경로를 주면 알아서 스프링 시큐리티가 로그인 처리 해줌)
					.usernameParameter("id") // id 입력 양식의 이름 (이걸 username이라고 인식하라고 스프링 시큐리티에 알려줌) 
					.passwordParameter("pwd") // 패스워드 입력 양식의 이름
					.defaultSuccessUrl("/", true).permitAll() // 성공 시 기본 이동 경로
					.successHandler(new MySuccessHandler()) // 성공 시 실행될 핸들러 -- 클래스 만들어서 넣어줘야 함 
														//MySuccessHandler 사용자가 만든 클래스
					.failureHandler(new MyFailureHandler()) // 실패 시 실행될 핸들러 -- 클래스 만들어서 넣어줘야 함 
					
			);	
			return http.build();
	}
}

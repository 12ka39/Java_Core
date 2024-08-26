package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//stereotype : 클래스 종류. Controller: 클라이언트의 요청을 받아서 처리
@Controller // fullstack 컨트롤러 - 나는 컨트롤러 역할을 하는 클래스라고 설정해준다.
// stereotype 작성된 것을 자동으로 객체를 생성해준다.
// 자동생성조건 - 클래스 기본 패키지 내에 있어야 한다

// @Controller 이 어노테이션 덕분에 자동으로 객체가 생성된다.
// 그래서 따로 new 연산자로 객체 안 만들어도 된다

public class HomeController {
	
	/*

	1) dispatcherservlet: 클라이언트 요청을 받는 서블릿. 모든 요청이 여기로 옴
        요청 url 확인(handlerMapper 에게 물어봄) => 맵핑된 메서드를 호출 및 실행.
        이 메서드의 리턴값은 뷰 페이지 경로
       
	2) handlerMapper: controller에 등록된 url이 맞는지, 어떤 메서드와 맵핑되어 있나 알려줌
		url과 맞는 매핑을 찾아 dispatcherservlet에게 알려준다.
	
	3) viewResolver: 뷰 페이지 경로를 받아서 뷰 페이지 생성 및 실행
	(스프링에 내장된 API 클래스)
	
	
	모든 요청은 dispatcherservlet이 받음
	-> 받은 요청 url이 controller에 등록된 것인지 확인
	-> 없는 url이면 404 / 있으면 맵핑된 메서드 실행
	-> 맵핑된 메서드 실행 후 뷰 페이지 경로 반환
	-> dispatcherservlet이 viewResolver에게 뷰 페이지 경로를 전달하여 뷰 페이지를 생성하고 실행하도록 함

	 */
	
	//연습이라 db연결 아무것도 안 함.
	//페이지 이동만 확인해 보았다.
	
	@GetMapping("/") // get 요청만 받음  / 는 루트 경로
	public String home() { // 요청을 처리하는 메서드는 뷰 페이지 경로를 반환
		return "index"; // 뷰 페이지 경로 리턴
	}
	
	
	// 회원가입 폼
	@GetMapping("/member/join") //url이 같아도 전송방식(get/post)이 다르면 에러가 안 난다
	public String joinform() {
		return "joinForm";	
	}

	// 회원가입 완료
	@PostMapping("/member/join") // post 요청만 받음  
	//public String join(Member m) { // 요청을 처리하는 메서드는 뷰 페이지 경로를 반환
		// 스프링에서는 form으로 넘어온 id, pw를 자동으로 Member라는 VO로 저장해준다 
		//service.addMember(m);
	public String join() { // 요청을 처리하는 메서드는 뷰 페이지 경로를 반환
		return "join"; // 회원 가입 완료 메시지 출력
	}
	
	
	@GetMapping("/member/login") 
	public String login() { // 요청을 처리하는 메서드는 뷰 페이지 경로를 반환
		return "login"; // 로그인 폼
	}
	
	@PostMapping("member/login")
	public String login2() {
		return "loginres";
	}
}

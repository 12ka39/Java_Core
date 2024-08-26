package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/mem") // 이 컨트롤러의 공통 url. 
	// 등록하는 모든 url 앞에 자동으로 mem이 붙음
public class MemController {
	@Autowired //자동 객체 생성
	private MemService service;
	
	@GetMapping("/join") //  -> /mem/join
	public String joinForm(){
		return "member/join"; // -> /views/member/join
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("m1") Member m) { 
		// @ModelAttribute("뷰페이지에서 부를 이름")  - view페이지 가서 부를 이름 설정
		
		// Member m 은 커맨드 객체. 
		// 스프링은 디폴트(기본) 생성자로 생성 후 
		// 로그인 폼에 입력한 값이 그대로 다 들어온다(setter로 넣어준다)
		// 폼 양식의 이름과 동일한 setter를 호출해서 form 값을 커맨드 객체에 담아 전달
		//스프링이 아니었으면 String id = request.getParameter("id") 이런 식으로 해야 한다
		System.out.println(m);
		service.addMember();
		return "index"; // 커맨드 객체는 자동으로 view 페이지에 전달됨 -  view페이지에서는 소문자 클래스가 객체 이름
							  // member, 근데 @modelAttribute로 설정해줘서 여기서는 m
	}
	
	
	//검색
	@GetMapping("/get") // http://localhost:8081/mem/get
	public String get() {
		service.getMember();
		return "member/info";
	}
	
	
	//전체검색  url: getall    view: getall.jsp
	@GetMapping("/getall") // http://localhost:8081/mem/getall
	public String getAll() {
		service.getAll();
		return "member/getall";
	}
	
	
	//수정 url: edit  view: edit.jsp
	@GetMapping("/edit")
	public String edit() {
		service.editMember();
		return "member/edit";
	}
	
	
	//삭제 url: del  view:del.jsp
	@GetMapping("/del")
	public String del() {
		service.delMember();
		return "member/del";
	}
	
}

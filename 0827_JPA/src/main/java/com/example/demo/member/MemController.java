package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemController {

	@Autowired
	private MemService service;
	

	//회원가입 폼
	@GetMapping("/join")
	public void joinForm() {} // => return "member/join";
	
	
	//회원가입
	@PostMapping("/join")
	public String join(MemberDto m) {
		service.saveMem(m);
		return "index";
	}

	
	//로그인 화면
	@GetMapping("/login")
	public void loginForm() { 	}
	
	
	//로그인
	@PostMapping("/login")
	public String login(MemberDto m, HttpSession session, Model model) {
		MemberDto m2 = service.getMem(m.getId());
		if(m2!=null && m2.getPwd().equals(m.getPwd())) { //id, pw가 일치하면
			session.setAttribute("loginId", m2.getId());
			session.setAttribute("type", m2.getType()); // 세션을 수정해야 회원 타입이 바뀐다
		}else {
			model.addAttribute("msg", "로그인 실패");
		}
		return "index";
	}
	
	
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션을 삭제하고
		return "index"; // 인덱스로 돌아간다
	}
	
	
	@GetMapping("/idcheckAjax")
	public  Map idcheckAjax(String id) {
		//Model, ModelAndView는 jsp파일에 데이터 보내는 거라서 
		//페이지 없는 비동기 방식에는 쓸 수 없다
		Map map = new HashMap();
		/*
		 Map<String, Integer> map = new HashMap<>();
		 제네릭을 사용하지 않고 Map map = new HashMap();처럼 선언하면, 
		 모든 타입의 객체를 키와 값으로 저장할 수 있지만, 
		 나중에 꺼낼 때 캐스팅이 필요할 수 있습니다. 
		 
		 제네릭을 사용하는 것이 권장됩니다. 
		 제네릭을 사용하면 컴파일 시점에 타입을 검증하여 런타임 오류를 줄일 수 있습니다.
		 */
		boolean flag = false;
		if(service.getMem(id) == null) { // 중복 id 없으면
			flag = true;
		}
		map.put("flag", flag);
		System.out.println(map); // {flag=false}  {flag=true} 이런 게 뜬다
		return map;
		/*  결과 {
	    "flag": true
		} 
		*/
	}
	
	
	
	// 회원 상세정보 페이지
	@GetMapping("/detail")
	public void myinfo(HttpSession session, Model m) {
		m.addAttribute("m", service.getMem((String)session.getAttribute("loginId")));
	}
	
	
	@PostMapping("/edit")  // dao에서 save()가 수정, 추가 둘 다 된다
	public String edit(MemberDto m, HttpSession session) { // 
		MemberDto m2 = service.saveMem(m);
		session.setAttribute("type", m2.getType()); 
		return "redirect:/"; 
	}
	
	
	
	//회원 탈퇴
	@GetMapping("/out")
	public String out(HttpSession session) { // 로그인한 사람 id 가져오려고
		String loginId = (String) session.getAttribute("loginId");
		service.delMem(loginId);
		return "redirect:/member/logout"; //기존에 사용했던 데이터 다 날아감
	}
	//forward: 서버 내 이동. url 안 바뀜. 
	//redirect: 새 요청 시킴. (= 새 리퀘스트 객체 = 기존에 사용했던 데이터 다 날아감)
	
	
	
	
}
	

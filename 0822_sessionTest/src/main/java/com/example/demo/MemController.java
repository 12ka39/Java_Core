package com.example.demo;

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
	public String joinForm() {
		return "member/joinAjax";
		//return "member/join"; 이었다가 바꾼 듯?
	}
	
	//회원가입
	@PostMapping("/join")
	public String join(Member m) {
		service.addMem(m);
		return "index";
	}
	
	
	//아이디 중복체크(팝업창 띄우는 거)
	@PostMapping("/idcheck")
	public String idcheck(String id, Model model) {
		Member m = service.getMem(id);
		String msg = "중복된 아이디";
		String resultid = "";
		boolean flag = false;
		if(m == null) {
			msg = "사용 가능한 아이디";
			resultid = id;
			flag = true;
		}
		model.addAttribute("resultid", resultid);
		model.addAttribute("msg", msg);
		model.addAttribute("flag", flag);
		return "/member/idcheck";
	}
	
	//ajax로 id 중복체크
	// http://localhost:8081/member/idcheckAjax
	@ResponseBody 
	//(메서드가 반환하는 객체를 JSON, XML 등으로 자동 변환하여 HTTP 응답의 본문으로 전달.)
	
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
	
	
	//로그인 화면
	@GetMapping("/login")
	public void loginForm() { 	}
	
	
	//로그인
	@PostMapping("/login")
	public String login(Member m, HttpSession session, Model model) {
		Member m2 = service.getMem(m.getId());
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
	
	
	
	// 회원 상세정보 페이지
	@GetMapping("/myinfo")
	public void myinfo(HttpSession session, Model m) {
		m.addAttribute("m", service.getMem((String)session.getAttribute("loginId")));
		//m이란 이름으로 세션 id를 이용해 찾은 회원정보를 model에 추가한다
		//member/myinfo.jsp
	}
	
	
	@PostMapping("/edit")
	public String edit(Member m, HttpSession session) {
		service.editMem(m);
		Member m2 = service.getMem(m.getId());
		session.setAttribute("type", m2.getType()); 
		// 세션에 구매/판매자 타입을 올려놨었는데, 정보 수정후 바뀔 수 있으니까 
		//다시 세션에 저장
		return "redirect:/index.jsp"; // 이렇게 해야 계속 수정화면에서 고칠 수 없게 됨
	}
	
	
	
	//회원 탈퇴
	@GetMapping("/out")
	public String out(HttpSession session) { // 로그인한 사람 id 가져오려고
		String loginId = (String) session.getAttribute("loginId");
		service.delMem(loginId);
		return "redirect:/member/logout"; //기존에 사용했던 데이터 다 날아감
	}
	//forward: 서버 내 이동. url 안 바뀜. 
	//redirect: 새 요청 시킴. (= 새 리퀘스트 객체)
	
	
	
	
	
	//내 정보 확인페이지로 가기 -------- me 추후 수정
	@GetMapping("/detail")
	public String detailForm(Member m, HttpSession session, Model model) {
		Member m2 = service.getMem(m.getId());
		System.out.println(m.getId());
		model.addAttribute("member", m2);
		System.out.println(model);
		
		return "member/detail";
	}
	
	
	
	//내 정보 수정 ------------- me 추후 수정
	@PostMapping("/detail")
	public String detail(Member m , Model model) {
		service.editMem(m);
		model.addAttribute("member", m);
		return "member/detail";
	}
	
	
}
	

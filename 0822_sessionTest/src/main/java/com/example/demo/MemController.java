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
	
	@GetMapping("/join")
	public String joinForm() {
		return "member/joinAjax";
	}
	
	
	@PostMapping("/join")
	public String join(Member m) {
		service.addMem(m);
		return "index";
	}
	
	
	
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
	@GetMapping("/idcheckAjax")
	public  Map idcheckAjax(String id) {
		Map map = new HashMap();
		boolean flag = false;
		if(service.getMem(id) == null) { // 중복 id 없으면
			flag = true;
		}
		map.put("flag", flag);
		return map;
		/*  결과 {
	    "flag": true
		} 
		*/
	}
	
	
	//로그인 화면
	@GetMapping("/login")
	public void loginForm() { 	}
	
	
	@PostMapping("/login")
	public String login(Member m, HttpSession session, Model model) {
		Member m2 = service.getMem(m.getId());
		if(m2!=null && m2.getPwd().equals(m.getPwd())) {
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
	

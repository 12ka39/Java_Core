package com.example.demo.cont;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
public class TestController {
	
	//ModelMap
	@GetMapping("/param1")
	public String modelTest(ModelMap m) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		m.addAttribute("list", list);
		return "test/param1";
	}
	
	
	//ModelAndView
	@GetMapping("/param2")
	public ModelAndView param2(int num, String name) {
		ModelAndView mav = new ModelAndView("test/param2");
		mav.addObject("num", num);
		mav.addObject("name", name);
		return mav; // 객체 반환
	}
	
	
	//void
	@GetMapping("/voidTest")
	public void voidTest(Model m) {
		m.addAttribute("data1", "val1");
		m.addAttribute("data2", "val2");
		
	}
	
	
	//session
	@GetMapping("/sessiontest")
	public void sessionTest(HttpSession session) { // 연결이 유지되는 것처럼 보이게 정보 기억
		session.setAttribute("loginId", "aaa"); // 세션에 값 저장
		//session.invalidate(); // 로그아웃처리 (세션 무효화)
		// 웹 페이지를 열면 자동으로 세션이 생김
		// 세션이 무효화하면 자동으로 새 세션이 발급된다
		// 마치 db에서 트랜젝션 무효화되면 다시 새 트랜젝션이 생성되는 것처럼
	}
	
	
}

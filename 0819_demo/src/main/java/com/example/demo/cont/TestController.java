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
	
	//Model, Map,  ModelMap - 뷰 페이지에 전달할 값들을 담는 객체들
	//ModelAndView: 뷰 페이지에 전달할 값(Model)과 뷰 페이지의 경로(View)를 저장하는 객체
	
	//1. ModelMap (값)
	@GetMapping("/param1") // http://localhost:8081/test/param1
	public String modelTest(ModelMap m) {
		ArrayList<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		m.addAttribute("list", list);
		return "test/param1";
	}
	
	
	//2. ModelAndView (값 + 주소)
		//http://localhost:8081/test/param2?num=5&name=bbb 로 접속
		//get방식으로 왔으니까 주소 뒤에 ?num=5&name=bbb 이렇게 적어주면 됨
	@GetMapping("/param2")
	public ModelAndView param2(int num, String name) {
		ModelAndView mav = new ModelAndView("test/param2");
		mav.addObject("num", num);
		mav.addObject("name", name);
		return mav; // 객체 반환
	}
	
	
	//3. void
	@GetMapping("/voidTest")
	public void voidTest(Model m) {
		m.addAttribute("data1", "val1");
		m.addAttribute("data2", "val2");
	} // 리턴 없으면 알아서 /test/voidTest.jsp로 간다
	
	
	//4. session
	@GetMapping("/sessiontest") 
	public void sessionTest(HttpSession session) { // 연결이 유지되는 것처럼 보이게 정보 기억
		session.setAttribute("loginId", "aaa"); // 세션에 값 저장
		//session.invalidate(); // 로그아웃처리 (세션 무효화)
		// 웹 페이지를 열면 자동으로 세션이 생김
		// 세션이 무효화하면 자동으로 새 세션이 발급된다
		// 마치 db에서 트랜젝션 무효화되면 다시 새 트랜젝션이 생성되는 것처럼
	} //리턴 없으면 알아서 /test/sessiontest.jsp로 간다
	
	
}

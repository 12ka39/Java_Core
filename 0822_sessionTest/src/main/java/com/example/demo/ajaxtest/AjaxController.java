package com.example.demo.ajaxtest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	//http://localhost:8081/ajax/view1 로 접속해서 확인   
	// get/string 버튼
	@GetMapping("/view1")
	public String view1() {
		return "ajax/test1";
	}
	
	
	// 응답 확인할 거면 이렇게 접속
	// http://localhost:8081/ajax/test1?num=3&name=aaa
	
	@ResponseBody // 웹 페이지가 아니라 데이터를 응답으로 전달
	// 응답은 덱스트로 전달된다.
	@GetMapping("/test1")
	public String test1(int num, String name) {
		return "hello ajax get 요청 / num: " + num + " /name: " + name; // 응답
			// 따로 /ajax/test1.jsp 안 만들었지만, 결과가 출력되는 걸 확인할 수 있다
	}
	
	// http://localhost:8081/ajax/view1 접속해서
	//post/string 버튼
	@ResponseBody
	@PostMapping("/test2")
	public String test2(int num, String name) {
		return "ajax post요청 / num:" + num + " / name:" + name;
	}
	
	//http://localhost:8081/ajax/test3?num=12&name=aaa 로 접속
	// { "num": 12,  "id": "aaa" }	
	// { } 객체    [] 배열
	@ResponseBody
	@GetMapping("/test3") // json get 방식으로 구하기
	public Map test3(int num, String name) {
		Map map = new HashMap();
		map.put("num", num);
		map.put("name", name);
		return map;
	}
	
	
	@ResponseBody
	@PostMapping("/test4")
	public Map test4(int num, String name) {
		Map map = new HashMap();
		map.put("num", num);
		map.put("name", name);
		return map;
	}
	
}

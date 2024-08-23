package com.example.demo.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.city.City;

@Controller
@RequestMapping("/guest")
public class GuestController {
	@Autowired
	GuestService service;
	
	
	@GetMapping("/detail")
	public String detail(int num, Model m) { 
		Guest g= service.getGuest(num);
		if(g==null) {
			m.addAttribute("msg", "없는 글입니다");
		} else {
			m.addAttribute("guest", g); // addAttribute("뷰페이지에서 부를 이름", 전달할 값)
			// 모델 객체에 담겨 값이 전달 됨
		}
		return "guest/detail";
	}
	
	
	
	
	// 글 목록
	@RequestMapping("/list")
	public String selectAll(Model m) {
		m.addAttribute("list", service.selectAll());
		return "guest/list";
	}

	// 방명록 글 작성 페이지 열기
	@GetMapping("/write")
	public String writeForm() {
		return "guest/write";
	}
	
	// 방명록 글 작성
	@PostMapping("/write")
	public String writeAdd(Guest g) {
		service.writeAdd(g);
		
		return "guest/list";
	}
	
}

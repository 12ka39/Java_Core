package com.example.demo.city;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")  // 공통 주소
public class CityController {
	@Autowired
	private CityService service;
	
	
	// Model 뷰 페이지에 전달할 값을 담는 용도,
	// 파람(parameter)으로 지정하면 객체 자동 생성해주고 값을 뷰페이지로 자동으로 전달됨
	// -> 줄이면 파라미터로 Model m 이라고 정해주면 알아서 객체 만들어주고 보내줌
	// 스프링이 알아서 모델 객체 생성해줌
	
	@GetMapping("/detail")
	public String detail(int id, Model m) { 
		City city = service.getCity(id);
		if(city==null) {
			m.addAttribute("msg", "없는 아이디");
		} else {
			m.addAttribute("city", city); // addAttribute("뷰페이지에서 부를 이름", 전달할 값)
			// 모델 객체에 담겨 값이 전달 됨
		}
		return "city/detail";
	}
	
	@GetMapping("/info") // 검색할 페이지
	public String info() { 
		return "city/info";
	}
	
	
	@GetMapping("/add")
	public String addForm(Model m) {
		ArrayList<String> list = new ArrayList<>(); // 국가 코드 담을 리스트
		// 이걸 하는 이유. DB에 국가 코드는 국가코드 테이블과 FK로 연결되어 있어서
		// 다른 거 넣으면 오류난다.
		list.add("AIA");
		list.add("BEN");
		list.add("CHL");
		list.add("DJI");
		list.add("FLK");
		list.add("KOR");
		m.addAttribute("list", list); // 모델에 국가코드 리스트로 담아서 뷰에 전달한다

		return "city/add";
	}
	
	@PostMapping("/add")
	public String insert(City city) { // 커맨드 객체
		service.addCity(city);
		return "index";
	}
	
	
	@RequestMapping("/list") 
	// 이건 get 이어도 post여도 상관없음 이럴 땐 requestMapping 으로 한다
	public String selectAll(Model m) {
		m.addAttribute("list", service.getAll());
		return "city/list";
	}
	
	
	//수정
	@PostMapping("/edit")
	public String edit(City city) {
		service.editCity(city);
		return "index";
	}
	
	
	//삭제
	@GetMapping("/del")
	public String del(int id) {
		service.delCity(id);
		return "index";
	}
	

}

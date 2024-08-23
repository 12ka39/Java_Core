package com.example.demo.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GuestBookController {
	
	@Autowired
	private GuestBookService service;
	
	
	@GetMapping("/") 
	public String home(Model m) { // 인덱스 화면에 list 보여줄 거라서 Model이 필요하다
		m.addAttribute("list", service.getAll());
		return "index";
	}
	
	
	/*
	 - 쓰기 작업(insert, update, delete)
  jdbcTemplate.update(sql, ?매칭 [])
 
- 한줄읽기
  jdbcTemplate.queryForObject(sql, ResultMap, pk값)

- 여러줄 읽기
  jdbcTemplate.query(sql, ResultMap)
  
  */
	
	
	//글 작성 폼
	@GetMapping("/book/add")
	public void addForm() { } // 반환값 void 하면 기본적으로 /book/add 로 리턴된다
	
	//글 작성 완료
	@PostMapping("/book/add")
	public String add(GuestBook gb) { 
		service.addBook(gb);
		return "redirect:/"; // redirect로 이동
		//쓰기(insert, update, delete)는 여러번 작성되는 경우를 막기 위해 redirect로 한다
		// select 제외하고는 모두 redirect 쓰자
	}
	
	
	// 상세 페이지
	@GetMapping("/book/detail")
	public void detail(int num, Model m) {
		m.addAttribute("gb", service.getBook(num));
		// void 니까 /book/detai.jsp 로 간다. 모델은 gb란 이름으로 보냈음
	}
	
	
	/// 수정하기가 어렵다
	//수정하기 edit
	@GetMapping("/book/edit")
	public String edit(GuestBook gb) {
		service.editBook(gb);
		return "redirect:/"; // 글 수정후 인덱스로 이동
	}

	//삭제
	@GetMapping("/book/del")
	public String del(int num) {
		service.delBook(num);
		return "redirect:/";
	}
	
}

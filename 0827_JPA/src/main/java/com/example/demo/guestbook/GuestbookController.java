package com.example.demo.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	@Autowired
	private GuestbookService service;
	
	
	//글목록
	@RequestMapping("/list")
	public void list(Model m) {
		m.addAttribute("list", service.getAll());
	}
	
	
	@GetMapping("/add")
	public void addForm() {}
	
	
	@PostMapping("/add")
	public String add(GuestbookDto dto) {
		service.saveBook(dto);
		return "redirect:/guestbook/list";
	}
	
	
	@GetMapping("/getbywriter")
	public String getbywriter(String writer, Model m) {
		m.addAttribute("list", service.getByWriter(writer));
		return "guestbook/list";
	}
	
	
	
}

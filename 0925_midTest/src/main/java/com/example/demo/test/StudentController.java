package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	//학생 목록
	@GetMapping("/") 
	public String list(Model model) {
		model.addAttribute("list", service.getList());
		System.out.println(model);
		return "index";
	}
	
	
	@GetMapping("/add")
	public void add() {}
	
	//학생 추가
	@PostMapping("/add")
	public void addStudent(StudentDto dto) {
		service.addStudent(dto);
	}
	
}

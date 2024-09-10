package com.example.demo.todo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/today")
public class TodoController {
	@Autowired
	private TodoService service;
	
	//	할 일 추가 API: 클라이언트로부터 POST 요청을 받아 할 일을 추가하는 API
	@PostMapping("/todo")
	public Map add(TodoDto dto) {
		Map map = new HashMap();
		boolean flag = true;
		
		try {
			service.addToDo(dto);
		}catch(Exception e) {
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}
	
	
	//	할 일 목록 조회 API: 모든 할 일 목록을 GET 요청으로 반환하는 API 
	@GetMapping("/list")
	public Map list() {
		Map map = new HashMap();
		ArrayList<TodoDto> list = service.getList();
		map.put("list", list);
		return map;
	}
	
	
	
	
	//번호로 검색
	@GetMapping("/{num}")
	public Map get(@PathVariable("num") int num) {
		Map map = new HashMap();
		TodoDto dto = service.getOne(num);
		map.put("dto", dto);
		return map;
	}
	
	
	// --------- 포스트맨에 number 하고 todo  2개를 키값으로 넣어줘야 오류 안 난다
	//할 일 수정 API: PUT 요청을 통해 특정 할 일을 수정하는 API 
	@PutMapping("/edit")
	public Map edit(TodoDto dto) {
		Map map = new HashMap();
		TodoDto member = service.getOne(dto.getNumber());
		member.setTodo(dto.getTodo());
		
		boolean flag = true;
		
		try {
			service.addToDo(member);
			System.out.println(member.getTodo());
		} catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		map.put("flag", flag);
		return map;
	}
	
	
	//	할 일 삭제 API: DELETE 요청을 통해 특정 할 일을 삭제하는 API
	@DeleteMapping("/{num}")
	public Map del(@PathVariable("num") int num) {
		Map map = new HashMap();
		boolean flag = true;
		
		try {
			service.del(num);
		} catch(Exception e) {
			e.printStackTrace();
			flag = false;
		}
		
		map.put("flag", flag);
		return map;
	}
	
	
	
}

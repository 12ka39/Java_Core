package com.example.demo.todo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	
	@Autowired
	private TodoDao dao;
	
	// 할 일 추가
	public void addToDo(TodoDto dto) {
		dao.save(new Todo(dto.getNumber(), dto.getWriter(), dto.getDate(), dto.getTodo()));
	}
	
	
	
	// 번호로 찾기
	public TodoDto getOne(int num) {
		Todo one  = dao.findById(num).orElse(null);
		return new TodoDto(one.getNumber(), one.getWriter(), one.getDate(), one.getTodo());
	}
	
	
	//리스트 목록
	public ArrayList<TodoDto> getList() {
		List<Todo> all = dao.findAll();
		ArrayList<TodoDto> list = new ArrayList<>();
		
		for( Todo todo : all ) {
			list.add(new TodoDto(todo.getNumber(), todo.getWriter(), todo.getDate(), todo.getTodo()));
		}
		
		return list;
	}
	
	
	//삭제
	public void del(int num) {
		dao.deleteById(num);
	}
}

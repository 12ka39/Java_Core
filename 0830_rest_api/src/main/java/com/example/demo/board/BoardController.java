package com.example.demo.board;

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
import org.springframework.web.service.annotation.GetExchange;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/boards")
public class BoardController {

	@Autowired
	private BoardService service;
	

	
	// 글 작성
	@PostMapping("")
	public Map add(BoardDto b) {
		Map map = new HashMap();
		boolean flag = true;
		try {
			service.saveBoard(b);
		} catch(Exception e) {
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}	
	
	//번호로 검색
	@GetExchange("/{num}")
	public Map get(@PathVariable("num") int num) {
		Map map = new HashMap();
		BoardDto dto = service.getBoard(num);
		map.put("dto", dto);
		return map;
	}
	
	// 검색 결과가 여럿인 건 일단 arrayList에 담고 
	// 그 결과를 map에 담아준다
	
	
	//글 목록(전체 검색)
	@GetMapping("")
	public Map list() { // 전체검색을 모델에 담아줌
		Map map = new HashMap();
		ArrayList<BoardDto> list = service.getAll(); // arraylist에 담아서 map에 넣는구나..
		map.put("list", list);
		return map;
	}	

	
	//제목으로 검색
	@GetMapping("/title")
	public Map getByTitle(@PathVariable("title") String title) {
		Map map = new HashMap();
		ArrayList<BoardDto> list = service.getByTitle(title); // arraylist에 담아서 map에 넣는구나..
		map.put("list", list);
		return map;		
	}
	
	
	
	//작성자로 검색
	@GetMapping("/writer")
	public Map getByWriter(@PathVariable("writer") String writer) {
		Map map = new HashMap();
		ArrayList<BoardDto> list = service.getByWriter(writer); // arraylist에 담아서 map에 넣는구나..
		map.put("list", list);
		return map;		
	}	
	
	
	//글 수정
	@PutMapping("/edit")
	public Map edit(BoardDto b) { // title, content 수정
		Map map = new HashMap();
		//원 데이터를 수정할 글번호로 검색
		BoardDto old = service.getBoard(b.getNum());
		old.setTitle(b.getTitle());
		old.setContent(b.getContent());
		boolean flag = true;
		try {
			service.saveBoard(old);
		} catch(Exception e) {
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}	
	
	
	//글 삭제
	@DeleteMapping("/{num}")
	public Map del(@PathVariable("num") int num) {
		Map map = new HashMap();
		boolean flag = true;
		try {
			service.delBoard(num);
		} catch(Exception e) {
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}	
	
}

package com.example.demo.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	//글 목록
	@GetMapping("/list")
	public void list(Model model) { // 전체검색을 모델에 담아줌
		model.addAttribute("list", service.getAll());
	}
	
	
	@GetMapping("/add") // board/add.jsp
	public void addForm() {}
	
	
	@PostMapping("/add")
	public String add(Board b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	@ResponseBody   //ajax - 페이지 이동 안 하고 ajax 요청
	@GetMapping("/getAjax")
	public Map getAjax(int num) { //글 번호로 검색
		Board b = service.getBoard(num); 
		Map map = new HashMap();
		map.put("num", b.getNum());
		map.put("writer", b.getWriter());
		map.put("wdate", b.getWdate()+""); // json은 날짜타입, boolean, 숫자 모두 -> "" 해줘야 파싱 된다
		map.put("title", b.getTitle());
		map.put("content", b.getContent());
		return map;
		
		//이 ajax 요청 잘 됐는지 확인~!!!		//http://localhost:8081/board/getAjax?num=2  (num은 실제로 존재하는 글번호)
		/*
		 *{
		    "num": 2,
		    "writer": "2",
		    "title": "제목",
		    "wdate": "2024-08-23",
		    "content": "내용입니다~"
		}
		 */
		
	}
	
	
	//상세페이지
	@GetMapping("/detail")
	public void datail(int num, Model model) {
		model.addAttribute("b", service.getBoard(num));
//		//쿠키 추가
//		Cookie c1 = new Cookie("list", num+"");
//		res.addCookie(c1);
		
	}

	
	@PostMapping("/edit")
	public String edit(Board b) {
		service.editBoard(b);
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
	
	
	//작성자로 검색
	@GetMapping("/getbywriter")
	public String getByWriter(String writer, Model m) {
		m.addAttribute("list", service.getByWriter(writer));
		return "board/list";
	}
	

	// 제목으로 검색
	@GetMapping("/getbytitle")
	public String getByTitle(String title, Model m) {
		m.addAttribute("list", service.getByTitle(title));
		return "board/list";
	}
}

package com.example.demo.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	public String add(BoardDto b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	@ResponseBody   //ajax - 페이지 이동 안 하고 ajax 요청
	@GetMapping("/getAjax")
	public Map getAjax(int num) { //글 번호로 검색
		BoardDto b = service.getBoard(num); 
		Map map = new HashMap();
		map.put("num", b.getNum());
		map.put("writer", b.getWriter());
		map.put("wdate", b.getWdate()+""); // json은 날짜타입 boolean 숫자 -> "" 해줘야 파싱 된다
		map.put("title", b.getTitle());
		map.put("content", b.getContent());
		return map;
		
		//이 ajax 요청 잘 됐는지 확인~!!!		//http://localhost:8081/board/getAjax?num=2  (num은 실제로 존재하는 글번호)
		/*
		 *{
		    "num": 2,
		    "writer": "2",
		    "title": "됐다!",
		    "wdate": "2024-08-23",
		    "content": "신난다"
		}
		 */
		
	}
	
	
	//상세페이지 (쿠키로 오늘 읽은 글 번호 저장)
	@GetMapping("/detail")
	public void datail(int num, Model model, HttpServletRequest req, HttpServletResponse res) {
		model.addAttribute("b", service.getBoard(num));
		String val = "";
		Cookie[] cookie = req.getCookies();
		for (Cookie c : cookie) {
			if(c.getName().equals("today")) { 
				val = c.getValue();
				val += "/" + num; //1,2,3
			}
		}
		
		if(val.equals("")) {
			val = num+ "";
		}
		res.addCookie(new Cookie("today", val));
	}
	
	
	//오늘 읽은 글목록 List 
	@GetMapping("/today")
	public String today(HttpServletRequest req, Model model) {
		String val = "";
		Cookie[] cookie = req.getCookies();
		for(Cookie c : cookie) {
			if(c.getName().equals("today")) {
				val = c.getValue();
			}
		}
		
		ArrayList<BoardDto> list = new ArrayList<>();
		if (!val.equals("")) {
			String[] val2 = val.split("/");
			for(String n : val2) {
				int num = Integer.parseInt(n);
				list.add(service.getBoard(num));
			}
		}
		model.addAttribute("list", list);
		return "board/list";
	}
	
	
	
	@PostMapping("/edit")
	public String edit(BoardDto b) {
		//수정하기 전 원본 글 정보검색. save()는 모든 컬럼 수정. 누락된 값은 null;
		BoardDto ob = service.getBoard(b.getNum()); // 원본 글 검색해서
		ob.setTitle(b.getTitle()); // 수정할 정보 타이틀, 내용(content)만 수정
		ob.setContent(b.getContent());
		service.saveBoard(ob);
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/del")
	public String del(int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
	
	
	
	@GetMapping("/getbytitle")
	public String getByTitle(String title, Model m) {
		m.addAttribute("list", service.getByTitle(title));
		
		return "board/list";
	}
	
	
	@GetMapping("/getbywriter")
	public String getByWriter(String writer, Model m) {
		m.addAttribute("list", service.getByWriter(writer));
		
		return "board/list";
	}
	
}

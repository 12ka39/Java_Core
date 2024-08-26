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
	
	
	//상세페이지
//	@GetMapping("/detail")
//	public void datail(int num, Model model) {
//		model.addAttribute("b", service.getBoard(num));
//	}
	

	@GetMapping("/detail")
	public void detail(int num, Model model, HttpServletResponse response, HttpServletRequest request) {
	    // 쿠키에서 "viewedBoards"를 읽어옴
	    Cookie[] cookies = request.getCookies();
	    String viewedBoards = "";

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("viewedBoards")) {
	                viewedBoards = cookie.getValue();
	            }
	        }
	    }

	    // 쿠키에 현재 글 번호가 없으면 추가
	    if (!viewedBoards.contains(String.valueOf(num))) {
	        viewedBoards = viewedBoards.isEmpty() ? String.valueOf(num) : viewedBoards + "-" + num;

	        Cookie cookie = new Cookie("viewedBoards", viewedBoards);
	        cookie.setPath("/"); 
	        cookie.setMaxAge(7 * 24 * 60 * 60); // 7일 유효
	        response.addCookie(cookie);
	    }

	    // 글 정보를 모델에 추가
	    model.addAttribute("b", service.getBoard(num));
	}
	
	
	@GetMapping("/viewed")
	public String viewedBoards(Model model, HttpServletRequest request) {
	    // 쿠키에서 "viewedBoards" 값을 읽어옴
	    Cookie[] cookies = request.getCookies();
	    List<Board> viewedList = new ArrayList<>();

	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("viewedBoards")) {
	                String[] boardIds = cookie.getValue().split("-");
	                for (String id : boardIds) {
	                    int num = Integer.parseInt(id);
	                    Board board = service.getBoard(num); // 각 num에 해당하는 Board 객체 조회
	                    viewedList.add(board);
	                }
	            }
	        }
	    }

	    model.addAttribute("viewedList", viewedList); // 모델에 추가
	    return "/board/viewed"; // 리스트 뷰로 이동
	}
	
	
	

	//오늘 읽은 글목록 List 
	@GetMapping("/todaylist")
	public void todaylist(HttpServletRequest req) {
		Cookie[] list = req.getCookies(); // string

		for(Cookie c : list) {
			System.out.println(c.getValue());
		}
		
//		<숙제>
//		쿠키 -> 읽어와서 뒤에 덧붙여준다,
//		구분자를 찍어주고,
//		쿠키값을 읽어서 split으로 쪼개서 
//		그 번호 검색한 거 arrayList에 담아서 뿌려주기
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

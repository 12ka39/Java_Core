package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.guestbook.GuestbookController;
import com.example.demo.guestbook.GuestbookDto;
import com.example.demo.guestbook.GuestbookService;



// 근데 이건 postman이 더 확인이 쉽다고 한다


@WebMvcTest(GuestbookController.class) // 컨트롤러 테스트 어노테이션
// 어떤 요청이 들어오고, 어떤 파라미터가 들어오는지 확인해주는 어노테이션
//기본 형태 => @WebMvcTest(클래스명.class)  
public class GuestbookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean // 실제로 데이터가 DB에 들어가거나 검색할 수는 없음. 
	//왜? 컨트롤러는 웹요청 확인만 하니까.
	//@MockBean 은 웹 요청 처리하는데 필요한 부분만 제공하는 가상의 서비스 객체 생성
	private GuestbookService service; // ------------- 실제 DB랑 연동되는게 아님. 가상 객체
	
	// MockMvc  : mvc 웹의 목테스트 API 제공해주는 클래스
	// perform() : mock 수행 메서드. get(), post()....
	//  .andDo() : 테스트 시 수행할 내용 작성. 여기선 print() : 출력
	// andExpect() : 처리 결과 상태 지정
	
	@Test
	void addFomrTest() {
		try {
			mockMvc.perform(get("/guestbook/add")) // 이 3개 import 문제 있음
				         .andDo(print())
				         .andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
		 	@PostMapping("/add")
		public String add(GuestbookDto dto) {
			service.saveBook(dto);
			return "redirect:/guestbook/list";
		}
	 */
	
	
	@Test 
	void addTest() {
		String params = "?writer=aaa&pwd=111&content=테스트";
		try {
			mockMvc.perform(post("/guestbook/add"+params))  //실제로 이게 DB에 들어가는 게 아님. 요청이 잘 되는지 확인 하는 거
				         .andDo(print())
				         .andExpect(status().is3xxRedirection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 	@RequestMapping("/list")
	public void list(Model m) {
		m.addAttribute("list", service.getAll());
	}
	*/
	
	@Test
	void lsitTest() {
		//service.getAll() 의 가상의 리턴값 (DB접속 안 되니까--지금 여긴 컨트롤러-- 가상 데이터 만듦)
		ArrayList<GuestbookDto> list = new ArrayList<>();
		list.add(new GuestbookDto(1, "aaa", new Date(), "111", "내용1"));
		list.add(new GuestbookDto(2, "bbb", new Date(), "222,", "내용2"));
		list.add(new GuestbookDto(3, "ccc",  new Date(),  "333", "내용3"));
		
		
		//when() : 테스팅 시나리오에서 특정 이벤트가 발생하면
		//thenReturn() :  이벤트 발생시 지정한 값 리턴
		when(service.getAll()).thenReturn(list);
		try {
			mockMvc.perform(get("/guestbook/list"))  //실제로 이게 DB에 들어가는 게 아님. 요청이 잘 되는지 확인 하는 거
				         .andDo(print())
				         .andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 
	 ModelAndView:
        View name = guestbook/list
             View = null
        Attribute = list
            value = [GuestbookDto(num=1, writer=aaa, wdate=Thu Sep 05 11:09:27 KST 2024, pwd=111, content=내용1), 
            GuestbookDto(num=2, writer=bbb, wdate=Thu Sep 05 11:09:27 KST 2024, pwd=222,, content=내용2), 
            GuestbookDto(num=3, writer=ccc, wdate=Thu Sep 05 11:09:27 KST 2024, pwd=333, content=내용3)]
 
	 */
	
	
	
}

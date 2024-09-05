package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.down.DownController;

//파일 다운로드 테스트

@WebMvcTest(DownController.class)
public class DownControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	void downTest() {
		try {
			mockMvc.perform(get("/down/down?fname=cafe.jpg")) //C:\down에 있는 실제 파일명 작성 
						.andDo(print())
						.andExpect(status().isOk()); // status 302가 아니면 예외처리하겠다
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
		 MockHttpServletRequest:
	      HTTP Method = GET
	      Request URI = /down/down
	       Parameters = {fname=[cafe.jpg]}
	          Headers = []
	             Body = null
	    Session Attrs = {}

	 */
	

}

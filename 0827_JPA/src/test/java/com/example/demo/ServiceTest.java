package com.example.demo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.guestbook.GuestbookDto;
import com.example.demo.guestbook.GuestbookService;

@SpringBootTest // 테스트할 거라고 알려주는 어노테이션
public class ServiceTest {
	@Autowired
	private GuestbookService service; // 지금 이거 잘 돌아가나 테스트해보려고 하니까 autowired
	
	@Test  // 단위 테스트 ----  글 추가
	void addTest() { // 테스트 메소드명은 아무거나 작성해도 됨
		service.saveBook(new GuestbookDto(0, "aaa", null, "111", "글내용"));  // 새 GuestbookDto 객체 만들어서 테스트
		// 저장 잘 되나 Test                      0은 auto_increment니까 아무거나,   Date도 알아서 들어가니까 null									
	}
	
	
	@Test  // 단위 테스트 ----  글 수정
	void addTest2() { // 테스트 메소드명은 아무거나 작성해도 됨
		GuestbookDto dto = service.getBook(1); // 1번 글 수정
		if(dto != null) {
			dto.setWriter("J-unit Test입니다");
			dto.setContent("J-unit Test");
			service.saveBook(dto);		
		} else { 
			System.out.println("없는 글입니다");
		}
	}	
	
	
	@Test  // 단위 테스트 ---- 글 목록
	void listTest() { 
		ArrayList<GuestbookDto> list =  service.getAll();			
		System.out.println(list);
	}
	
	
	
}

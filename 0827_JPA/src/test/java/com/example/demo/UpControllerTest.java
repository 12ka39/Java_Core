package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.updown.UpController;

@WebMvcTest(UpController.class)
public class UpControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	//파일 업로드 테스트
	@Test
	void upTest() {
		// 파일의 첫번째 파람은
		// param1 : 파일 전송 폼양식 이름 (파라미터 이름)
		// param2 : 원본 파일명
		// param3 : 헤더정보. 파일의 종류
		// param4.: 파일 내용
		MockMultipartFile file = 
				new MockMultipartFile("f", "a.txt", "text/plain", "file content 아무내용 작성".getBytes());
				// 실행하면 C:/img에 파일 생성
		
		
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.multipart("/upload/upload")
						.file(file) // MockMultipartFile
						.param("title", "타이틀내용")) // 두번째 파라미터 String title 니까
						.andDo(print())
						.andExpect(status().is3xxRedirection()); // status 302가 아니면 예외처리하겠다
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 @RequestMapping("/upload")
	 ...
	 @PostMapping("/upload")
	public String upload(MultipartFile f, String title) { 

		String fname =f.getOriginalFilename(); 
		File newf = new File("C:\\img\\" + fname); 

		try {
			f.transferTo(newf); // 서버에 파일복사.  업로드 파일을 newf에 복사 
		
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("fname: " + fname);
		System.out.println("title: " + title);
		
		return "redirect:/upload/list";
	}
	 
	 */
	
}

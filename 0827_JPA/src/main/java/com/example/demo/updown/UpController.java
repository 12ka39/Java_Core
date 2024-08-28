package com.example.demo.updown;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UpController {

	@GetMapping("/form")
	public void uploadForm() {}
	
	
	//
	/*
		 <form action="/upload/upload" method="post" enctype="multipart/form-data">
			file: <input type="file" name="f"><br/>
			title: <input type="text" name="title"><br/>
			<input type="submit" value="전송">
		</form>
	 */
	
	
	//MultipartFile은 업로드된 파일에 대한 데이터를 캡슐화하는 인터페이스로, 
	// 파일 이름, 파일 내용, 파일 크기 등을 다룰 수 있습니다.
	
	
	// 전송버튼을 누르면, 데이터가 서버로 올라간다. 지금 아래 코드에서는 데이터 담긴 게 MultipartFile f.
	// 그런데 아직 파일이 만들어진 건 아님!
	// 하지만 데이터(f) 는 있으니까 빈 파일객체 하나 만들고 f복사한 걸 파일 객체에 집어넣는다. 
	@PostMapping("/upload")
	public String upload(MultipartFile f, String title) {
		// MultipartFile : 파일 업로드 api 클래스
		// 업로드한 파일은 MultipartFile 타입으로 전송되는데 name은  form 양식의 이름과 같다 <input type="file" name="f">
		
		//getOriginalFilename() : 원본 파일명 반환 (확장자 포함)
		String fname =f.getOriginalFilename(); // 원본 파일이름
		File newf = new File("C:\\img\\" + fname); // 이 경로에 파일 객체 생성. 이건 서버 경로입니다. 
		//연습하느라 내 컴퓨터에 저장하느라 경로가 이럴 뿐이지, 실제로는 이게 아닙니다. 실제로는 파일이 생성될 서버 경로!
			//newf: File 객체로, 업로드된 파일을 저장할 서버 내의 경로를 지정합니다
		
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
	
	
	/* 이 코드는 파일 이름만 출력하는 거라 이미지 파일 아니어도 됨 */
	@GetMapping("/list")
	public void list(Model m) {
		//C:\\img\\ 폴더의 파일 목록을 읽어서 m에 담아서 list.html에 파일명 목록 텍스트로 출력
		File dir = new File("C:\\img\\"); // 파일 경로를 객체로 만들 수 있다.
		String[] files = dir.list(); // 디렉토리의 파일 목록 가져오기
		m.addAttribute("files", files);
	}
	// upload/list.html
	
	
	@GetMapping("/read-img")
	public ResponseEntity<byte[]> read_img(String fname){ // fname은 파라미터 담겨서 넘어왔음
		//응답으로 byte배열에 이미지 파일을 담아 보낸다
		ResponseEntity<byte[]> result = null;
		
		File f = new File("C:\\img\\"+fname);
		
		//응답 헤더 정보 저장 객체
		HttpHeaders header = new HttpHeaders();
		try {
			//전송하는 데이터의 마임 타입 설정
			// 웹 서버는 클라이언트에게 파일을 전송할 때, 
			// 파일의 마임 타입을 헤더(Content-Type)에 포함하여 전송합니다. 
			// 하면 클라이언트는 수신한 파일이 어떤 종류인지 알 수 있습니다.
			
			// Files.probeContentType(filePath)
			// 이 메서드는 filePath에 있는 파일의 MIME 타입을 추론하여 반환합니다. 
			// 예를 들어, example.jpg 파일의 MIME 타입은 "image/jpeg"가 됩니다.
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(
							FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK
							//                                                           상태정보 Ok
					);
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}

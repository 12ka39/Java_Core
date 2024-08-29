package com.example.demo.down;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/down")
public class DownController {

	private String path = "C:\\down\\";
	
	@GetMapping("")
	public String flist(ModelMap map) { //파일 목록을 읽어서 출력
		File dir = new File(path); // 파일 객체 생성
		map.addAttribute("list", dir.list()); // 파일목록을 list에 담는다
		return "down/list";
	}
	
	
	@GetMapping("/down")
	public ResponseEntity<byte[]> read_img(String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + fname); // C:\\donw\\ 파일객체 생성
		HttpHeaders header = new HttpHeaders(); // import org.springframework.http.HttpHeaders;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			header.add(HttpHeaders.CONTENT_DISPOSITION, // 헤더에다가 알려줌. 첨부파일이 있고,
					"attachment;filename=\"" 			// 파일 내용은 이거고
							+ URLEncoder.encode(fname, "UTF-8") + "\""); // 한글로 된 이름은 utf-8로 인코딩해서 헤더에 담는다
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result; // 응답으로 다운로드 파일을 주었기 때문에  페이지 이동이 아니라 파일이 다운로드 된다
	}
	
}

package com.example.demo.article;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// 로그인을 하고 나서 자료실 링크를 클릭한다

@Controller
@RequestMapping("/data")
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	// 스프링 설정과 다른 경우, 직접 경로를 적어준다
	//private String path = "C:\\down\\";
	
	
	@RequestMapping("/list")
	public void list(Model m) {
		m.addAttribute("list", service.getAll());
	}
	
	
	@GetMapping("/add")
	public void addForm() {}
	
	@PostMapping("/add")
	public String add(ArticleDto dto) {
		ArticleDto dto2 = service.saveArticle(dto); // 폼 양식으로 날아온 dto 저장하고, (insert)
		String fname = dto2.getNum() + dto.getF().getOriginalFilename();  // 숫자+파일명
		File newf = new File(path + fname);  // 이 경로로 파일 객체 만든다
		try {
			dto.getF().transferTo(newf); // dto의 MultipartFile f에 있는 데이터 newf에 저장
			dto2.setData(fname);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.saveArticle(dto2); // 저장
		return "redirect:/data/list";
	}
	
	
	
	@GetMapping("/detail")
	public void detail(int num, Model m) {
		m.addAttribute("dto", service.getArticle(num));
	}
	
	
	@GetMapping("/down")
	public ResponseEntity<byte[]> read_img(String fname, int num) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + fname);
		HttpHeaders header = new HttpHeaders(); // import org.springframework.http.HttpHeaders;
		try {
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			header.add(HttpHeaders.CONTENT_DISPOSITION,
					"attachment;filename=\"" +
			URLEncoder.encode(fname, "UTF-8") + "\"");
			result = new ResponseEntity<byte[]>(
					FileCopyUtils.copyToByteArray(f), header, 
					HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.editCnt(num);
		return result;
	}
}


package com.example.demo.imgboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.Users;

@RestController // postman에서 확인
@CrossOrigin(origins = "*")
public class ImgboardController {
	@Autowired
	private ImgboardService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	//글 추가 ------- imgboard테이블에 이미지랑 title 추가하는 거  (파라미터가 MultipartFile f, String title)
	//post 맨에서 실행할 때는 당연하지만 header에 token 추가해준 다음에 f 올려줘야 한다.  
	// f  파일   /  title  제목
	// 설정해둔 경로인 C:\img 에 이미지 올라감(실무에선 서버)
	@PostMapping("/board")
	public Map add(ImgboardDto dto) {
		String fname = dto.getF().getOriginalFilename();
		File newf = new File(path + fname);
		boolean flag = false;
		try {
			dto.getF().transferTo(newf);
			dto.setImg(fname);
			Authentication a = 
					SecurityContextHolder.getContext().getAuthentication();
			Users u = new Users(a.getName(), "", "");
			dto.setWriter(u);
			service.save(dto);
			flag = true;
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}
	
	
	
	// 게시글 가져오기 (json으로 온다)
	@GetMapping("/board")
	public Map list() {
		Map map = new HashMap();
		map.put("list", service.getAll());
		return map;
	}
	/*
	 {
    "list": [
        {
            "num": 1,
            "writer": {
                "id": "0905",
                "pwd": "{bcrypt}$2a$10$Udr11MVcPh.lEV5Q9ZbKd.jf8ox4fQv89cVFd4.6QeXMFLP493VRq",
                "type": "판매자"
            },
            "title": null,
            "img": "스크린샷 2024-08-16 204511.png",
            "f": null
        },
        {
            "num": 2,
            "writer": {
                "id": "0905",
                "pwd": "{bcrypt}$2a$10$Udr11MVcPh.lEV5Q9ZbKd.jf8ox4fQv89cVFd4.6QeXMFLP493VRq",
                "type": "판매자"
            },
            "title": null,
            "img": "스크린샷 2024-08-16 204511.png",
            "f": null
        },
        {
            "num": 3,
            "writer": {
                "id": "0905",
                "pwd": "{bcrypt}$2a$10$Udr11MVcPh.lEV5Q9ZbKd.jf8ox4fQv89cVFd4.6QeXMFLP493VRq",
                "type": "판매자"
            },
            "title": "asdf",
            "img": "스크린샷 2024-08-16 204511.png",
            "f": null
        }
    ]
} 
	 
	*/
	
	
	
	@GetMapping("/read-img/{fname}") // 요청줄 때 확장자 명까지 제대로 줘야 postman에서 이미지 불러온다
	// http://localhost:8081/read-img/스크린샷 2024-08-16 204511.png
	public ResponseEntity<byte[]> read_img(
			@PathVariable("fname") String fname) {
		ResponseEntity<byte[]> result = null;
		File f = new File(path + fname);
		// 응답 헤더 정보 저장 객체
		HttpHeaders header = new HttpHeaders();
		try {
			// 전송하는 데이터의 마임 타입 설정
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}











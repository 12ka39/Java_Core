package com.example.demo.imgboard;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.Users;

@RestController
@CrossOrigin(origins = "*")
public class ImgboardController {
	@Autowired
	private ImgboardService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	//글 추가 ---------------------------------
	@PostMapping("/board")
	public Map add(ImgboardDto dto) {
		String fname = dto.getF().getOriginalFilename();
		File newf = new File(path + fname);
		
		boolean flag = true;
		
		try {
			dto.getF().transferTo(newf);
			dto.setImg(fname);
			Authentication a = 
					SecurityContextHolder.getContext().getAuthentication();
			Users u = new Users(a.getName(), "", "");
			dto.setWriter(u);
			service.save(dto);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}
	
	
	@GetMapping("/board")
	public Map list() {
		Map map =new HashMap();
		map.put(l, map)
	}
	
	
	
}

package com.example.demo.seller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.demo.users.Users;
import com.example.demo.users.UsersDto;

 
@RestController  // postman에서 확인
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class SellerController {

	@Autowired
	private SellerService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	
	// 상품등록(상품번호, 상품명, 상품설명, 가격, 수량, 이미지)
	// 상품 등록은 당연하지만, 로그인해서 토큰 받고,
	// postman 헤더에 token   토큰번호  입력해야 된다
	@PostMapping("/add") // 현재 문제점 -> 구매자도 상품등록이 가능..
	public Map addProduct(SellerDto dto) {
		String fname = dto.getF().getOriginalFilename();
		File newf = new File(path + fname);
		boolean flag = false;
		
		try {
			dto.getF().transferTo(newf);
			dto.setProImg(fname);
			
			Authentication a = 
					SecurityContextHolder.getContext().getAuthentication();
			Users u = new Users(a.getName(), "", "");
			dto.setWriter(u);
			service.saveProduct(dto);
			
			flag = true;
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map map = new HashMap();
		map.put("flag", flag);
		
		return map;
	}
	
	
	//번호로 검색
	@GetMapping("/num")
	//@GetExchange("/{num}")
	public Map getProduct(@PathVariable("num") int num) {
		Map map = new HashMap();
		SellerDto dto = service.getProduct(num);
		map.put("dto", dto);
		return map;
	}

	

	
	// 내상품 정보수정(상품명, 상품설명, 가격, 이미지 수정)
	@PutMapping("/edit")
	public Map edit(SellerDto m) {//id, 새pwd
		Map map = new HashMap();
		SellerDto old = service.getMem(m.getId());
		//pwd만 수정
		old.setPwd(m.getPwd()); // 방금 입력받은 pwd를 세팅
		SellerDto m2 = service.saveMem(old);
		map.put("dto", m2);
		return map;
	}
	
	
	
	
	// 내상품 상품삭제
	@GetMapping("/delete")
	public void delProduct(int num) {
		service.delProduct(num);
	}
	
	
	
	// 내상품목록 (list)
	@GetMapping("/auth/list")
	public Map info() {
		Map map = new HashMap();
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName(); //username 추출
		SellerDto dto = service.get(id);
		map.put("dto", dto);
		return map;
	}

	
	
	
	public UsersDto getMem(String id) {
		Users entity = dao.findById(id).orElse(null);
		if(entity !=null) {
			return new MemberDto(entity.getId(), entity.getPwd(), entity.getName(), entity.getEmail(), entity.getType());
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
}

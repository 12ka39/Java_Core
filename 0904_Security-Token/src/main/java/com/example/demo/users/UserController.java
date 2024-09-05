package com.example.demo.users;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.TokenProvider;

// 토큰 인증



@CrossOrigin(origins= "*")
//rest-api
@RestController
public class UserController {
	
	@Autowired
	private UsersService service;
	
	@Autowired
	private TokenProvider provider;
	
	@Autowired
	private AuthenticationManagerBuilder abuilder;
	
	
	//회원가입 -- 인증과 상관 없으니까 기존에 해오던 프로젝트 코드랑 같음
	@PostMapping("/join")
	public Map join(UsersDto dto) {
		boolean flag = true;
		try {
			service.save(dto);
		}catch(Exception e) {
			flag = false;
			System.out.println(e);
		}
		
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}
	
	
	//로그인 (토큰 인증)
	@PostMapping("/login")
	public Map login(String id, String pwd) {
		UsernamePasswordAuthenticationToken authtoken = 
				new UsernamePasswordAuthenticationToken(id, pwd);  // 토큰 객체 생성
		Authentication auth = 
				abuilder.getObject().authenticate(authtoken);
		boolean flag = auth.isAuthenticated();//인증결과
		System.out.println("인증결과:" + flag);
		Map map = new HashMap();
		if(flag) {//정상 인증
			String token = provider.getToken(service.get(id));
			map.put("token", token);
		}
		map.put("flag", flag);
		return map;
	}
	
	

	@GetMapping("/auth/meminfo")
	public Map info() {
		Map map = new HashMap();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName(); //username 추출
		UsersDto dto = service.get(id);
		map.put("dto", dto);
		return map;
	}
	
	
}

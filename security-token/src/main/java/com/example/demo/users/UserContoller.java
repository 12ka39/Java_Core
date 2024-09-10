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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.auth.TokenProvider;

@RestController   // rest-api / postman에서 확인
@CrossOrigin(origins = "*")
/* 보안상 *는 좋지 않다
 @CrossOrigin(origins = "https://example.com")
이렇게 하면 https://example.com 도메인에서만 접근할 수 있도록 제한됩니다.
* */

public class UserContoller {
	@Autowired
	private UsersService service;

	@Autowired
	private TokenProvider provider;

	@Autowired
	private AuthenticationManagerBuilder abuilder;
	
	
	//join은 딱히 인증이 필요 없음
	@PostMapping("/join")
	public Map join(UsersDto dto) { // 반환형이 map인 건 'flag : true' 뭐 이른 걸 return하려고 적은 거
		boolean flag = true;
		try {
			service.save(dto);
		} catch (Exception e) {
			flag = false;
			System.out.println(e);
		}
		Map map = new HashMap();
		map.put("flag", flag); // 가입 성공여부를 postman에서 확인하려고
		return map;
	}
	

	// 로그인 시 토큰 필요. -- 로그인하고 발급받은 토큰은 매 요청마다 헤더에 담겨져서 간다 
	@PostMapping("/login")
	public Map login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {
		 // 이 부분 선생님 코드는  login(String id, String pwd)  이렇게 해도 실행되는데, 나는 안 돼서 @RequestParam 붙여줌
		UsernamePasswordAuthenticationToken authtoken = 
				new UsernamePasswordAuthenticationToken(id, pwd);
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
		return map; // flag, token 들어간 map 반환
	}
	
	
	
	// postman에서 확인하려면 헤더에 토큰 입력하고 get 요청 해야 함.   GET 요청!!
	@GetMapping("/auth/meminfo")
	public Map info() {
		Map map = new HashMap();
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName(); //username 추출
		UsersDto dto = service.get(id);
		map.put("dto", dto);
		return map;
	}

	

}

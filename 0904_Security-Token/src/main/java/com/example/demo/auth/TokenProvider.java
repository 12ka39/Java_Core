package com.example.demo.auth;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.example.demo.users.UsersDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

//인증 성공하면 토큰 생성하는 클래스

@RequiredArgsConstructor // 필요한 멤버 받는 생성자 자동 생성
@Component

//autowired
// bean - 게터 메소드와 매칭해 API 객체 주입
// Component 우리가 만든 클래스 객체가 필요한 경우

public class TokenProvider {
	// 토큰 유효 시간
	private final long expiredTime = 1000 * 60 * 60 * 1L;  // 1시간. (기본적으로 ms라서  1000 * 60 * 60)
		// 암호화에 사용할 키 생성
		Key key = Keys.hmacShaKeyFor(
				"akwoeiwlkejlrkwlkejklslklzkxlkjlckjlkdjlskjlewenfxz.lksjlekwherklkjsdcxmcjk".getBytes(StandardCharsets.UTF_8));
				// 무작위 문자인데, 너무 짧으면 오류가 난다고 한다
		
		private final UserDetailsService service;
		
		//토큰 생성하여 반환
		public String getToken(UsersDto dto) {
			return Jwts.builder().setSubject(dto.getId()) // Jwts 자바스크립트 웹 토큰  builder 설정 // 토큰 제목
					.setHeader(createHeader())   // 헤더 정보 설정 (토큰의 헤더 정보 셋)
					.setClaims(createClaims(dto)) // 클레임 정보 셋
					.setExpiration(
							new Date ((new Date()).getTime() + expiredTime)) // 현재시간 + 만료 시간(1시간)
					.signWith(key, SignatureAlgorithm.HS256).compact(); // 서명에 사용할 알고리즘과 키값
		}
		
		//헤더 정보 생성해서 반환. (주로 토큰 종류, 암호화 알고리즘 종류, 등록 시간...)
		public Map createHeader() {
			Map<String, Object> map = new HashMap<>();
			map.put("type", "JWT");
			map.put("alg", "HS256");
			map.put("regDate", System.currentTimeMillis()); // 현재 시간 담아줌
			
			return map;
		}
		
		
		//클레임 생성해서 반환  (인증자와 관련된 정보)
		public Map createClaims(UsersDto dto) {
			Map<String, Object> map = new HashMap<>();
			map.put("username", dto.getId());
			map.put("roles", dto.getType());
			return map;
		}
		
		
		
		//클레임 바디 반환
		// 토큰을 받으면 거기서 클레임 바디만 꺼내주는 메소드
		private Claims getClaims(String token) { // key는 여기에서만 사용하니까 private (보안상)
			return (Claims) Jwts.parserBuilder().setSigningKey(key).build() // 이 클래스에 있는 key로 암호를 풀어서
					   .parse(token).getBody(); 
		}
		
		
		//username 반환
		public String getUserName(String token) {
			return (String) getClaims(token).get("username"); 
		}

		
		// role 반환
		public String getRole(String token) {
			return (String) getClaims(token).get("roles"); 
		}
		
		
		//요청 헤더에서 토큰을 꺼내서 반환
		public String resolveToken(HttpServletRequest req) {
			return req.getHeader("token"); 
		}
		
		
		//토큰 유효성 검사
		public boolean validateToken(String token) { 
			
			try {
				Claims claims = getClaims(token); // 토큰의 바디 꺼내주는 메소드
				return !claims.getExpiration().before(new Date()); // 만기시간이 앞서있다며 (= 아직 만료 안 되었다면)
			} catch(Exception e) {
				System.out.println(e);
			}
			return false;
		}
		
		
		//토큰 인증 결과를 주는 메소드
		public Authentication getAuthentication(String token) {
			
			UserDetails user = service.loadUserByUsername(getUserName(token)); // 토큰에서 username 꺼내주는 메소드가 위에 정의한 getUserName
			return new UsernamePasswordAuthenticationToken( // id, pwd 맞춰서 인증결과 리턴해준다고 한다
										user, " ", user.getAuthorities());
					
		}
		
		
}

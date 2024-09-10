package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
	@Autowired
	private UsersDao dao;
	
	@Autowired
	private PasswordEncoder encoder; // 비밀번호 암호화 시키는 기능하는 듯
	/*
	PasswordEncoder는 보통 비밀번호를 암호화하거나 해시화하는 데 사용되는 컴포넌트입니다. 
	이 클래스는 특히 보안 관련 작업에서 비밀번호를 안전하게 저장하기 위해 필요합니다. 다양한 인코딩 방식이 있으며, 
	자바에서 가장 일반적으로 사용되는 것은 Spring Security에서 제공하는 PasswordEncoder 인터페이스입니다. 
	 
	 이 인터페이스는 두 가지 주요 메서드를 제공합니다:

	encode(rawPassword): 평문 비밀번호를 암호화합니다.
	matches(rawPassword, String encodedPassword): 사용자가 입력한 비밀번호와 암호화된 비밀번호를 비교하여 일치 여부를 확인합니다.
	일반적으로 PasswordEncoder는 BCrypt, PBKDF2, SCrypt 등과 같은 강력한 해시 알고리즘을 사용하여 비밀번호를 안전하게 처리합니다.
	 
	 */
	
	
	//추가, 수정
	public void save(UsersDto dto) {
		dao.save(new Users(dto.getId(), encoder.encode(dto.getPwd()),
				dto.getType()));
	}
	
	//pk 검색
	public UsersDto get(String id) {
		Users entity = dao.findById(id).orElse(null);
		if(entity != null) {
			return new UsersDto(entity.getId(),entity.getPwd(), 
					entity.getType());
		}
		return null;
	}
	
	//삭제
	public void del(String id) {
		dao.deleteById(id);
	}
}





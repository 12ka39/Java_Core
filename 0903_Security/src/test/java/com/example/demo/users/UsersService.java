package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/*
	 <구현 내용>
	UserDetails (인터페이스) 구현 클래스 정의 : UserDetails interface 상속받은 구현 클래스 정의
	 - 인증 정보 vo.   (username, password 권한 정보를 갖는 클래스.
	    이 계정이 파기됐는지, lock 상태인지 정보도 제공
*/

@Service
public class UsersService {
	@Autowired
	private UsersDao dao;
	
	@Autowired
	private PasswordEncoder encoder; // 스프링 자동 제공 클래스
	
	//추가, 수정
	public void save(UsersDto dto) {
		dao.save(new Users(dto.getId(), encoder.encode(dto.getPwd()), dto.getType()));
	}
	
	//pk 검색
	public UsersDto get(String id) {
		Users entity = dao.findById(id).orElse(null);
		if(entity != null) {
			return new UsersDto(entity.getId(), entity.getPwd(), entity.getType());
		}
		return null;
	}
	
	//삭제
	public void del(String id) {
		dao.deleteById(id);
	}
}

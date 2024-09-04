package com.example.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/*		(2단계)
 		UserDetailsService 구현 클래스 정의: 인증 기능 제공 // 스프링에서 제공해주는 인증 관련 클래스
 		
	    public UserDetails loadUserByUsername(String username){}
		dao 클래스의 검색 메서드로 id로 검색된 결과를 반환	 => 인증 성공
		검색 안 되면 예외 발생 => 인증 실패
 */

@Service
public class UserDetailServiceImple implements UserDetailsService {

	@Autowired
	private UsersDao dao;
	
	@Override  // 아이디 받아와서 검색해서 DB에 결과가 있으면 UserDetails에 담아서 return
					//아이디 없으면 예외 발생
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users u = dao.findById(username) //결과가 있으면 u에 담고,
		.orElseThrow(()-> new UsernameNotFoundException("not found username" + username));
									//없으면  예외 처리
		System.out.println("userdetails service :" + u);
		return new UserDetailImple(u); //userdetail 구현체에 담는다
	}

}

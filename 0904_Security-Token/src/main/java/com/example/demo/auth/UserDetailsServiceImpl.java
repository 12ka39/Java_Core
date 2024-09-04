package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.users.Users;
import com.example.demo.users.UsersDao;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsersDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users u = dao.findById(username) // 사용자 아이디 받아서 인증
		.orElseThrow(
		()->new UsernameNotFoundException("not found username"+username)); // 검색된개 있으면 반환
		System.out.println("userdetails service:"+u);
		return new UserDetailsImpl(u);
	}

}

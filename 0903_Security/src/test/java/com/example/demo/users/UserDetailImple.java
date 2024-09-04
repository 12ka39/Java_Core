package com.example.demo.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDetailImple implements UserDetails { // UserDetails 하면 알아서 생긴다

	private final Users u; // 이 정보를 가지고 인증작업 할 거다 (entity). 이 안에 id, pwd가 들어있다.
	
	public UserDetailImple(Users u) { //생성자
		this.u = u;
	}
	
	
	//user의 권한 정보 설정 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 이 결과를 MySuccessHandler 에서 사용
		List<GrantedAuthority> list = new ArrayList<>(); // 권한이 하나가 아니라 여러개일 수 있기 때문에 List 형태로 
		list.add(new SimpleGrantedAuthority(u.getType()));
		
		return list;
	}

	//
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getPwd();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getId();
	}

	
	// 여기는 마우스 우클릭 -> 오버라이드 해준거 
	// 모두 허용할 거면 return true;

	@Override
	public boolean isAccountNonExpired() { // 계정 만기 여부
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() { // 계정 lock 여부
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() { // 사용 가능한 계정인지
		// TODO Auto-generated method stub
		//return UserDetails.super.isEnabled();
		return true;
	}
	

}

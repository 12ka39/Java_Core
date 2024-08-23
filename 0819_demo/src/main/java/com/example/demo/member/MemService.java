package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemService {
	@Autowired // 의존성 자동 주입
	private MemDao dao; // new 연산자 써서 객체 생성x
	/*
	service는 항상 DB작업을 해야 하니까 dao 객체가 필요하다
	필요한 dao객체를 직접 생성하지 않고 MemDao dao 위에 @Autowired 를 적어주면
	스프링이 알아서 타입이 똑같은 객체를 찾아서 주입해준다.
	(물론 dao에는 @Repository 로 적어줘야 한다)
	*/
	
	public void addMember() {
		dao.insert();
		System.out.println("service addmember");
	}
	
	public void getMember() {
		dao.select();
		System.out.println("service getMember");
	}
	
	public void getAll() {
		dao.selectAll();
		System.out.println("service getAll");
	}
	
	
	public void editMember() {
		dao.update();
		System.out.println("service editMember");
	}
	
	public void delMember() {
		dao.delete();
		System.out.println("service delMember");
	}

}

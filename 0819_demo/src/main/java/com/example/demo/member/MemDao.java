package com.example.demo.member;

import org.springframework.stereotype.Repository;

//dao -> 나중에 mybatis, jpa 사용할 때는 interface로 바꾼다


@Repository // 자동 객체 생성
	// DB작업.  자동으로 서버(톰캣) 메모리에 올라감
public class MemDao {
	public void insert() {
		System.out.println("dao inesrt");
	}
	
	
	public void select() {
		System.out.println("dao select");
	}
	
	public void selectAll() {
		System.out.println("dao selectAll");
	}
	
	
	public void update() {
		System.out.println("dao update");
	}


	public void delete() {
		System.out.println("dao delete");
	}
	
	
}

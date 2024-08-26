package com.example.demo.member;

import org.springframework.stereotype.Repository;

//dao -> 나중에 mybatis, jpa 사용할 때는 interface로 바꾼다


@Repository // 자동 객체 생성
	// DB작업.  자동으로 서버(톰캣) 메모리에 올라감
public class MemDao {
	public void insert() { // 지금 dao까지 가보는 연습해본 거라 쿼리는 없음. 
								// 콘솔에 메시지만 띄워보았다.
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

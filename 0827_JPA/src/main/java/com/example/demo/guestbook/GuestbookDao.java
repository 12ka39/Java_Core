package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestbookDao extends JpaRepository<Guestbook, Integer> {
																		//  Entity          , PK 타입
	
	//JpaRepository에서 기본으로 제공하지 않는 메소드 정의
	// dao 메서드 명은 규칙이 있음  findBy컬럼명
	ArrayList<Guestbook> findByWriter(String writer); // 작성자로 검색

}

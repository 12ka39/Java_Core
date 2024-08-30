package com.example.demo.board;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member;

@Repository
public interface BoardDao extends JpaRepository<Board, Integer> {

	//메소드명은 규칙이 있다. 마음대로 쓰면 안 됨 (메소드 이름 보고 JPA가 실행하기 때문)

	//작성자로 검색
		//findBy컬럼명(컬럼타입) - 컬럼 기준 검색
	public ArrayList<Board> findByWriter (Member writer); 
			// board의 writer는 @ManyToOne (board:member => 다대일) 로 엮여있다. 
	
	
	//타이틀로 검색
		// findBy컬럼명Like(컬럼타입) - like 패턴 검색
	public ArrayList<Board> findByTitleLike (String title);
}


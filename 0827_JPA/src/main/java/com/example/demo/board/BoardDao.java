package com.example.demo.board;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardDao extends JpaRepository<Board, Integer> {

	//작성자로 검색
		//findBy컬럼명(컬럼타입) - 컬럼 기준 검색
	public ArrayList<Board> findByWriter (String writer);
	
	
	//타이틀로 검색
		// findBy컬럼명Like(컬럼타입) - like 패턴 검색
	public ArrayList<Board> findByTitleLike (String title);
}

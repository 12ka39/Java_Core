package com.example.demo.article;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
	ArrayList<Article> findByTitleLike(String title); // 제목으로 검색
	ArrayList<Article> findByDataLike(String data); //자료 확장자로 검색 
	
	
	// 이 세 어노테이션은 import를 잘 확인해야 오류가 나지 않는다.
	@Transactional
	@Modifying
	//@Query는  import가 jpa.repository.Query 가 아니면 오류 뜬다.
	@Query(value="update article set cnt=cnt+1 where num=:num", nativeQuery=true)
	void updateCnt(@Param("num") int num); // 파람으로 받은 글번호 :num
	
}

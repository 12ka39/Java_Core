package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member, String> {
		//JpaRepository 에 DB의 주요 메소드가 들어있다.      //엔터티   , PK의 타입
		//save(), findById()

}

package com.example.demo.member;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

//mybatis.
//mybatis는 따로 설정해줄 거 없고, 프로젝트 만들 때 mybatis 검색해서 추가해주면 된다

@Mapper
public interface MemDao { // dao에서 이렇게 선언만 해주면 mybatis가 알아서 매핑해서 sql을 실행한다
	@Insert("insert into member values(#{id}, #{pwd}, #{name}, #{email}, #{type})")
	void insert(Member b); //vo로 받아온 값을 알아서 매핑한다.
	
	@Select("select * from member where id = ${id}")
	Member select(@Param("id") String id); 
	// @Param("id")는 #{id} 와 String id 가  id면 매칭해주는 거. 지금은 없어도 @Param 실행된다 
	// @Param import 할 때 2개 뜨는데 import org.apache.ibatis.annotations.Param; 로 import
	
	@Update("update member set name=${name}, email=#{email}, type=#{type} where id= #{id} ")
	void update(Member b);
	
	@Delete("delete * from member where id = ${id}")
	void delete(@Param("id") String id);
}

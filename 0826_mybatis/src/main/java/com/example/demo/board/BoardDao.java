package com.example.demo.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardDao {
	
	@Insert("insert into boards(writer,wdate,title,content) values(#{writer},sysdate(), #{title},#{content})")
	public void insert(Board b);
	
	
	@Select("select * from boards where num=#{num}")
	public Board select(@Param("num") int num);

	//전체 목록
	@Select("select * from boards order by num")
	public ArrayList<Board> selectAll();

	
	//제목으로 검색(결과 여러줄)	
	@Select("select * from boards where title like #{title} order by num")
	public ArrayList<Board> selectByTitle(@Param("title") String title);

	
	//작가명으로 검색(결과 여러줄)
	@Select("select * from boards where writer=#{writer} order by num")
	public ArrayList<Board> selectByWriter(String writer);
	

	@Update("update boards set title=#{title}, content=#{content} where num=#{num}")
	public void update(Board b);
	

	@Delete("delete from boards where num=#{num}")
	public void delete(@Param("num") int num);
}

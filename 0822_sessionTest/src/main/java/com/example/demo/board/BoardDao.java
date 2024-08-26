package com.example.demo.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate temp;
	
	public class BoardResultMap implements RowMapper<Board>{

		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Board(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getString(4),
					rs.getString(5)) ;
		}
		
	}
	
	public void insert(Board b) {
		String sql = "insert into board(writer, wdate, title, content) values(?, sysdate(), ?, ?)";
		temp.update(sql, new Object[] {b.getWriter(),  // Date 안 넣습니다. sysdate()로 이미 넣었으니까
				b.getTitle(), b.getContent()});
	}
	
	public Board select(int num) {
		String sql = "select * from board where num = ?";
		Board b = null;
		try {
			b= temp.queryForObject(sql, new BoardResultMap(), num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	
	//여기 어렵다
	public ArrayList<Board> selectAll() {
		String sql = "select * from board order by num";		
		ArrayList<Board> list = (ArrayList<Board>) temp.query(sql, new BoardResultMap());		
		return list;
	}
	
	
	// 글만 보여주기
	public Board content(int num) {
		String sql = "select content from board where num = ?";
		Board b = null;
		b = temp.queryForObject(sql, new BoardResultMap(), num);
		return b;
	}
	
	
	
	//제목, 내용 수정
	public void update(Board b) {
		String sql = "update board set title =?, content =? ";
		temp.update(sql, new Object[] {b.getTitle(), b.getContent()});
	}
	
	
	public void delete(int num) {
		String sql = "delete from board where num = ?";
		temp.update(sql, num);
		
	}
	
	
	
	
	
	//숙제
	public ArrayList<Board>selectByTitle(String title){ // like 패턴 검색 (DB %)
		String sql = "select * from board where title like ? order by num";
		String likePattern = "%" + title + "%";
		ArrayList<Board> list  =  (ArrayList<Board>) temp.query(sql, new BoardResultMap(), likePattern);
		return list;
	}
	

	public ArrayList<Board>selectByWriter(String writer){ // like 패턴 검색 (DB %)
		String sql = "select * from board where writer like ? order by num";
		String likePattern = "%" + writer + "%";
		ArrayList<Board> list  =  (ArrayList<Board>) temp.query(sql, new BoardResultMap(), likePattern);
		return list;
	}
	
	
}

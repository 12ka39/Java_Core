package com.example.demo.guestbook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GuestBookDao {
	@Autowired // 의존성 자동 주입
	private JdbcTemplate temp; // 사용할 jdbcTemplate 객체 의존성 주입.  pom.xml 의존성에 추가해줘야 뜬다
	
	//resultMap 정의 -- 이거 클래스입니다...
	/*
	 public class 클래스명 implements RowMapper<Vo>{  //RowMapper(인터페이스)
    public Vo mapRow(ResultSet rs, int rowNum){  // mapRow(추상메서드) -- 이건 자동으로 호출될 때 파라미터 다 채워진다
        return new Vo(rs.getInt(1), rs.getString(2)...);  // 우리는 이 부분만 작성하면 된다
    }
}
	 */
	// -- 이걸 써야 하는 이유: 검색 결과와 VO의 매핑 정보 작성하는 클래스
	public class GuestResultMap implements RowMapper<GuestBook>{// 검색된 결과 담을 VO
		//GuestResultMap 클래스 명은 아무거나
		
		@Override //RowMapper의 추상메서드 mapRow  구현
		public GuestBook mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new GuestBook(rs.getInt(1), rs.getString(2), rs.getString(3), 
					rs.getDate(4), rs.getString(5));
		} 
		//mapRow 검색된 횟수만큼 자동으로 반복
		// mapRow(ResultSet rs, int rowNum)  rs는 객체 1개 담을 상자고, rowNum은 행번호로
		// for문처럼 돌 때마다 1,2,3,4,.. 계속 바뀜
			//각 컬럼을 vo 생성자 파람에 맵핑
	
	}
	
	
	/*
	 - 쓰기 작업(insert, update, delete)
	  jdbcTemplate.update(sql, ?매칭 []) <- ? 에 들어갈 값
	 */
	public void insert(GuestBook gb) {
		String sql = "insert into guestbook(writer, pwd, wdate, content) values(?,?, sysdate(),?)";
		temp.update(sql, new Object[] {gb.getWriter(), gb.getPwd(), gb.getContent()});
	}
	
	
	/*
	 - 한줄읽기
	  jdbcTemplate.queryForObject(sql, ResultMap, pk값)
	 */
	public GuestBook select(int num) {
		String sql = "select * from guestbook where num=?";
		GuestBook gb = null; // 결과 담을 객체
		try { // 검색 결과가 없으면 오류 나니까 예외처리
		gb = temp.queryForObject(sql, new GuestResultMap(), num); // queryForObject() : 한 줄 검색
		} catch (Exception e) {    //    처리할 방법 객체 생성(객체임다),   파라미터로 온 매칭값
			System.out.println(e);
		}
		return gb;
	}
	
	public ArrayList<GuestBook> selectAll(){
		String sql = "select * from guestbook order by num";
		return (ArrayList<GuestBook>) temp.query(sql,  new GuestResultMap());
		
	}
	
	public void update(GuestBook gb) {
		String sql = "update guestbook set content=? where num=?";
		temp.update(sql, new Object[] { gb.getContent(), gb.getNum()} );
	}
	
	
	public void delete(int num) {
		String sql = "delete from guestbook where num = ?";
		temp.update(sql, num);
	}
	
	
	
}

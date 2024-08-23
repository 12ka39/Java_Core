package com.example.demo.city;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import conn.MysqlConnect;

@Repository
public class CityDao {
	private MysqlConnect dbconn; 
	
	
	public CityDao() {
		dbconn = MysqlConnect.getInstance(); //MysqlConnect가 싱글톤(private)이라 객체 생성 불가
	}
	
	
	// 아이디로 (PK) 로 city 한 행 검색
	public City select(int id) {
		Connection conn = dbconn.getConn();
		String sql = "select * from city where id =  ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new City(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5)); // 생성자로 만드는 듯?
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	
	// city 정보 한 행 추가
	public void insert(City city) {
		Connection conn = dbconn.getConn();
		String sql = "insert into city(name, countrycode, district, population) values(?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, city.getName()); //dao부터 하니까 헷갈린다..
			pstmt.setString(2, city.getCountryCode());
			pstmt.setString(3, city.getDistrict());
			pstmt.setInt(4, city.getPopulation());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	// 도시 전체 목록 조회
	public  ArrayList<City> selectAll(){
		ResultSet rs = null;
		ArrayList<City> list = new ArrayList<>();
		
		Connection conn = dbconn.getConn();
		String sql = "select * from city";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new City(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
	
	
	// 한 행에서 population 수정하기
	public void update(City city) {
		Connection conn = dbconn.getConn();
		String sql = "update city set population= ? where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, city.getPopulation()); //dao부터 하니까 헷갈린다..
			pstmt.setInt(2, city.getId());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	
	//delete 한 행 삭제
	public void delete(int id) {
		Connection conn = dbconn.getConn();
		String sql = "delete from city where id=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	
}


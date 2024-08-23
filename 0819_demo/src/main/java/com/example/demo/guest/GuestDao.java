package com.example.demo.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.city.City;

import conn.MysqlConnect;

@Repository
public class GuestDao {
	private MysqlConnect dbconn; 
	
	public GuestDao() {
		dbconn = MysqlConnect.getInstance();
	}

	
	//insert
	public void insert(Guest g) {
		Connection conn = dbconn.getConn();
		String sql = "insert into guestbook(writer, pwd, wdate, content) values(?, ?, sysdate(), ?)";
		
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getWriter());
			pstmt.setString(2, g.getPwd());
			pstmt.setString(3, g.getContent());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//list 목록 조회
	public ArrayList<Guest> selectAll() {
		ResultSet rs = null;
		ArrayList<Guest> list = new ArrayList<>();
		
		Connection conn = dbconn.getConn();
		String sql = "select * from guestbook";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Guest(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getDate(4), rs.getString(5)));
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


	public Guest select(int num) {
		Connection conn = dbconn.getConn();
		String sql = "select * from guestbook where num =  ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Guest(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getDate(4), rs.getString(5));
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
	
	
	
	
	
}

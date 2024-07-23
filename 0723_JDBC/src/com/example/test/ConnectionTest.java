package com.example.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.DBClose;
import com.example.DBConnection;

class ConnectionTest {
	private Connection conn;
	
	
	@BeforeEach
	void init() {
		DBConnection dbconn = new DBConnection();
		this.conn = dbconn.getConnection();
	}
	
	@Test
	void test() {
		assertNotNull(this.conn);
	}
	
	@AfterEach // 매 테스트 후 닫자
	void close() {
		DBClose.dbClose(this.conn); //DBClose.dbClose 이건 직접 클래스, 함수 만든 거
	}

}

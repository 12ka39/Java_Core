package com.example.demo.guest;

import java.sql.Date;

public class Guest {
    private int num; // 글번호
    private String writer; // 작성자
    private String pwd; // 글 비밀번호
    private Date wdate; // 작성일
    private String content; // 내용
    
    
    
	public Guest(int num, String writer, String pwd, Date wdate, String content) {
		super();
		this.num = num;
		this.writer = writer;
		this.pwd = pwd;
		this.wdate = wdate;
		this.content = content;
	}

	

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}





	@Override
	public String toString() {
		return String.format("Guest [num=%s, writer=%s, pwd=%s, wdate=%s, content=%s]", num, writer, pwd, wdate,
				content);
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getWriter() {
		return writer;
	}



	public void setWriter(String writer) {
		this.writer = writer;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public Date getWdate() {
		return wdate;
	}



	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}
    
    
	
    
    
}

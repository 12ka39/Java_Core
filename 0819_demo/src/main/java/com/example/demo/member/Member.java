package com.example.demo.member;

// vo
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String email;
	
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(String id, String pwd, String name, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}


	@Override
	public String toString() {
		return String.format("Member [id=%s, pwd=%s, name=%s, email=%s]", id, pwd, name, email);
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	


}

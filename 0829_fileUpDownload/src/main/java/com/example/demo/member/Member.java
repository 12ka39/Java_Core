package com.example.demo.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//entity

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity // jpa에게 이걸 테이블로 하겠다고 알려줌
public class Member {
	@Id // PK
	private String id; 
	
	//@Column(name="password", nullable=false)
	// 컬럼명 지정,                             null허용 X
	private String pwd; 
	private String name; 
	private String email; 
	private String type; 
}

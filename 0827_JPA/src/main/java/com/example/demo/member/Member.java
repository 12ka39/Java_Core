package com.example.demo.member;

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

@Entity
public class Member {
	@Id
	private String id; 
	
	private String pwd; 
	private String name; 
	private String email; 
	private String type; 
}

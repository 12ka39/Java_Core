package com.example.demo.board;

import java.util.Date;


import com.example.demo.member.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BoardDto {
	private int num;
	private Member writer; // Member 타입 유지
	private Date wdate; 
	private String title;
	private String content;
}


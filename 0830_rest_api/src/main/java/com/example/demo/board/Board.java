package com.example.demo.board;


import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Board {
	@Id // PK 정의
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 넘버링 auto increment
	private int num;
	
	@ManyToOne // board:member => 다대일    (왼쪽에 현재 엔터티 온다) 보드에 멤버가 여럿 작성 가능
	@JoinColumn(nullable=false) //    null허용 X
	@OnDelete(action=OnDeleteAction.CASCADE) // on delete cascade   부모 삭제시 자식도 삭제됨
	private Member writer; // 연관되는 entity 타입으로 지정(Member)  - 실제 테이블 만들어질 땐 String 타입으로 만들어짐
	
	private Date wdate; // import java.util.Date; 이거다.. sql아님..
	private String title;
	private String content;
	
	 // 날짜를 자동으로 생성해서 넣어주는 함수.  sql 안 쓰니까 sysdate() 안 씀.
	@PrePersist  //insert 되기 전 자동 호출
	public void makeDate() {
		wdate = new Date();
	}

}

package com.example.demo.guestbook;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor   // 기본 생성자
@AllArgsConstructor   // 생성자
@ToString
//@Data   -> 디폴트생성자 하나만생긴다
//근데 파라미터 있는 생성자는 안 만들어주니까 @Data 랑 @AllArgsConstructor 추가 필요
//@AllArgsConstructor 근데 모든 객체만 추가하면 또 디폴트 생성자가 사라짐
// 한 줄 요약 @Date 쓰지 말자

//VO
public class GuestBook {  
	private int num;
	private String writer;
	private String pwd;
	private Date wdate; // 날짜
	private String content;
}

/*
 
 create table guestbook(
num int primary key auto_increment,
writer varchar(20) not null,
pwd varchar(20) not null,
wdate date not null,
content varchar(100) not null
);

 <과제>
방명록(vo: 글번호(자동할당), 작성자, 글비밀번호, 작성일(sysdate() 자동할당), 내용)
글작성
글목록
글수정(글비밀번호 물어봐서 맞으면 실행, 아니면 취소)
글삭제(글비밀번호 물어봐서 맞으면 실행, 아니면 취소)

 */

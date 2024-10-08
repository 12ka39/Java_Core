package com.example.demo.guestbook;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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

@Entity   // JPA entity (이걸 테이블로 만들거야)
public class Guestbook {
	@Id  // PK 정의
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-Increment  (자동 넘버링)
						// 이 strategy는 DB마다 다르게 설정해야 함
	private int num; // 숫자는 pk로 정의하고 AI 로 설정
	
	//@Column(name="author", nullable=true/false): 컬럼의 이름과 속성을 설정
	// nullable=true/false   null 허용 (true)
	private String writer;
	private Date wdate;
	private String pwd;
	private String content;
	
	/*
	//파일 업로드시
	private String path; // 파일 주소
	
	@Transient // 컬럼으로 만들지 마시오
	private MultipartFile f;
	*/
	
	 // 날짜를 자동으로 생성해서 넣어주는 함수.  sql 안 쓰니까 sysdate() 못 쓰니까 따로 함수를 만들어 준다.
	@PrePersist  //insert 되기 전 자동 호출
	public void makeDate() {
		wdate = new Date();
	}

}

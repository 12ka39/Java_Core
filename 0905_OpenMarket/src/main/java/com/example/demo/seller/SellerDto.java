package com.example.demo.seller;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.users.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SellerDto {
	private int proNum; // 상품번호
	private Users writer;
	
	private String proName; // 상품명
	private String proDescript; // 상품설명
	private int proPrice; // 가격
	private int proAmount;
	
	private String proImg; // 이미지 경로 주소
	
	private MultipartFile f; // 파일 데이터
	
}

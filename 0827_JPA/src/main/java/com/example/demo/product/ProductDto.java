package com.example.demo.product;

import org.springframework.web.multipart.MultipartFile;

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

public class ProductDto {
	private int num;
	private String name;
	private int price;
	private int amount;
	private Member seller;
	private String img;
	
	private MultipartFile f; // 폼에서 전송한 이미지 저장할 변수
	// private MultipartFile[] f;  여러 개의 파일을 올릴 때
	
	// 이건 Product (@Entity클래스) 에는 없다. Product는 이미지 경로(img)만 저장하고,
	// 실제 이미지 데이터는 Dto인 MultipartFile f에 저장
}

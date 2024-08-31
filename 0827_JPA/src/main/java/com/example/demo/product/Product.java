package com.example.demo.product;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.member.Member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Generate 발생시키다, 만들어내다
	private int num;
	private String name;
	private int price;
	private int amount;
	
	@ManyToOne	
	@JoinColumn(nullable = false) // 외래 키(Foreign Key)로 사용할 컬럼을 지정,  이 외래 키 컬럼이 NULL 값을 가질 수 없음
																								// 즉, seller는 항상 Member 테이블의 한 행을 참조
	
	/*
	 기본적으로 외래 키 컬럼의 이름은 seller_id처럼 필드명 뒤에 _id가 붙습니다. 
	 이는 Member 테이블의 기본 키와 매핑됩니다.

	 @JoinColumn(nullable = false)은 Product 테이블에 있는 외래 키 컬럼(seller_id와 같은 이름이 기본값)을 
	 Member 테이블의 id와 매핑합니다. 
	 또한, nullable = false는 이 외래 키가 반드시 값이 있어야 함을 의미합니다.
	 *
	 */
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Member seller; // fk로 다른 테이블과 엮여있으니까 타입이 Member
									//Member테이블과 fk로 엮겠다
	
	private String img;  // 상품 이미지 경로
	
	
	/* 
	 
	상품(Product) 
	num(pk 자동할당), 
	seller(fk. member(id), 
	img경로(String)

	 */

}

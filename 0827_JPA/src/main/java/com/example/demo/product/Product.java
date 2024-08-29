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
	private int num;
	private String name;
	private int price;
	private int amount;
	
	@ManyToOne	
	@JoinColumn(nullable = false)
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

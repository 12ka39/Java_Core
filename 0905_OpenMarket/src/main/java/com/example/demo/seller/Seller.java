package com.example.demo.seller;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.example.demo.users.Users;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int proNum; // 상품번호
	
	
	@ManyToOne // 다대일
	@JoinColumn(nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Users writer;
	
	
	private String proName; // 상품명
	private String proDescript; // 상품설명
	private int proPrice; // 가격
	private int proAmount; // 수량
	
	private String proImg; // 이미지 경로
}


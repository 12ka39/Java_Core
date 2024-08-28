package com.example.demo.product;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.member.Member;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	//판매자로 검색
	                          // findBy컬럼명(컬럼타입)
	ArrayList<Product> findBySeller(Member seller); 
	
	//상품명으로 검색
	                           //findBy컬럼명Like(컬럼타입) 
	ArrayList<Product> findByNameLike(String name);
	
	//가격으로 검색
	                           //findBy컬럼Between(값1, 값2) 
	ArrayList<Product> findByPriceBetween(int p1, int p2);
}
